/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.vendas.dao;

import com.ifta.vendas.model.Cliente;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ifta
 */
@Dependent
public class ClienteDAO {
    
    @Inject
    EntityManager em;
    
    public void add(Cliente cliente){
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }
    
    public Cliente cliente(Long id){
        return em.find(Cliente.class, id);
    }
   
    public List<Cliente> listClientes(){
        Query query= em.createQuery("from Cliente");
        return query.getResultList();
    }
    
    public void remove (Cliente cliente){
        em.getTransaction().begin();
        Cliente c=em.find(Cliente.class, cliente.getId());
        em.remove(c);
        em.getTransaction().commit();        
    }
    
    public void update(Cliente cliente){
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }
}
