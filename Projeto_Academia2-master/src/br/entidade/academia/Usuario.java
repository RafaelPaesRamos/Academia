/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.entidade.academia;

import java.io.Serializable;


/**
 *
 * @author arthu
 */
public class Usuario implements Serializable{
    private Integer id;
    private String login;
    private String senha;

    public Usuario() {
    }

    public Usuario(Integer id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
