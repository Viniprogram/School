package br.com.sisescola.transferencia;

import java.awt.*; 
import javax.swing.*;

public class DesktopImagem extends JDesktopPane{
  private ImageIcon iiImagem;

  public DesktopImagem(String imagem){
    iiImagem = new ImageIcon(getClass().getResource(imagem));
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);    
    iiImagem.paintIcon(this,g,0,0);
  }

  public Dimension getPreferredSize(){     
    return new Dimension(iiImagem.getIconWidth(), iiImagem.getIconHeight());    
  }
}