/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.vendas.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ifta
 */

public class ClienteLogado {
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
