/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Endereco;
import model.bean.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author josue.silva
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }
    @Ignore
    @Test
    public void inserir() {
        
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        Endereco endereco = new Endereco();
        
        endereco.setidEndereco(1);
        usuario.setNome("Josue");
        usuario.setSobrenome("Fonseca");
        usuario.setDataNasc("18/03/1999");
        usuario.setSexo("M");
        usuario.setEmail("josuefonseca17@outlook.com");
        usuario.setTelefone("0000000");
        usuario.setCelular("99999999");
        usuario.setEndereco(endereco);
        
        if(dao.inserir(usuario)){
            System.err.println("Inserido com sucesso!");
        }else{
            fail("Falha na inserção.");
        }
        
    }
    @Test
    public void listar(){
        
        UsuarioDAO dao = new UsuarioDAO();
        
        for(Usuario usuario: dao.buscarTodos()){
            System.out.println(" Nome "+usuario.getNome()+" Rua "+usuario.getEndereco().getCidade());
        }
        
        
    }
    
}
