/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Classes.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ConnectionFactory {
private String usuario = "root";
private String senha = "root";
private String host = "localhost";
private String porta = "3306";
private String bd = "db_pessoas";


public Connection obtemConexao (){
try{
Connection c = DriverManager.getConnection(
"jdbc:mysql://" + host + ":" + porta + "/" + bd + "?serverTimezone=UTC",
usuario,
senha);
    System.out.println("Conectou");
return c;
}
catch (Exception e){
e.printStackTrace();
    System.out.println("ERRO");

return null;
}
}
public boolean existe (Usuario usuario) throws Exception{
String sql = "SELECT * FROM tb_usuario WHERE cpf = ? AND senha = ";;
try (Connection c = obtemConexao();
PreparedStatement ps = c.prepareStatement(sql)){
ps.setString(1, usuario.getCpf());
ps.setString(2, usuario.getSenha());
try (ResultSet rs = ps.executeQuery()){
return rs.next();
}
}
}
}

