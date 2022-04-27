/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade.academia;

import java.util.Date;

/**
 *
 * @author arthu
 */
public class Cliente {

    private Integer matricula;
    private String nomeCliente;
    private String sobreNomeCliente;
    private String sexoCliente;
    private String pesoCliente;
    private String alturaCliente;
    private String enderecoCliente;
    private String cidadeEstadoCliente;
    private String email;

    public Cliente() {

    }

    public Cliente(Integer matricula,String nomeCliente, String sobreNome, String sexo,
            String pesoCliente, String alturaCliente, String enderecoCliente,
            String cidadeEstadoCliente, Date horaTreino) {
        
        this.matricula = matricula;
        this.nomeCliente = nomeCliente;
        this.sobreNomeCliente = sobreNome;
        this.sexoCliente = sexo;
        this.pesoCliente = pesoCliente;
        this.alturaCliente = alturaCliente;
        this.enderecoCliente = enderecoCliente;
        this.cidadeEstadoCliente = cidadeEstadoCliente;
        this.email = email;

    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getSobreNomeCliente() {
        return sobreNomeCliente;
    }

    public void setSobreNomeCliente(String sobreNomeCliente) {
        this.sobreNomeCliente = sobreNomeCliente;
    }

    public String getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    public String getPesoCliente() {
        return pesoCliente;
    }

    public void setPesoCliente(String pesoCliente) {
        this.pesoCliente = pesoCliente;
    }

    public String getAlturaCliente() {
        return alturaCliente;
    }

    public void setAlturaCliente(String alturaCliente) {
        this.alturaCliente = alturaCliente;
    }

    public String getEndereçoCliente() {
        return enderecoCliente;
    }

    public void setEndereçoCliente(String endereçoCliente) {
        this.enderecoCliente = endereçoCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCidadeEstadoCliente() {
        return cidadeEstadoCliente;
    }

    public void setCidadeEstadoCliente(String cidadeEstadoCliente) {
        this.cidadeEstadoCliente = cidadeEstadoCliente;
    }

}
