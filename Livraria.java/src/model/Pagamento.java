package model;

import java.util.Date;
import java.util.Objects;

public class Pagamento {
    private String id; // ALTERADO
    private String tipo;
    private String dados;
    private String status;
    private Date data;

    public Pagamento(String id, String tipo, String dados, String status, Date data) { // ALTERADO
        this.id = id;
        this.tipo = tipo;
        this.dados = dados;
        this.status = status;
        this.data = data;
    }

    public String getId() { // ALTERADO
        return id;
    }

    public void setId(String id) { // ALTERADO
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id='" + id + '\'' + // ALTERADO
                ", tipo='" + tipo + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id); // ALTERADO
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
