import java.util.Date;

public class Notificacao {
    private int id;
    private String tipo;
    private String mensagem;
    private Date data;
    private String status;

    public Notificacao() {}

    public Notificacao(int id, String tipo, String mensagem, Date data, String status) {
        this.id = id;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.data = data;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean estaPendente() {
        return "PENDENTE".equalsIgnoreCase(status);
    }

    @Override
    public String toString() {
        return "Notificacao{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", data=" + data +
                ", status='" + status + '\'' +
                '}';
    }
}
