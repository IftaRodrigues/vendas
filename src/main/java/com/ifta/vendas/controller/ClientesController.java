/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.vendas.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import com.ifta.vendas.dao.ClienteDAO;
import com.ifta.vendas.model.Cliente;
import com.ifta.vendas.model.ClienteLogado;
import com.ifta.vendas.validation.LoginAvailable;
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
    private ClienteLogado clienteLogado;

    @Inject
    private Result result;

    @Inject
    private Validator validator;

    public void form() {
    }

    public void loginForm() {
    }

    @IncludeParameters
    public void adiciona(@Valid @LoginAvailable Cliente cliente) {
        validator.validate(cliente);
        validator.onErrorForwardTo(this).form();

        clienteDAO.add(cliente);
        result.redirectTo(ProdutosController.class).lista();
    }

    public void login(String login, String senha) {
        Cliente c = clienteDAO.find(login, senha);
        if (c == null) {
            //não conseguiu acessar properties então coloquei a mensagem diretamente
            validator.add(new SimpleMessage("login", "Login ou senha inválidos."));
            validator.onErrorForwardTo(this).loginForm();
        }
        clienteLogado.setCliente(c);
        result.redirectTo(ProdutosController.class).lista();
    }

    public void lista() {
        List<Cliente> clientes = clienteDAO.listClientes();
        result.include("clientes", clientes);
    }

    public void logout() {
        clienteLogado.logout();
        result.redirectTo(ProdutosController.class).lista();
    }
}
