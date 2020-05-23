
package com.ifta.vendas.dao;

import com.ifta.vendas.model.Produto;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

//Significado de @Dependent: Um objeto será criado para cada clase que precisar dessa classe ou seja descreve 
//        a mesma situação que ocorre quando criamos objetos(new)
@Dependent
public class ProdutoDAO {
    
    @Inject
    EntityManager em;

    public void add(Produto produto){
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    public Produto produto(Long id){
        return em.find(Produto.class, id);
    }

    public List<Produto> listProdutos(){
        Query query= em.createQuery("from Produto");
        return query.getResultList();
    }

    public void remove(Produto produto){
        em.getTransaction().begin();
        Produto p = em.find(Produto.class, produto.getId());
        em.remove(p);
        em.getTransaction().commit();
    }

    public void update(Produto produto){
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
    }
    
}
