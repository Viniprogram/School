package br.com.sisescola.accessories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoEscola{
  private static Connection conexao;

  public ConexaoEscola()throws Exception{
    try{
      if(conexao != null && !conexao.isClosed())return;
      Class.forName("com.mysql.jdbc.Driver");
      conexao = DriverManager.getConnection(
        "jdbc:mysql://localhost/escola","root","mavica2001");
      conexao.setAutoCommit(false);
      conexao.setTransactionIsolation(
        Connection.TRANSACTION_READ_COMMITTED);
    }
    catch(ClassNotFoundException cnf){
      throw new Exception("Driver não encontrado!");
    }
    catch(SQLException sql){
      throw new Exception("Falha ocorrida: " + sql.getMessage());
    }
  }

  public Connection getConexao(){
    return conexao;
  }

  public void fechar()throws Exception{
    try{
      if(conexao == null || conexao.isClosed()) return;
         conexao.close();
    }
    catch(SQLException sql){
      throw new Exception("Falha ocorrida: " + sql.getMessage());
    }
  }

  public void confirmarTransacao()throws Exception{
    try{
      if(conexao == null || conexao.isClosed()) return;
         conexao.commit();
    }
    catch(SQLException sql){
      throw new Exception("Falha ocorrida: " + sql.getMessage());
    }
  }

  public void cancelarTransacao()throws Exception{
    try{
      if(conexao == null || conexao.isClosed()) return;
         conexao.rollback();
    }
    catch(SQLException sql){
      throw new Exception("Falha ocorrida: " + sql.getMessage());
    }
  }
}
