package br.com.sisescola.view;

import br.com.sisescola.dao.ProfessorDAO;
import br.com.sisescola.transferencia.Professor;
import java.sql.*;
import static javax.swing.JOptionPane.*;

public class APProfessor extends APCadastro {
        
    public APProfessor(){
        super("Cadastro de Professores",500,2);        
    }
    
    protected void atualizarGrade(){
        try {
            ResultSet rs = new ProfessorDAO().carregarGrade();
            tbDados.setModel(new ModeloGrade(rs,new String[]{"Código","Nome"}));
            tbDados.getColumnModel().getColumn(0).setMaxWidth(50);
        } catch (Exception e) {
            showMessageDialog(this, e.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void incluir(){
        Professor p = new Professor();
        p.setNome(tfNome.getText());
        
        try {
            new ProfessorDAO().incluir(p);
            atualizarGrade();
            tpAbas.setSelectedIndex(0);            
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void alterar(){
        Professor p = new Professor();
//        p.setCodpro(tfCodigo.getText());
        p.setNome(tfNome.getText());
                
        try {
            new ProfessorDAO().alterar(p);
            atualizarGrade();
            tpAbas.setSelectedIndex(0);            
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void excluir(){
        try {
            int codigo = Integer.parseInt(tfCodigo.getText());
            new ProfessorDAO().excluir(codigo);
            ModeloGrade dtm = (ModeloGrade)tbDados.getModel();
            dtm.removeRow(tbDados.getSelectedRow());
            tpAbas.setSelectedIndex(0);
            atualizarGrade();
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void carregarRegistro(String codigo)throws Exception{
        Professor p = new ProfessorDAO().pesquisar(codigo);
 //       tfCodigo.setText(String.valueOf(p.getCodpro()));
        tfNome.setText(p.getNome());       
    }     
}

    
