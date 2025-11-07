package model;

import java.util.Objects;

public class ItemPedido {
    private String id; // ALTERADO
    private Pedido pedido;
    private String livro; // Usando o ID do livro
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String id, String livro, int quantidade, double precoUnitario) { // ALTERADO
        this.id = id;
        this.livro = livro;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double getSubtotal() {
        return quantidade * precoUnitario;
    }

    public String getId() { // ALTERADO
        return id;
    }

    public void setId(String id) { // ALTERADO
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "id='" + id + '\'' + // ALTERADO
                ", livro='" + livro + '\'' +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id); // ALTERADO
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
