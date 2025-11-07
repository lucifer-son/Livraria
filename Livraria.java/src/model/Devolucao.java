package model;

import java.util.Date;
import java.util.Objects;

public class Devolucao {
    private String id; // ALTERADO
    private String motivo;
    private Date dataSolicitacao;
    private String status;

    public Devolucao(String id, String motivo, Date dataSolicitacao, String status) { // ALTERADO
        this.id = id;
        this.motivo = motivo;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

    public String getId() { // ALTERADO
        return id;
    }

    public void setId(String id) { // ALTERADO
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Devolucao{" +
                "id='" + id + '\'' + // ALTERADO
                ", motivo='" + motivo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devolucao devolucao = (Devolucao) o;
        return Objects.equals(id, devolucao.id); // ALTERADO
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
