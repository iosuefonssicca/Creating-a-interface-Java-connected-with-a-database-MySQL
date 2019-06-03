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
import model.bean.Usuario;

/**
 *
 * @author josue.silva
 */
public class UsuarioDAO {

    private Connection con = null;

    public UsuarioDAO() {
        con = FabricadeConexao.getConnection();
    }

    public boolean inserir(Usuario usuario) {

        String sql = "INSERT INTO usuario (nome, sobrenome, dataNasc, sexo, email, telefone, celular, idEndereco) VALUES (?,?,?,?,?,?,?,?);";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getDataNasc());
            stmt.setString(4, usuario.getSexo());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());
            stmt.setString(7, usuario.getCelular());
            stmt.setInt(8, usuario.getEndereco().getidEndereco());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Não foi possível fazer a inserção! " + ex);
            return false;
        } finally {
            FabricadeConexao.closeConnection(con, stmt);
        }
    }
    public List<Usuario> buscarTodos(){
        String sql = "select * from usuarioendereco_vw;"; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Usuario usuario = new Usuario();
                usuario.setidUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setDataNasc(rs.getString("dataNasc"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setEmail(rs.getString("email"));
                
                Endereco endereco = new Endereco();
                endereco.setidEndereco(rs.getInt("idEndereco_e"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                
                usuario.setEndereco(endereco);
                produtos.add(usuario);
            }
        } catch (SQLException ex) {
          System.err.println("Não foi possível fazer a inserção! "+ex);  
        }finally{
            FabricadeConexao.closeConnection(con, stmt, rs);
        }
        return produtos ;
}
}
