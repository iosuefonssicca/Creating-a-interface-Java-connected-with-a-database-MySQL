/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Endereco;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author josue.silva
 */
public class EnderecoDAOTest {
    
    public EnderecoDAOTest() {
    }

    @Test
    public void inserir() {
        
        Endereco endereco = new Endereco("Goias", "Trindade", "Serra Dourada", "Idalina Maria", "1");
        EnderecoDAO dao = new EnderecoDAO();
        
        if(dao.inserir(endereco)){
            System.out.println("Inserido com sucesso!");
        }else{
            fail("Não foi inserido.");
        }
        
    }
    @Test
    @Ignore
    public void listar(){
        EnderecoDAO dao = new EnderecoDAO();
        
        for(Endereco e: dao.buscarTodos()){
            System.out.println("Estado "+e.getEstado());
        }
    }
    @Test
    @Ignore
    public void atualizar() {
        
        Endereco endereco = new Endereco("Sao Paulo", "Sao Paulo", "Santo Amaro", "Idalina Maria", "1");
        endereco.setidEndereco(1);
        EnderecoDAO dao = new EnderecoDAO();
        
        if(dao.atualizar(endereco)){
            System.out.println("Atualizado com sucesso!");
        }else{
            fail("Não foi atualizado.");
        }
        
    }
    @Test
    @Ignore
    public void deletar(){
        Endereco endereco = new Endereco();
        endereco.setidEndereco(1);
        EnderecoDAO dao = new EnderecoDAO();
        
        if(dao.deletar(endereco)){
            System.err.println("Deletado com sucesso!");
        }else{
            fail("Delete falhou.");
        }
    }
}
