/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.vendas.interceptor;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import com.ifta.vendas.annotations.Public;
import com.ifta.vendas.controller.ClientesController;
import com.ifta.vendas.model.ClienteLogado;
import javax.inject.Inject;

/**
 *
 * @author ifta
 */
@Intercepts
public class AutorizadorInterceptor {
    
    @Inject private ClienteLogado clienteLogado;
    @Inject private Result result;
    @Inject private ControllerMethod controllerMethod;
        
    @Accepts
    public boolean accepts(){
        return !controllerMethod.containsAnnotation(Public.class);
    }
    
    @AroundCall
    public void intercepta(SimpleInterceptorStack stack){
        if (clienteLogado.getCliente() == null) {
            result.redirectTo(ClientesController.class).loginForm();
            return;
        }
        stack.next();
    }
}
