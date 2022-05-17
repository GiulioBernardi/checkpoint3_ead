package br.com.fiap.rm86993.dao.impl;

import br.com.fiap.rm86993.entity.Boleto;
import br.com.fiap.rm86993.entity.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class BoletoDAOImpl extends HibernateGenericDAO<Boleto, Long> {

    private static BoletoDAOImpl instance = null;

    public static BoletoDAOImpl getInstance() {
        if(instance == null){
            instance = new BoletoDAOImpl();
        }
        return instance;
    }

    public BoletoDAOImpl() {
        super(Boleto.class);
    }

    public List<Boleto> listarCriteria (EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Boleto> criteriaQuery = builder.createQuery(Boleto.class);

        Root<Boleto> boleto = criteriaQuery.from(Boleto.class);
        criteriaQuery.select(boleto);

        TypedQuery<Boleto> consulta = entityManager.createQuery(criteriaQuery);

        return consulta.getResultList();
    }


}
