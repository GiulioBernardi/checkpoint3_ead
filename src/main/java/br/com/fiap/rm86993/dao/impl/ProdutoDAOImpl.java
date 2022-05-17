package br.com.fiap.rm86993.dao.impl;

import br.com.fiap.rm86993.entity.Pedido;
import br.com.fiap.rm86993.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProdutoDAOImpl extends HibernateGenericDAO<Produto, Long>{

    private static ProdutoDAOImpl instance = null;

    public static ProdutoDAOImpl getInstance() {
        if(instance == null){
            instance = new ProdutoDAOImpl();
        }
        return instance;
    }

    private ProdutoDAOImpl() {
        super(Produto.class);
    }


    public List<Produto> listarPorValor(Double valor, EntityManager entityManager){
        TypedQuery<Produto> consulta = entityManager.createNamedQuery("Produto.listar", Produto.class);
        consulta.setParameter("valor", valor);
        return consulta.getResultList();
    }

    public List<Produto> listarPorNomeParecido (String nome, EntityManager entityManager){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);

        Root<Produto> produto = criteriaQuery.from(Produto.class);

        Predicate predicate = builder.like(produto.get("nome"), nome + "%");
        criteriaQuery.select(produto);
        criteriaQuery.where(predicate);

        TypedQuery<Produto> consulta = entityManager.createQuery(criteriaQuery);

        return consulta.getResultList();
    }

    public List<Produto> listarBuscandoPorValor (int valor, EntityManager entityManager){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);

        Root<Produto> produto = criteriaQuery.from(Produto.class);

        Predicate predicate = builder.equal(produto.get("valor"), valor);
        criteriaQuery.select(produto);
        criteriaQuery.where(predicate);

        TypedQuery<Produto> consulta = entityManager.createQuery(criteriaQuery);

        return consulta.getResultList();
    }
}
