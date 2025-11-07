package model;

import java.util.List;
import java.util.Objects;

public class Carrinho {
    private String id; // ALTERADO
    private List<ItemPedido> itens;

    public Carrinho(String id, List<ItemPedido> itens) { // ALTERADO
        this.id = id;
        this.itens = itens;
    }

    public String getId() { // ALTERADO
        return id;
    }

    public void setId(String id) { // ALTERADO
        this.id = id;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "id='" + id + '\'' + // ALTERADO
                ", numeroDeItens=" + (itens != null ? itens.size() : 0) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrinho carrinho = (Carrinho) o;
        return Objects.equals(id, carrinho.id); // ALTERADO
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
