package br.com.fiap.rm86993.service.impl;

import br.com.fiap.rm86993.dao.impl.PedidoDAOImpl;
import br.com.fiap.rm86993.dto.PedidoBoletoDTO;
import br.com.fiap.rm86993.entity.Pedido;
import br.com.fiap.rm86993.service.GenericService;

import java.util.List;

public class PedidoServiceImpl extends GenericService<Pedido, Long> {

    private static PedidoServiceImpl instance = null;

    private PedidoDAOImpl pedidoDAO;

    public PedidoServiceImpl() {
        this.pedidoDAO = PedidoDAOImpl.getInstance();
    }

    public static PedidoServiceImpl getInstance(){
        if (instance == null) {
            instance = new PedidoServiceImpl();
        }

        return instance;
    }

    public List<Pedido> listarPorCpf(String cpf){
        List<Pedido> pedidos = null;

        try {
            pedidos = pedidoDAO.listarPorCpf(cpf, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return pedidos;
    }

    @Override
    public void inserir(Pedido pedido) {
        try {
            pedidoDAO.salvar(pedido, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Pedido pedido) {
        try {
            pedidoDAO.atualizar(pedido, getEntityManager());
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try {
            pedidoDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public Pedido obter(Long id) {
        Pedido pedido = null;

        try {
            pedido = pedidoDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return pedido;
    }

    @Override
    public List<Pedido> listar() {
        List<Pedido> pedidos = null;

        try {
//			alunos = alunoDAO.listar(getEntityManager());
            pedidos = pedidoDAO.listar(getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return pedidos;
    }

    public List<Pedido> listarPedidoComBoleto(){
        List<Pedido> pedidos = null;

        try {
            pedidos = pedidoDAO.listarPedidoComBoleto(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return pedidos;
    }

}
