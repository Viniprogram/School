package br.com.sisescola.view;

import br.com.sisescola.transferencia.Departamento;
import br.com.sisescola.dao.DepartamentoDAO;
import br.com.sisescola.transferencia.ModeloGrade;
import java.sql.*;
import static javax.swing.JOptionPane.*;
import javax.swing.*;

public class APDepartamento extends APCadastro {
        
    public APDepartamento(){
        super("Cadastro de Departamentos",500,2);        
    }
    
    protected void atualizarGrade(){
        try {
            ResultSet rs = new DepartamentoDAO().carregarGrade();
            tbDados.setModel(new ModeloGrade(rs,new String[]{"Código","Nome"}));
            tbDados.getColumnModel().getColumn(0).setMaxWidth(50);
        } catch (Exception e) {
            showMessageDialog(this, e.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void incluir(){
        Departamento d = new Departamento();
        d.setNome(tfNome.getText());
        
        try {
            new DepartamentoDAO().incluir(d);
            atualizarGrade();
            tpAbas.setSelectedIndex(0);            
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void alterar(){
        Departamento d = new Departamento();
        d.setCoddep(tfCodigo.getText());
        d.setNome(tfNome.getText());
                
        try {
            new DepartamentoDAO().alterar(d);
            atualizarGrade();
            tpAbas.setSelectedIndex(0);            
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void excluir(){
        try {
            
            int codigo = Integer.parseInt(tfCodigo.getText());
            new DepartamentoDAO().excluir(codigo);
            ModeloGrade dtm = (ModeloGrade)tbDados.getModel();
            dtm.removeRow(tbDados.getSelectedRow());
            tpAbas.setSelectedIndex(0);
            atualizarGrade();
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void carregarRegistro(String codigo)throws Exception{
        Departamento d = new DepartamentoDAO().pesquisar(codigo);
        tfCodigo.setText(String.valueOf(d.getCoddep()));
        tfNome.setText(d.getNome());       
    }     
}

    
