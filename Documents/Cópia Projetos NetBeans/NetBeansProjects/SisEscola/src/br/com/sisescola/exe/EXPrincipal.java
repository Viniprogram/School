package br.com.sisescola.exe;

import br.com.sisescola.view.APPrincipal;
import javax.swing.UIManager;

public class EXPrincipal {
    public static void main(String[] args)throws Exception {
        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());            
        } catch (Exception e) {e.printStackTrace();}
        
        new APPrincipal().setVisible(true);
    }
}

