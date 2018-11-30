package br.com.sisescola.view;

import br.com.sisescola.transferencia.Disciplina;
import br.com.sisescola.dao.DisciplinaDAO;
import br.com.sisescola.transferencia.Professor;
import br.com.sisescola.transferencia.ModeloGrade;
import br.com.sisescola.dao.ProfessorDAO;
import java.sql.*;
import static javax.swing.JOptionPane.*;
import javax.swing.*;

public class APDisciplina extends APCadastro {
    private JComboBox<Professor> coProfessor;
    
    public APDisciplina(){
        super("Cadastro de Disciplinas",500,3);
        
        coProfessor = new JComboBox<Professor>();
        
        pnRotulos.add(new JLabel(" Professor: "));
        pnCampos.add(coProfessor);
        
        try {
            coProfessor.setModel(new DefaultComboBoxModel<Professor>(new ProfessorDAO().carregarCombo()));
        } catch (Exception e) {
            showMessageDialog(this, e.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void atualizarGrade(){
        try {
            ResultSet rs = new DisciplinaDAO().carregarGrade();
            tbDados.setModel(new ModeloGrade(rs,new String[]{"Código","Nome","Disciplina"}));
            tbDados.getColumnModel().getColumn(0).setMaxWidth(50);
        } catch (Exception e) {
            showMessageDialog(this, e.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void incluir(){
        Disciplina d = new Disciplina();
        d.setNome(tfNome.getText());
        Professor professor = (Professor)coProfessor.getSelectedItem();
        d.setIdProfessor(professor.getCodpro());
        
        try {
            new DisciplinaDAO().incluir(d);
            atualizarGrade();
            tpAbas.setSelectedIndex(0);            
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void alterar(){
        Disciplina d = new Disciplina();
        d.setCoddis(tfCodigo.getText());
        d.setNome(tfNome.getText());
        Professor professor = (Professor)coProfessor.getSelectedItem();
        d.setIdProfessor(professor.getCodpro());
        
        try {
            new DisciplinaDAO().alterar(d);
            atualizarGrade();
            tpAbas.setSelectedIndex(0);            
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void excluir(){
        try {
            int codigo = Integer.parseInt(tfCodigo.getText());
            new DisciplinaDAO().excluir(codigo);
            ModeloGrade dtm = (ModeloGrade)tbDados.getModel();
            dtm.removeRow(tbDados.getSelectedRow());
            tpAbas.setSelectedIndex(0);
            atualizarGrade();
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
        }
    }
    
    protected void carregarRegistro(String codigo)throws Exception{
        Disciplina d = new DisciplinaDAO().pesquisar(codigo);
        tfCodigo.setText(String.valueOf(d.getCoddis()));
        tfNome.setText(d.getNome());
        coProfessor.setSelectedItem(new ProfessorDAO().pesquisar(d.getIdProfessor()));
    }     
}

    
