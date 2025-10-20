import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private int id;
    private String cliente;
    private Date data;
    private StatusPedido status;
    private String enderecoEntrega;
    private String metodoPagamento;
    private double frete;
    private double valorTotal;
    private List<ItemPedido> itens;

    public void setPagamento(Pagamento pagamento) {
    }

    public void setDevolucao(Devolucao devolucao) {
    }

    public enum StatusPedido {
        PENDENTE,
        PROCESSANDO,
        ENVIADO,
        ENTREGUE,
        CANCELADO
    }

    public Pedido(int id, String cliente, String enderecoEntrega, String metodoPagamento, double frete) {
        this.id = id;
        this.cliente = cliente;
        this.data = new Date();
        this.status = StatusPedido.PENDENTE;
        this.enderecoEntrega = enderecoEntrega;
        this.metodoPagamento = metodoPagamento;
        this.frete = frete;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public Pedido(int id, String cliente, String enderecoEntrega, String metodoPagamento, double frete, Carrinho carrinho) {
        this.id = id;
        this.cliente = cliente;
        this.data = new Date();
        this.status = StatusPedido.PENDENTE;
        this.enderecoEntrega = enderecoEntrega;
        this.metodoPagamento = metodoPagamento;
        this.frete = frete;
        this.itens = new ArrayList<>(carrinho.getItens());
        atualizarValorTotal();
    }

    public void adicionarItem(String livro, int quantidade, double precoUnitario) {
        ItemPedido item = new ItemPedido(itens.size() + 1, livro, quantidade, precoUnitario);
        itens.add(item);
        atualizarValorTotal();
    }

    private void atualizarValorTotal() {
        double soma = 0.0;
        for (ItemPedido item : itens) {
            soma += item.getSubtotal();
        }
        this.valorTotal = soma + frete;
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public Date getData() { return data; }
    public StatusPedido getStatus() { return status; }
    public void setStatus(StatusPedido status) { this.status = status; }
    public String getEnderecoEntrega() { return enderecoEntrega; }
    public String getMetodoPagamento() { return metodoPagamento; }
    public double getFrete() { return frete; }
    public double getValorTotal() { return valorTotal; }
    public List<ItemPedido> getItens() { return new ArrayList<>(itens); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== PEDIDO #").append(id).append(" ===\n");
        sb.append("Cliente: ").append(cliente).append("\n");
        sb.append("Data: ").append(data).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("Endereço: ").append(enderecoEntrega).append("\n");
        sb.append("Pagamento: ").append(metodoPagamento).append("\n");
        sb.append("Frete: R$ ").append(String.format("%.2f", frete)).append("\n");
        sb.append("Itens:\n");
        for (ItemPedido item : itens) {
            sb.append("  - ").append(item.toString()).append("\n");
        }
        sb.append("Valor Total: R$ ").append(String.format("%.2f", valorTotal)).append("\n");
        return sb.toString();
    }

    public static class ItemPedido {
        private int id;
        private String livro;
        private int quantidade;
        private double precoUnitario;

        public ItemPedido(int id, String livro, int quantidade, double precoUnitario) {
            this.id = id;
            this.livro = livro;
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
        }

        public double getSubtotal() {
            return quantidade * precoUnitario;
        }

        public int getId() { return id; }
        public String getLivro() { return livro; }
        public int getQuantidade() { return quantidade; }
        public double getPrecoUnitario() { return precoUnitario; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ItemPedido)) return false;
            ItemPedido that = (ItemPedido) o;
            return id == that.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return livro + " (x" + quantidade + ") - R$ " + String.format("%.2f", getSubtotal());
        }
    }

    public static class Carrinho {
        private int id;
        private List<ItemPedido> itens;

        public Carrinho(int id) {
            this.id = id;
            this.itens = new ArrayList<>();
        }

        public void adicionarItem(String livro, int quantidade, double precoUnitario) {
            ItemPedido novoItem = new ItemPedido(itens.size() + 1, livro, quantidade, precoUnitario);
            this.itens.add(novoItem);
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public List<ItemPedido> getItens() { return itens; }
        public void setItens(List<ItemPedido> itens) { this.itens = itens; }
    }

    public static class RelatorioVendas {

        public static class VendaResumo {
            private Date data;
            private long totalPedidos;
            private double receita;

            public VendaResumo(Date data, long totalPedidos, double receita) {
                this.data = data;
                this.totalPedidos = totalPedidos;
                this.receita = receita;
            }

            public Date getData() { return data; }
            public long getTotalPedidos() { return totalPedidos; }
            public double getReceita() { return receita; }

            @Override
            public String toString() {
                return "VendaResumo{" +
                        "data=" + data +
                        ", totalPedidos=" + totalPedidos +
                        ", receita=" + String.format("%.2f", receita) +
                        '}';
            }
        }

        public List<VendaResumo> gerarResumoSimulado(Date inicio, Date fim) {
            List<VendaResumo> lista = new ArrayList<>();
            Calendar c = Calendar.getInstance();
            c.setTime(inicio);

            while (!c.getTime().after(fim)) {
                long pedidos = (long) (Math.random() * 10 + 1);
                double receita = pedidos * 100.0;
                lista.add(new VendaResumo(c.getTime(), pedidos, receita));
                c.add(Calendar.DATE, 1);
            }
            return lista;
        }
    }
}