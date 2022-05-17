package br.com.fiap.rm86993.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_ITEMPEDIDO")
@SequenceGenerator(name = "itempedido", sequenceName = "SQ_TB_ITEMPEDIDO" ,allocationSize = 1)
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 7564610884266466388L;

    public ItemPedido() {
    }

    public ItemPedido(Integer quantidade, Pedido pedido, Produto produto) {
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
    }

    @Id
    @GeneratedValue(generator = "itempedido", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;


    @Column(name = "NR_QUANTIDADE")
    private Integer quantidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    //Aqui não precisei do toString
}
