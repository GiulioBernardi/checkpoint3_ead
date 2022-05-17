package br.com.fiap.rm86993.service.impl;

import br.com.fiap.rm86993.dao.impl.ItemPedidoDAOImpl;
import br.com.fiap.rm86993.entity.ItemPedido;
import br.com.fiap.rm86993.service.GenericService;

import java.util.List;

public class ItemPedidoServiceImpl extends GenericService<ItemPedido, Long> {

    private static ItemPedidoServiceImpl instance = null;

    private ItemPedidoDAOImpl itemPedidoDAO;

    private ItemPedidoServiceImpl() {
        this.itemPedidoDAO = itemPedidoDAO;
    }

    public static ItemPedidoServiceImpl getInstance(){
        if(instance == null){
            instance = new ItemPedidoServiceImpl();
        }
        return instance;
    }

    @Override
    public void inserir(ItemPedido itemPedido) {
        try {
            itemPedidoDAO.salvar(itemPedido, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(ItemPedido itemPedido) {
        try {
            itemPedidoDAO.atualizar(itemPedido, getEntityManager());
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try {
            itemPedidoDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public ItemPedido obter(Long id) {
        ItemPedido itemPedido = null;

        try {
            itemPedido = itemPedidoDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return itemPedido;
    }

    @Override
    public List<ItemPedido> listar() {
        List<ItemPedido> itensPedidos = null;

        try {
            itensPedidos = itemPedidoDAO.listar(getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return itensPedidos;
    }
}
