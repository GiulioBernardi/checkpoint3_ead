package br.com.fiap.rm86993.entity;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_PRODUTO")
@SequenceGenerator(name = "produto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Produto.listar", query = "SELECT p FROM Produto p WHERE p.valor > :valor")
})
public class Produto implements Serializable {

    private static final long serialVersionUID = -8094022591543000669L;

    public Produto(){}

    public Produto(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Id
    @GeneratedValue(generator = "produto", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DS_NOME")
    private String nome;

    @Column(name = "VL_PRODUTO")
    private Double valor;

    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> itensPedidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\nId: " + this.getId()
                +"\nNome: " + this.getNome()
                +"\n Valor: " + this.getValor();
    }
}
