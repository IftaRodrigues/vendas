/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.vendas.validation.impl;

import com.ifta.vendas.dao.ClienteDAO;
import com.ifta.vendas.model.Cliente;
import com.ifta.vendas.validation.LoginAvailable;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author ifta
 */

public class LoginAvailableValidator implements  ConstraintValidator<LoginAvailable, Cliente>{
    
    @Inject
    private ClienteDAO clienteDAO;
    
    @Override
    public void initialize(LoginAvailable constraintAnnotation) {
    }

    @Override
    public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {
        return !clienteDAO.containsWithLogin(cliente.getLogin());
    }
    
}
