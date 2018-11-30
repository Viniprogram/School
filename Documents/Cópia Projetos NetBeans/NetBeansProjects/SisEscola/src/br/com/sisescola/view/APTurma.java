package br.com.sisescola.view;

import br.com.sisescola.transferencia.ModeloGrade;
import br.com.sisescola.transferencia.Turma;
import br.com.sisescola.dao.TurmaDAO;
import java.sql.*;
import static javax.swing.JOptionPane.*;
import javax.swing.*;

public class APTurma extends APCadastro {
        
    public APTurma(){
        super("Cadastro de Turmas",500,2);        
    }
    
    protected void atualizarGrade(){
        try {
            ResultSet rs = new TurmaDAO().carregarGrade();
            tbDados.setModel(new ModeloGrade(rs,new String[]{"Código","Nome"}));
            tbDados.getColumnModel().getColumn(0).setMaxWidth(50);
        } catch (Exception e) {
            showMessageDialog(this, e.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void incluir(){
        Turma t = new Turma();
        t.setNome(tfNome.getText());
                
        try {
            new TurmaDAO().incluir(t);
            atualizarGrade();
            tpAbas.setSelectedIndex(0);            
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void alterar(){
        Turma t = new Turma();
        t.setCodtur(tfCodigo.getText());
        t.setNome(tfNome.getText());
                
        try {
            new TurmaDAO().alterar(t);
            atualizarGrade();
            tpAbas.setSelectedIndex(0);            
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void excluir(){
        try {
            int codigo = Integer.parseInt(tfCodigo.getText());
            new TurmaDAO().excluir(codigo);
            ModeloGrade dtm = (ModeloGrade)tbDados.getModel();
            dtm.removeRow(tbDados.getSelectedRow());
            tpAbas.setSelectedIndex(0);
            atualizarGrade();
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void carregarRegistro(String codigo)throws Exception{
        Turma t = new TurmaDAO().pesquisar(codigo);
        tfCodigo.setText(String.valueOf(t.getCodtur()));
        tfNome.setText(t.getNome());        
    }     
}

    