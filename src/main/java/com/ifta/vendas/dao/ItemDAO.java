
package com.ifta.vendas.dao;

import com.ifta.vendas.model.ItemVenda;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

//Significado de @Dependent: Um objeto será criado para cada clase que precisar dessa classe ou seja descreve 
//        a mesma situação que ocorre quando criamos objetos(new)
@Dependent
public class ItemDAO {
    @Inject
    EntityManager em;

    public void add(ItemVenda item){
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    public ItemVenda item(int id){
        return em.find(ItemVenda.class, id);
    }

    public List<ItemVenda> listItens(){
        Query query= em.createQuery("from ItemVenda");
        return query.getResultList();
    }

    public void remove(ItemVenda item){
        em.getTransaction().begin();
        ItemVenda i = em.find(ItemVenda.class, item.getId());
        em.remove(i);
        em.getTransaction().commit();
    }

    public void update(ItemVenda item){
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }
    
}
