package br.com.fiap.rm86993.service.impl;

import br.com.fiap.rm86993.dao.impl.BoletoDAOImpl;
import br.com.fiap.rm86993.entity.Boleto;
import br.com.fiap.rm86993.service.GenericService;

import java.util.List;

public class BoletoServiceImpl extends GenericService<Boleto, Long> {
    private static BoletoServiceImpl instance = null;

    private BoletoDAOImpl boletoDAO;

    private BoletoServiceImpl() {
        this.boletoDAO = boletoDAO;
    }

    public static BoletoServiceImpl getInstance() {

        if (instance == null) {
            instance = new BoletoServiceImpl();
        }

        return instance;
    }


    @Override
    public void inserir(Boleto boleto) {
        try{
            boletoDAO.salvar(boleto, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Boleto boleto) {
        try{
            boletoDAO.atualizar(boleto, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try{
            boletoDAO.remover(id, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public Boleto obter(Long id) {
        Boleto boleto = null;

        try {
            boleto = boletoDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return boleto;    }

    @Override
    public List<Boleto> listar() {
        List<Boleto> boletos = null;

        try {
            boletos = boletoDAO.listarCriteria(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return boletos;    }
}
