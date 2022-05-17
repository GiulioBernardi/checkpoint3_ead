package br.com.fiap.rm86993.dao.impl;

import br.com.fiap.rm86993.dto.PedidoBoletoDTO;
import br.com.fiap.rm86993.entity.Boleto;
import br.com.fiap.rm86993.entity.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class PedidoDAOImpl extends HibernateGenericDAO<Pedido, Long> {
    private static PedidoDAOImpl instance = null;

    public static PedidoDAOImpl getInstance() {
        if(instance == null){
            instance = new PedidoDAOImpl();
        }
        return instance;
    }

    private PedidoDAOImpl() {
        super(Pedido.class);
    }

    public List<Pedido> listarPorCpf (String cpf, EntityManager entityManager){
        String jpql = "SELECT p FROM Pedido p WHERE p.cpfCliente = :cpf";

        TypedQuery<Pedido> consulta = entityManager.createQuery(jpql, Pedido.class);

        consulta.setParameter("cpf", cpf);
        return consulta.getResultList();
    }

    public List<Pedido> listarPedidoComBoleto(EntityManager entityManager){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pedido> criteriaQuery = builder.createQuery(Pedido.class);

        Root<Pedido> pedido = criteriaQuery.from(Pedido.class);
        Join<Pedido, Boleto> boleto = (Join) pedido.fetch("boleto");
        criteriaQuery.select(pedido);

        TypedQuery<Pedido> consulta = entityManager.createQuery(criteriaQuery);

        return consulta.getResultList();
    }
}
