package br.com.fiap.rm86993.dto;

public class PedidoBoletoDTO {

    private String pedido;
    private String boleto;

    public PedidoBoletoDTO() {
    }

    public PedidoBoletoDTO(String pedido, String boleto) {
        this.pedido = pedido;
        this.boleto = boleto;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getBoleto() {
        return boleto;
    }

    public void setBoleto(String boleto) {
        this.boleto = boleto;
    }

    @Override
    public String toString() {
        return this.getPedido() + " - " + this.getBoleto();
    }
}
