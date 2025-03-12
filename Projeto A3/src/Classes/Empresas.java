/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Empresas {

    /**
     * @return the Codigo
     */
    public String getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }


    private String Razaosocial;
    private String Email;
    private String Cnpj;
    private String Senha;
    private String Logradouro;
    private String Complementos;
    private String Bairro;
    private String Uf;
    private String Cidade;
    private String Cep;
    private String Codigo;
    
    public Empresas() {
    }
    
    public Empresas(String Razaosocial, String Email, String Cnpj, String Senha, String Logradouro, String Complementos, String Uf, String Bairro, String Cidade, String Cep) {
        this.Razaosocial = Razaosocial;
        this.Email = Email;
        this.Cnpj = Cnpj;
        this.Senha = Senha;
        this.Logradouro = Logradouro;
        this.Complementos = Complementos;
        this.Uf = Uf;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
        this.Cep = Cep;
                
    }
    
    public Empresas(String Cnpj, String Senha) {
        this.Cnpj = Cnpj;
        this.Senha = Senha;
    }

    
    
    
    public String getRazaosocial() {
        return Razaosocial;
    }

    public void setRazaosocial(String Razaosocial) {
        this.Razaosocial = Razaosocial;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
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
String sql = "INSERT INTO tb_empresa(razaosocial, senha, email, cnpj, logradouro, complementos, bairro, uf, cidade, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//2: Abrir uma conexão
ConnectionFactory factory = new ConnectionFactory();
try (Connection c = factory.obtemConexao()){
//3: Pré compila o comando
PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
ps.setString(1, Razaosocial);
ps.setString(2, Senha);
ps.setString(3, Email);
ps.setString(4, Cnpj);
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
    String sql = "Select * from tb_empresa where cnpj = ? and senha = ?";

    ConnectionFactory factory = new ConnectionFactory();

    try (Connection c = factory.obtemConexao()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, Cnpj);
        ps.setString(2, Senha);
        try (ResultSet rs = ps.executeQuery()){
            if (rs.next()) { 
            System.out.println("teste sql = " + rs.getString("nome"));
            Razaosocial = rs.getString("nome");
            Cnpj = rs.getString("cpf");
            Senha = rs.getString("senha");
            System.out.println("Login bem-sucedido: " + this.Razaosocial);
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
String sql = "UPDATE tb_empresa SET razaosocial = ?, senha = ?, email = ?, logradouro = ?, complementos = ?, bairro = ?, uf = ?, cidade = ?, cep = ? WHERE cnpj = ?";
//2: Abrir uma conexão
ConnectionFactory factory = new ConnectionFactory();
try (Connection c = factory.obtemConexao()){
//3: Pré compila o comando
PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
ps.setString(1, Razaosocial);
ps.setString(2, Senha);
ps.setString(3, Email);
ps.setString(4, Cnpj);
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
String sql = "DELETE FROM tb_empresa WHERE cnpj = ?";
//2: Abrir uma conexão
ConnectionFactory factory = new ConnectionFactory();
try (Connection c = factory.obtemConexao()){
//3: Pré compila o comando
PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
ps.setString(1, Cnpj);
//5: Executa o comando
ps.execute();
}
catch (Exception e){
e.printStackTrace();
}
}
}

