package br.com.fiap.rm86993;

import br.com.fiap.rm86993.entity.Produto;
import br.com.fiap.rm86993.service.impl.BoletoServiceImpl;
import br.com.fiap.rm86993.service.impl.PedidoServiceImpl;
import br.com.fiap.rm86993.service.impl.ProdutoServiceImpl;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        PedidoServiceImpl pedidoService = PedidoServiceImpl.getInstance();
        ProdutoServiceImpl produtoService = ProdutoServiceImpl.getInstance();

        System.out.println("======================Lista de pedidos com CPF igual a 111.111.111-11======================");
        pedidoService.listarPorCpf("111.111.111-11").forEach(System.out::println);


        System.out.println("======================Lista de produtos com valor maior do que 100======================");
        produtoService.listarPorValor(100.00).forEach(System.out::println);

        produtoService.listarPorNomeParecido("C").forEach(System.out::println);

        produtoService.listarBuscandoPorValor(15).forEach(System.out::println);

        pedidoService.listarPedidoComBoleto().forEach(System.out::println);
    }
}
