/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.vendas.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import com.ifta.vendas.dao.ClienteDAO;
import com.ifta.vendas.model.Cliente;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;

/**
 *
 * @author ifta
 */
@Controller
public class ClientesController {

    @Inject
    private ClienteDAO clienteDAO;

    @Inject
    private Result result;
    
    @Inject
    private Validator validator;
    
    public void form(){}
    
    @IncludeParameters
    public void adiciona(@Valid Cliente cliente){
        //Cliente c= clienteDAO.cliente(cliente.getLogin());
        
//        if(c !=null){
////            falta configurar o erro na jsp
//            validator.add(new SimpleMessage("login.invalido", "usuario ja exixte", ""));
//            
//        }
        validator.onErrorForwardTo(this).form();
        clienteDAO.add(cliente);
        result.redirectTo(this).lista();
    }

    public void lista() {
        List<Cliente> clientes=clienteDAO.listClientes();
        result.include("clientes", clientes);
    }
}
