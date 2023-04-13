package model;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Douglas
 */
public class Sales {
    
    private int id;
    private int ticketId;
    private float valorVenda;

    public Sales(int id, int ticketid, float valorVenda) {
        this.id = id;
        this.ticketId = ticketid;
        this.valorVenda = valorVenda;
    }
    
    public Sales(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketid) {
        this.ticketId = ticketid;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        Locale localeBR = new Locale ("pt","BR");
        NumberFormat valorVendaFormat = NumberFormat.getCurrencyInstance(localeBR);
        return "" + valorVendaFormat.format(valorVenda);
    }
    
    
    
}
