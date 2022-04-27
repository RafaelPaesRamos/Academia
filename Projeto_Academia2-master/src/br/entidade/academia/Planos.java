/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.entidade.academia;

/**
 *
 * @author Rafael&Lais
 */
public class Planos {
    private String tipoPlano;
    private String tipoVigencia;
    private Integer cod_plano;
    private String tipoTreinos;
    
    
    public Planos() {
        
        
    }
    public Planos(String tipoPlano, String tipoVigencia, String tipoTreinos) {
        this.tipoPlano = tipoPlano;
        this.tipoVigencia = tipoVigencia;
        this.tipoTreinos = tipoTreinos;
        
        
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public String getTipoTreinos() {
        return tipoTreinos;
    }

    public void setTipoTreinos(String tipoTreinos) {
        this.tipoTreinos = tipoTreinos;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public Integer getCod_plano() {
        return cod_plano;
    }

    public void setCod_plano(Integer cod_plano) {
        this.cod_plano = cod_plano;
    }

    public String getTipoVigencia() {
        return tipoVigencia;
    }

    public void setTipoVigencia(String tipoVigencia) {
        this.tipoVigencia = tipoVigencia;
    }
    
}
