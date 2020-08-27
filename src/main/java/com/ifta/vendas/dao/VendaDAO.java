package com.ifta.vendas.dao;

import com.ifta.vendas.model.Venda;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

//Significado de @Dependent: Um objeto será criado para cada clase que precisar dessa classe ou seja descreve 
//        a mesma situação que ocorre quando criamos objetos(new)
@Dependent
public class VendaDAO {

    @Inject
    EntityManager em;

    public void add(Venda venda) {
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }

    public Venda venda(int id) {
        return em.find(Venda.class, id);
    }

    public List<Venda> listVendas() {
        final String jpql = "select v from Venda v "
                + "inner join v.cliente "
                + "inner join v.itens ";
        TypedQuery<Venda> query = em.createQuery(jpql, Venda.class);
        return query.getResultList();
    }

    public List<Venda> vendasByCliente(String login) {
        final String jpql = "select v from Venda v "
                + "inner join v.cliente "
                + "inner join v.itens "
                +"where v.cliente.login =:login";
        TypedQuery<Venda> query = em.createQuery(jpql, Venda.class);
        query.setParameter("login", login);
        return query.getResultList();
    }

    public void remove(Venda venda) {
        em.getTransaction().begin();
        Venda v = em.find(Venda.class, venda.getId());
        em.remove(v);
        em.getTransaction().commit();
    }

    public void update(Venda venda) {
        em.getTransaction().begin();
        em.merge(venda);
        em.getTransaction().commit();
    }

}
