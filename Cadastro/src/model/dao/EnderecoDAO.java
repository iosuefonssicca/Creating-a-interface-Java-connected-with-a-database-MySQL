/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.FabricadeConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Endereco;

/**
 *
 * @author josue.silva
 */
public class EnderecoDAO {
    private Connection con = null;

    public EnderecoDAO() {
     con = FabricadeConexao.getConnection();
    }
    
    public boolean inserir(Endereco endereco){
        
        String sql = "INSERT INTO endereco (estado,cidade,bairro,rua,numero) VALUES (?,?,?,?,?);";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, endereco.getEstado());
            stmt.setString(2, endereco.getCidade());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getRua());
            stmt.setString(5, endereco.getNumero());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Não foi possível fazer a inserção! "+ex);
            return false;
        }finally{
            FabricadeConexao.closeConnection(con, stmt);
        }
    }
    public List<Endereco> buscarTodos(){
        String sql = "SELECT * FROM endereco;"; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Endereco> enderecos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Endereco endereco = new Endereco();
                endereco.setEstado(rs.getString("estado"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                enderecos.add(endereco);
            }
        } catch (SQLException ex) {
          System.err.println("Não foi possível fazer a inserção! "+ex);  
        }finally{
            FabricadeConexao.closeConnection(con, stmt, rs);
        }
        return enderecos;
}
    public boolean atualizar(Endereco endereco){
        
        String sql = "UPDATE endereco SET estado = ? WHERE idEndereco = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, endereco.getEstado());
            stmt.setInt(2, endereco.getidEndereco());
            /*stmt.setString(2, endereco.getCidade());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getRua());
            stmt.setString(5, endereco.getNumero());*/
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Não foi possível fazer a inserção! "+ex);
            return false;
        }finally{
            FabricadeConexao.closeConnection(con, stmt);
        }
    }
    public boolean deletar(Endereco endereco){
        
        String sql = "DELETE FROM endereco WHERE idEndereco = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, endereco.getidEndereco());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Não foi possível fazer a inserção! "+ex);
            return false;
        }finally{
            FabricadeConexao.closeConnection(con, stmt);
        }
    }
}
