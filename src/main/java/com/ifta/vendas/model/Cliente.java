/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.vendas.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author ifta
 */
@Entity
public class Cliente implements Serializable {
    @Id
    @NotNull(message = "{obrigatorio}")
    private String login;

    @NotNull(message = "{obrigatorio}")
    private String senha;

    @NotNull(message = "{obrigatorio}")
    private String nome;

    @NotNull(message = "{obrigatorio}")
    private String cpf;

//    @OneToMany
//    @JoinColumn(name = "id_vendas")
//    private List<Venda> compras= new ArrayList<Venda>();
    
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

//    public List<Venda> getCompras() {
//        return compras;
//    }
//
//    public void setCompras(List<Venda> compras) {
//        this.compras = compras;
//    }
}
