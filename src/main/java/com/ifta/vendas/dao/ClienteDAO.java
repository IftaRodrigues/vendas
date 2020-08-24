/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.vendas.dao;

import com.ifta.vendas.model.Cliente;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ifta
 */
@RequestScoped
public class ClienteDAO {
    
    @Inject
    EntityManager em;
    
    public void add(Cliente cliente){
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }
    
    public Cliente cliente(String login){
        return em.find(Cliente.class, login);
    }
   
    public List<Cliente> listClientes(){
        Query query= em.createQuery("from Cliente");
        return query.getResultList();
    }
    
    public void remove (Cliente cliente){
        em.getTransaction().begin();
        Cliente c=em.find(Cliente.class, cliente.getLogin());
        em.remove(c);
        em.getTransaction().commit();        
    }
    
    public void update(Cliente cliente){
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }
    
    //conta quantos clientes com o loguin, usado para validar se cliente já existe
    public boolean containsWithLogin(String login) {
        Long contador= em.createQuery("select count(c) from Cliente c where c.login= :login", Long.class)
                                            .setParameter("login", login)
                                            .getSingleResult();
        return contador >0;
    }
}
