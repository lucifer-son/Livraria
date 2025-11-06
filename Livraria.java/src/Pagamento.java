import java.util.Date;

public class Pagamento {
    private int id;
    private String tipo;
    private String dados;
    private String status;
    private Date data;

    public Pagamento(int id, String tipo, String dados, String status, Date data) {
        this.id = id;
        this.tipo = tipo;
        this.dados = dados;
        this.status = status;
        this.data = data;
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
}
