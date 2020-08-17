/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.vendas.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import com.ifta.vendas.dao.ProdutoDAO;
import com.ifta.vendas.dao.VendaDAO;
import com.ifta.vendas.model.ItemVenda;
import com.ifta.vendas.model.Produto;
import com.ifta.vendas.model.Venda;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

@Controller
public class VendasController {
    
    @Inject
    private VendaDAO dao;
    
    @Inject
    private Venda venda;
    
    @Inject
    private ProdutoDAO produtoDao;
    
    
    @Inject
    private Result result;
    
    
    
    public void carrinhoDeCompras(){
        result.include("produtoList", produtoDao.listProdutos());
    }
    
    public void adicionaItem(ItemVenda itemVenda){        
       Produto p= produtoDao.produto(itemVenda.getProduto().getId());
       
       itemVenda.setProduto(p);
       venda.getItens().add(itemVenda);
       
       result.redirectTo(this).carrinhoDeCompras();
    }
    
    public void adicionaVenda(){
        venda.setDate(new Date());
        dao.add(venda);
        venda.getItens().clear();
        
        result.redirectTo(this).lista();
    }
    
    public List<Venda> lista() {
        return dao.listVendas();
    }

    public void remove(int id) {
        Venda venda=dao.venda(id);
        dao.remove(venda);
        result.redirectTo(this).lista();
    }

}
