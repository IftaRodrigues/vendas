package com.ifta.vendas.dao;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Dependent
public class JpaUtil {
    
    @ApplicationScoped
    @Produces
    public EntityManagerFactory factory() {
        return Persistence.createEntityManagerFactory("conexao2");
    }


    @Produces
    public EntityManager manager(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }


    public void close(@Disposes EntityManagerFactory factory) {
        factory.close();
    }  

    public void close(@Disposes EntityManager manager) {
        manager.close();
    } 
    
}
