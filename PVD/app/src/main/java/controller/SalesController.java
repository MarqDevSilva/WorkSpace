package controller;

import Util.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Sales;

/**
 *
 * @author Douglas
 */
public class SalesController {
    
    public void save(Sales sales) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSetId = null;
        ResultSet rsIndice = null;
                
        try{
            String sqlId = "SELECT MAX(ID) FROM ticket";
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sqlId);
            statement.executeQuery();
            resultSetId = statement.executeQuery();
            
            if(resultSetId.next()){
                    String sql = "INSERT INTO sales (id, ticketid, valorvenda) VALUES (?, ?, ?)";
                    statement = connection.prepareStatement(sql);
                    statement.setInt(1, sales.getId());
                    statement.setInt(2, resultSetId.getInt(1));
                    statement.setFloat(3, sales.getValorVenda());
                    statement.execute();
            }
        } catch (Exception ex){
            throw new RuntimeException ("Erro ao cadastrar venda" + ex.getMessage(), ex);
        } finally{
            connectionFactory.closeConnection(connection, statement);
            }
        } 
        
    public void removeById(int id) {
        String sql = "DELETE FROM sales WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{ 
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception ex){
            throw new RuntimeException ("Erro ao deletar a venda" + ex.getMessage(), ex);
        } finally {
            connectionFactory.closeConnection(connection, statement);
        }    
    }
    
    public List<Sales> getAll(){
   
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSetId = null;
        
        List<Sales> vendas = new ArrayList<>();
        
        
        try{ 
            String sqlId = "SELECT MAX(ID) FROM ticket";
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sqlId);
            statement.executeQuery();
            resultSetId = statement.executeQuery();

            
            if(resultSetId.next()){
                String sql = "SELECT * FROM sales WHERE ticketid = ?";
                connection = connectionFactory.getConnection();
                statement = connection.prepareStatement(sql);
                statement.setInt(1, resultSetId.getInt(1));
                statement.executeQuery();
                resultSet = statement.executeQuery();
            }
            
            while(resultSet.next()){
                
                Sales sale = new Sales();
                sale.setId(resultSet.getInt("id"));
                sale.setTicketId(resultSet.getInt("ticketid"));
                sale.setValorVenda(resultSet.getFloat("valorvenda"));
         
                vendas.add(sale);
            }
        } catch (Exception ex){
            throw new RuntimeException ("Erro ao deletar a venda" + ex.getMessage(), ex);
        } finally {
            connectionFactory.closeConnection(connection, statement, resultSet);
        }   
        
        //Retronar lista de terafa criada
        return vendas;
        
    }
    
}
