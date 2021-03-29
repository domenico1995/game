package com.gioco;

import com.gioco.data.User;
import com.gioco.data.testi;
import com.gioco.manager.Manager_user;
import com.gioco.manager.Manager_gioco;
import com.gioco.manager.Manager_opzioni;
import com.gioco.service.comandi;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class Engine extends comandi{

    private String testo = "";
    
    private String testo_display = testi.ins_nome.testo();
    
    private JTextArea j;
    
    private User u;

    public Engine() {
        init();
    }

    public void init() {
        u = new User();
    }

    public void getWord(String text, String text_display, JTextArea jt, JTextField jf) 
            throws SQLException, IOException, InterruptedException  {
        
        if(text.equals("exit")){
            
            System.exit(0);
        }else if (text_display.equals(testi.ins_nome.testo())) {
            u.setNome(text);
            setTesto(text);
            setTesto_display(testi.ins_cognome.testo());
        } else if (text_display.equals(testi.ins_cognome.testo())) {
            u.setCognome(text);
            setTesto_display(testi.ins_username.testo());
        } else if (text_display.equals(testi.ins_username.testo())) {
            u.setUsername(text);
            reset_area(jt);
            reset_field(jf);
            setTesto_display("ciao " + u.getUsername()+ "\n");  
        }else{
            esegui(text);
            time_stop();
            setTesto(text +"\n");
            setTesto_display(getRisp());
        }        
    }
    
    public String getTesto(){return testo;}
    
    public void setTesto(String text){this.testo = text;}
    
    public String getTesto_display(){return testo_display;}
    
    public void setTesto_display(String text_display){this.testo_display = text_display;}
    
    public void reset_area(JTextArea jt){
        jt.setText("");
        setTesto_display("");
    }
    
    public void reset_field(JTextField jf){
        jf.setText("");
        setTesto("");
    }
    
    public void time_stop(){
        if (getRisp()== null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
