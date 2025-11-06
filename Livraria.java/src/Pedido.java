import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private String cliente;
    private Date data;
    private StatusPedido status;
    private EnderecoEntrega enderecoEntrega;
    private String metodoPagamento;
    private double frete;
    private double valorTotal;
    private List<ItemPedido> itens;
    private Pagamento pagamento;
    private Devolucao devolucao;

    public enum StatusPedido{
        PENDENTE,
        PROCESSANDO,
        ENVIADO,
        ENTREGUE,
        CANCELADO
    }

    public Pedido(int id, String cliente, Date data, StatusPedido status, EnderecoEntrega enderecoEntrega, String metodoPagamento, double frete, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.status = status;
        this.enderecoEntrega = enderecoEntrega;
        this.metodoPagamento = metodoPagamento;
        this.frete = frete;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public EnderecoEntrega getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }
}