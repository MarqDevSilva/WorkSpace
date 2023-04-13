package controller;


import Util.connectionFactory;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Ticket;

/**
 *
 * @author Douglas
 */
public class TicketController {
    
    public void save(Ticket ticket) {
        String sql = "INSERT INTO ticket (dataticket, valortotal) VALUES (?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(ticket.getCreatdAT().getTime()));
            statement.setFloat(2, 0);
            statement.execute();
        } catch (Exception ex){
            throw new RuntimeException ("Erro ao criar ticket " + ex.getMessage(), ex);
        } finally{
            connectionFactory.closeConnection(connection, statement);
            }
        }
    
    public void update() throws SQLException {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSetId = null;
        try{
            String sqlID = "SELECT MAX(ID) FROM ticket";
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sqlID);
            statement.executeQuery();
            resultSetId = statement.executeQuery();
                    
            if(resultSetId.next()){
                String sql = "SELECT SUM(valorvenda) FROM sales WHERE ticketid = ?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, resultSetId.getInt(1));
                statement.executeQuery();
                resultSet = statement.executeQuery();
                
                 if(resultSet.next()){
                    Ticket ticket = new Ticket();
                    ticket.setValorTotal(resultSet.getFloat(1));
                    String sqlSum = "UPDATE ticket SET valortotal = ? WHERE id = ?";
                    statement = connection.prepareStatement(sqlSum);
                    statement.setFloat(1, ticket.getValorTotal());
                    statement.setInt(2, resultSetId.getInt(1));
                    statement.execute();  
                }
            }
        } catch (Exception ex){
            throw new RuntimeException ("Erro ao somar valores " + ex.getMessage(), ex);
        } finally{
                connectionFactory.closeConnection(connection, statement);
             }
        }
    
    public String totalVenda() throws SQLException{
        String sql = "SELECT ID, valortotal FROM ticket ORDER BY ID DESC LIMIT 1";
                
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Ticket ticket = new Ticket();
        
        try { 
           
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeQuery();
            resultSet = statement.executeQuery();
            
            if(resultSet.next()){
                ticket.setValorTotal(resultSet.getFloat("valortotal"));
            }
        }catch(Exception ex){
           throw new RuntimeException ("Erro ao retornar valor" + ex.getMessage(), ex); 
        } finally {
            connectionFactory.closeConnection(connection, statement, resultSet);
        }
    return ticket.toString2();
    }
    
    public List<Ticket> getDate(Date date){
        String sql = "SELECT * FROM ticket WHERE dataticket = ?";
                
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Ticket> tickets = new ArrayList<>();

        try { 
           
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(date.getTime()));
            statement.executeQuery();
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                
                Ticket ticket = new Ticket ();
                ticket.setId(resultSet.getInt("id"));
                ticket.setCreatdAT(resultSet.getDate("dataticket"));
                ticket.setValorTotal(resultSet.getFloat("valortotal"));
         
                tickets.add(ticket);
            }
        } catch (Exception ex){
            throw new RuntimeException ("Erro ao carregar historico" + ex.getMessage(), ex);
        } finally {
            connectionFactory.closeConnection(connection, statement, resultSet);
        }   
        
        //Retronar lista de terafa criada
        return tickets;
    }
}
