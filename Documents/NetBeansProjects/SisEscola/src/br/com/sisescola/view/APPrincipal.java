package br.com.sisescola.view;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JOptionPane.*;

public class APPrincipal extends JFrame implements ActionListener {
    private DesktopImagem desktop;
    private JMenuBar mbBarra;
    private JToolBar tbNorte;
    private JMenu meCadastro;
  //  private JMenu mePedido;
  //  private JMenu meSistema;
    private JMenuItem miTurma;
    private JMenuItem miAluno;
    private JMenuItem miProfessor;
    private JMenuItem miDisciplina;
    private JMenuItem miDpto;
    private JMenuItem miFuncionario;    
   // private JMenuItem miSobre;
    private JButton btTurma;
    private JButton btAluno;
    private JButton btProfessor;
    private JButton btDisciplina;
    private JButton btDpto;
    private JButton btFuncionario;
        
    public APPrincipal(){        
        setTitle("Sistema de Gerenciamento Escolar");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        mbBarra = new JMenuBar();
        mbBarra.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tbNorte = new JToolBar("Barra 1",JToolBar.HORIZONTAL);
        meCadastro = new JMenu("Cadastros");        
        meCadastro.setFont(new Font("Helvetica",Font.BOLD,13));        
       // meSistema = new JMenu("Sistema");
        miTurma = new JMenuItem("Turmas");
        miTurma.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miAluno = new JMenuItem("Alunos");
        miAluno.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miProfessor = new JMenuItem("Professores");
        miProfessor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miDisciplina = new JMenuItem("Disciplinas");
        miDisciplina.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miDpto = new JMenuItem("Departamentos");
        miDpto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miFuncionario = new JMenuItem("Funcionários"); 
        miFuncionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
     //   miSobre = new JMenuItem("Sobre ...");
        
        btTurma = new JButton();
        btTurma.setToolTipText("Cadastro de Turmas");
        btTurma.setFocusable(false);
        
        btAluno = new JButton();
        btAluno.setToolTipText("Cadastro de Alunos");
        btAluno.setFocusable(false);
        
        btProfessor = new JButton();
        btProfessor.setToolTipText("Cadastro de Professores");
        btProfessor.setFocusable(false);
        
        btDisciplina = new JButton();
        btDisciplina.setToolTipText("Cadastro de Disciplinas");
        btDisciplina.setFocusable(false);
        
        btDpto = new JButton();
        btDpto.setToolTipText("Cadastro de Departamentos");
        btDpto.setFocusable(false);
        
        btFuncionario = new JButton();
        btFuncionario.setToolTipText("Cadastro de Funcionários");
        btFuncionario.setFocusable(false);
        
        meCadastro.setMnemonic('C');
                
        setJMenuBar(mbBarra);
        mbBarra.add(meCadastro);
       // mbBarra.add(meSistema);
        meCadastro.add(miTurma);
        meCadastro.add(miAluno);
        meCadastro.add(miProfessor);
        meCadastro.add(miDisciplina);
        meCadastro.add(miDpto);
        meCadastro.add(miFuncionario);
        //meSistema.add(miSobre);
        tbNorte.add(btTurma);
        tbNorte.add(btAluno);
        tbNorte.add(btProfessor);
        tbNorte.add(btDisciplina);
        tbNorte.add(btDpto);
        tbNorte.add(btFuncionario);
                
        desktop = new DesktopImagem("Tigre.jpg");
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(desktop,BorderLayout.CENTER);
        getContentPane().add(tbNorte,BorderLayout.NORTH);
        pack();
        
        miTurma.addActionListener(this);
        miAluno.addActionListener(this);
        miProfessor.addActionListener(this);
        miDisciplina.addActionListener(this);
        miDpto.addActionListener(this);
        miFuncionario.addActionListener(this);        
       // miSobre.addActionListener(this);
        
        Toolkit kit = Toolkit.getDefaultToolkit();  
        Dimension dm = kit.getScreenSize();
        int larg = dm.width;        
        int alt = dm.height;
        setSize(larg, alt);      
    }
        
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == miTurma)cadastrarTurma();
        else if(source == miAluno)try {
            cadastrarAluno();
        } catch (Exception ex) {
            showMessageDialog(this, "Erro no cadastro de aluno" + ex);
        }
        else if(source == miProfessor)cadastrarProfessor();
        else if(source == miDisciplina)cadastrarDisciplina();
        else if(source == miDpto)cadastrarDepartamento();
        else if(source == miFuncionario)try {
            cadastrarFuncionario();
        } catch (Exception ex) {
            showMessageDialog(this, "Erro no cadastro de funcionário" + ex);
        }
        //else if(source == miSobre)sobre();                
    }
    
    private void cadastrarTurma(){
        APTurma janela = new APTurma();
        janela.setLocation(430, 200);
        desktop.add(janela);
        janela.setVisible(true);
    }
    
    private void cadastrarAluno() throws Exception{
        APAluno janela = new APAluno();
        janela.setLocation(230,10);
        desktop.add(janela);
        janela.setVisible(true);
    }
    
    private void cadastrarProfessor(){
        APProfessor janela = new APProfessor();
        janela.setLocation(430,200);
        desktop.add(janela);
        janela.setVisible(true);
    }
    
    private void cadastrarDisciplina(){
        APDisciplina janela = new APDisciplina();
        janela.setLocation(430, 200);
        desktop.add(janela);
        janela.setVisible(true);
    }
    
    private void cadastrarDepartamento(){
        APDepartamento janela = new APDepartamento();
        janela.setLocation(430, 200);
        desktop.add(janela);
        janela.setVisible(true);
    }
    
    private void cadastrarFuncionario() throws Exception{
        APFuncionario1 janela = new APFuncionario1();
        janela.setLocation(230, 130);
        desktop.add(janela);
        janela.setVisible(true);
    }
       
  /*  private void sobre(){
        showOptionDialog(this,"Sistema de Registro de Pedidos \nVersão 1.0 \nAutor: Vinícius Albuquerque" +
                "\nTodos os direitos reservados", "Sobre ...",0,3,null,new String[]{"Fechar"},"Fechar");
    }*/
}

