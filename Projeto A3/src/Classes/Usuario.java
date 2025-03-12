/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAO.ConnectionFactory;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Usuario {


    private String Nome;
    private String Email;
    private String Cpf;
    private String Senha;
    private int adm;
    private String Logradouro;
    private String Complementos;
    private String Bairro;
    private String Uf;
    private String Cidade;
    private String Cep;
    
    public Usuario() {
    }
    
    public Usuario(String Nome, String Email, String Cpf, String Senha, int adm, String Logradouro, String Complementos, String Uf, String Bairro, String Cidade, String Cep) {
        this.Nome = Nome;
        this.Email = Email;
        this.Cpf = Cpf;
        this.Senha = Senha;
        this.adm = adm;
        this.Logradouro = Logradouro;
        this.Complementos = Complementos;
        this.Uf = Uf;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
        this.Cep = Cep;
                
    }
    
    public Usuario(String Cpf, String Senha) {
        this.Cpf = Cpf;
        this.Senha = Senha;
    }

    
    
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public int getAdm() {
        return adm;
    }

    public void setAdm(int adm) {
        this.adm = adm;
    }
      public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }
     public String getComplementos() {
        return Complementos;
    }

    public void setComplementos(String Complementos) {
        this.Complementos = Complementos;
    }
    public String getBairro (){
        return Bairro;
    }
    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }
    public String getUf () {
        return Uf;
    }
    public void setUf (String Uf){
        this.Uf = Uf;
    }
    public String getCidade () {
        return Cidade;
    }
    public void setCidade (String Cidade){
        this.Cidade = Cidade;
    }
    public String getCep () {
        return Cep;
    }
    public void setCep (String Cep){
        this.Cep = Cep;
    }
    
    public void Inserir () {
    //1: Definir o comando SQL
String sql = "INSERT INTO tb_usuario(nome, senha, email, cpf, logradouro, complementos, bairro, uf, cidade, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//2: Abrir uma conexão
ConnectionFactory factory = new ConnectionFactory();
try (Connection c = factory.obtemConexao()){
//3: Pré compila o comando
PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
ps.setString(1, Nome);
ps.setString(2, Senha);
ps.setString(3, Email);
ps.setString(4, Cpf);
ps.setString(5, Logradouro);
ps.setString(6, Complementos);
ps.setString(7, Bairro);
ps.setString(8, Uf);
ps.setString(9, Cidade);
ps.setString(10, Cep);

//5: Executa o comando
ps.execute();
    JOptionPane.showMessageDialog(null, "Usuario inserido com sucesso");
}
catch (Exception e){
e.printStackTrace();
}
}
    public boolean login() throws SQLException 
{
    String sql = "Select * from tb_usuario where cpf = ? and senha = ?";

    ConnectionFactory factory = new ConnectionFactory();

    try (Connection c = factory.obtemConexao()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, Cpf);
        ps.setString(2, Senha);
        try (ResultSet rs = ps.executeQuery()){
            if (rs.next()) { 
            System.out.println("teste sql = " + rs.getString("nome"));
            Nome = rs.getString("nome");
            Cpf = rs.getString("cpf");
            Senha = rs.getString("senha");
            System.out.println("Login bem-sucedido: " + this.Nome);
            return (true);
            }
            else {
                    System.out.println("Credenciais não encontradas");
                    return false;
                }
        }
}
}
    
    public void atualizar (){
//1: Definir o comando SQL
String sql = "UPDATE tb_usuario SET nome = ?, senha = ?, email = ?, logradouro = ?, complementos = ?, bairro = ?, uf = ?, cidade = ?, cep = ? WHERE cpf = ?";
//2: Abrir uma conexão
ConnectionFactory factory = new ConnectionFactory();
try (Connection c = factory.obtemConexao()){
//3: Pré compila o comando
PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
ps.setString(1, Nome);
ps.setString(2, Senha);
ps.setString(3, Email);
ps.setString(4, Cpf);
ps.setString(5, Logradouro);
ps.setString(6, Complementos);
ps.setString(7, Bairro);
ps.setString(8, Uf);
ps.setString(9, Cidade);
ps.setString(10, Cep);

//5: Executa o comando
ps.execute();
JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
}
catch (Exception e){
e.printStackTrace();
}
}
    public void apagar (){
//1: Definir o comando SQL
String sql = "DELETE FROM tb_usuario WHERE cpf = ?";
//2: Abrir uma conexão
ConnectionFactory factory = new ConnectionFactory();
try (Connection c = factory.obtemConexao()){
//3: Pré compila o comando
PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
ps.setString(1, Cpf);
//5: Executa o comando
ps.execute();
}
catch (Exception e){
e.printStackTrace();
}
}
}
   
    
    
    
    
   
