package br.com.fiap.rm86993.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "TB_BOLETO")
@SequenceGenerator(name = "boleto", sequenceName = "SQ_TB_BOLETO", allocationSize = 1)
public class Boleto implements Serializable {

    private static final long serialVersionUID = -3509434272877656962L;

    public Boleto() {
    }

    public Boleto(String nossoNumero, LocalDate dataVencimento, Double valor, String codigoBarras, Pedido pedido) {
        this.nossoNumero = nossoNumero;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.codigoBarras = codigoBarras;
        this.pedido = pedido;
    }

    @Id
    @GeneratedValue(generator = "boleto", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NR_NOSSONUMERO")
    private String nossoNumero;

    @Column(name = "DT_VENCIMENTO")
    private LocalDate dataVencimento;

    @Column(name = "VL_BOLETO")
    private Double valor;

    @Column(name = "NR_CODIGOBARRAS", length = 55)
    private String codigoBarras;



    @OneToOne(optional = false)
    @JoinColumn(name = "PEDIDO_ID")
    private Pedido pedido;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "\n[Boleto] Numero cpf(nosso número): " + this.getNossoNumero()
                + "\n[Boleto] Data de vencimento" + this.getDataVencimento()
                +"\n[Boleto] Valor do boleto: " + this.getValor()
                +"\n[Boleto] Código de barras: " + this.getCodigoBarras();
    }
}
