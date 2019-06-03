/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;
/**
 *
 * @author josue.silva
 */
public class Usuario {
    
    private int idUsuario;
    private String nome;
    private String sobrenome;
    private String dataNasc;
    private String sexo;
    private String email;
    private String telefone;
    private String celular;
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String dataNasc, String sexo, String email, String telefone, String celular, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
    }
    public int getidUsuario() {
        return idUsuario;
    }

    public void setidUsuario(int IdUsuario) {
        this.idUsuario = IdUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
