package model;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Douglas
 */
public class Ticket {
    
    private int id;
    private Date creatdAT;
    private float valorTotal;

    public Ticket(int id, Date creatdAT, float valorTotal) {
        this.id = id;
        this.creatdAT = creatdAT;
        this.valorTotal = valorTotal;   
    }
    
    public Ticket(){
        this.creatdAT = new Date(); 
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatdAT() {
          return creatdAT;
    }

    public void setCreatdAT(Date creatdAT) {
        this.creatdAT = creatdAT;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;  
    }

    @Override
    public String toString() {
        Locale localeBR = new Locale ("pt","BR");
        NumberFormat valorTotalFormat = NumberFormat.getCurrencyInstance(localeBR);
        return creatdAT + "    -   " + valorTotalFormat.format(valorTotal);
    }
    
    public String toString2() {
        Locale localeBR = new Locale ("pt","BR");
        NumberFormat valorTotalFormat = NumberFormat.getCurrencyInstance(localeBR);
        return "    " + valorTotalFormat.format(valorTotal);
    }
    
    
    
    
}
