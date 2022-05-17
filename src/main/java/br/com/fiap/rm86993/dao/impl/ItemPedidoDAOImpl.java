package br.com.fiap.rm86993.dao.impl;

import br.com.fiap.rm86993.entity.ItemPedido;

public class ItemPedidoDAOImpl extends HibernateGenericDAO<ItemPedido, Long>{

    private static ItemPedidoDAOImpl instance = null;

    public static ItemPedidoDAOImpl getInstance() {
        if (instance == null) {
            instance = new ItemPedidoDAOImpl();
        }
        return instance;
    }

    public ItemPedidoDAOImpl() {
        super(ItemPedido.class);
    }
}
