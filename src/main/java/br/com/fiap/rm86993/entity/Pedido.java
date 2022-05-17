package br.com.fiap.rm86993.entity;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_PEDIDO")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
public class Pedido implements Serializable {


    private static final long serialVersionUID = -1686226145293559820L;

    public Pedido() {
    }


    public Pedido(Integer numeroPedido, Double valorTotal, String cpfCliente) {
        this.numeroPedido = numeroPedido;
        this.valorTotal = valorTotal;
        this.cpfCliente = cpfCliente;
    }

    @Id
    @GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NR_PEDIDO")
    private Integer numeroPedido;

    @Column(name = "VL_TOTAL")
    private Double valorTotal;

    @Column(name = "NR_CPF")
    private String cpfCliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Boleto boleto;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedidos;

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    @Override
    public String toString() {
        return "\n[Pedido] Id: " + this.getId()
                +"\n[Pedido] Número do pedido: " + this.getNumeroPedido()
                +"\n[Pedido] Valor total: " + this.getValorTotal()
                +"\n[Pedido] CPF do cliente: " + this.getCpfCliente()
                +"\n[Pedido] Boleto: " + this.getBoleto();
    }
}
