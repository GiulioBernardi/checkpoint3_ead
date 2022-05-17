package br.com.fiap.rm86993.service.impl;

import br.com.fiap.rm86993.dao.impl.ProdutoDAOImpl;
import br.com.fiap.rm86993.entity.Pedido;
import br.com.fiap.rm86993.entity.Produto;
import br.com.fiap.rm86993.service.GenericService;

import java.util.List;

public class ProdutoServiceImpl extends GenericService<Produto, Long> {
    private static ProdutoServiceImpl instance = null;
    private ProdutoDAOImpl produtoDAO;

    private ProdutoServiceImpl(){
        this.produtoDAO = ProdutoDAOImpl.getInstance();
    }

    public static ProdutoServiceImpl getInstance(){
        if(instance == null){
            instance = new ProdutoServiceImpl();
        }
        return instance;
    }

    public List<Produto> listarPorValor(Double valor){
        List<Produto> produtos = null;

        try {
            produtos = produtoDAO.listarPorValor(valor,getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return produtos;
    }

    @Override
    public void inserir(Produto produto) {
        try {
            produtoDAO.salvar(produto, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Produto produto) {
        try {
            produtoDAO.atualizar(produto, getEntityManager());
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try {
            produtoDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public Produto obter(Long id) {
        Produto produto = null;

        try {
            produto = produtoDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return produto;
    }

    @Override
    public List<Produto> listar() {
        List<Produto> produtos = null;

        try {
//			alunos = alunoDAO.listar(getEntityManager());
            produtos = produtoDAO.listar(getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return produtos;
    }

    public List<Produto> listarPorNomeParecido(String nome){
        List<Produto> produtos = null;

        try {
            produtos = produtoDAO.listarPorNomeParecido(nome, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return produtos;
    }

    public List<Produto> listarBuscandoPorValor(int valor){
        List<Produto> produtos = null;

        try {
            produtos = produtoDAO.listarBuscandoPorValor(valor, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return produtos;
    }
}
