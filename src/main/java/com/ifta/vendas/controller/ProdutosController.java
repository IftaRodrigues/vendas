/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.vendas.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import com.ifta.vendas.dao.ProdutoDAO;
import com.ifta.vendas.model.Produto;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author iftar
 */
@Controller
public class ProdutosController {
    
    @Inject
    private ProdutoDAO dao;
    
    @Inject
    private Result result;
    
    @Inject
    private Validator validator;
    
    public void form(){}
    
    public void adiciona(Produto produto){
        validator.validate(produto);
        validator.onErrorRedirectTo(this).form();
        
        if(produto.getId() == null){
            dao.add(produto);
        }else{
            dao.update(produto);
        }
        
        result.redirectTo(this).lista();
    }
    
    public List<Produto> lista() {
        return dao.listProdutos();
    }

    public void remove(Long id) {
        Produto produto=dao.produto(id);
        dao.remove(produto);
        result.redirectTo(this).lista();
    }

    public void editar(Long id) {
        Produto produto=dao.produto(id);
        result.include(produto);
        result.redirectTo(this).form();
    }
}
