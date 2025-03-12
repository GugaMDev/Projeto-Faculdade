/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Agendamento {

    /**
     * @return the Codigo
     */
    public int getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }


    private String Objeto;
    private String Kg;
    private String Endereco;
    private String Horario;
    private String Obs;
    private String Dia;
    private String Mes;
    private String Ano;
    private int Codigo;
    
    public Agendamento() {
    }
    
    public Agendamento(String Objeto, String Kg, String Endereco, String Horario, String Obs, String Dia, String Mes, String Ano) {
        this.Objeto = Objeto;
        this.Kg = Kg;
        this.Endereco = Endereco;
        this.Horario = Horario;
        this.Obs = Obs;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Ano = Ano;
                
    }

    /**
     * @return the Objeto
     */
    public String getObjeto() {
        return Objeto;
    }

    /**
     * @param Objeto the Objeto to set
     */
    public void setObjeto(String Objeto) {
        this.Objeto = Objeto;
    }

    /**
     * @return the Kg
     */
    public String getKg() {
        return Kg;
    }

    /**
     * @param Kg the Kg to set
     */
    public void setKg(String Kg) {
        this.Kg = Kg;
    }

    /**
     * @return the Endereco
     */
    public String getEndereco() {
        return Endereco;
    }

    /**
     * @param Endereco the Endereco to set
     */
    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    /**
     * @return the Horario
     */
    public String getHorario() {
        return Horario;
    }

    /**
     * @param Horario the Horario to set
     */
    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    /**
     * @return the Obs
     */
    public String getObs() {
        return Obs;
    }

    /**
     * @param Obs the Obs to set
     */
    public void setObs(String Obs) {
        this.Obs = Obs;
    }

    /**
     * @return the Dia
     */
    public String getDia() {
        return Dia;
    }

    /**
     * @param Dia the Dia to set
     */
    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    /**
     * @return the Mes
     */
    public String getMes() {
        return Mes;
    }

    /**
     * @param Mes the Mes to set
     */
    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    /**
     * @return the Ano
     */
    public String getAno() {
        return Ano;
    }

    /**
     * @param Ano the Ano to set
     */
    public void setAno(String Ano) {
        this.Ano = Ano;
    }
     public void Inserir () {
    //1: Definir o comando SQL
String sql = "INSERT INTO tb_agendamento(objeto,kg,endereco,horario,obs,dia,mes,ano) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//2: Abrir uma conexão
ConnectionFactory factory = new ConnectionFactory();
try (Connection c = factory.obtemConexao()){
//3: Pré compila o comando
PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
ps.setString(1, Objeto);
ps.setString(2, Kg);
ps.setString(3, Endereco);
ps.setString(4, Horario);
ps.setString(5, Obs);
ps.setString(6, Dia);
ps.setString(7, Mes);
ps.setString(8, Ano);


//5: Executa o comando
ps.execute();
    JOptionPane.showMessageDialog(null, "Agendamento feito com sucesso");
}
catch (Exception e){
e.printStackTrace();
}
}
}