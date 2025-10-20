public class EnderecoEntrega {
    private int id;
    private String empresaTransporte;
    private String codigoRastreio;
    private String statusEntrega;

    public EnderecoEntrega() {}

    public EnderecoEntrega(int id, String empresaTransporte, String codigoRastreio, String statusEntrega) {
        this.id = id;
        this.empresaTransporte = empresaTransporte;
        this.codigoRastreio = codigoRastreio;
        this.statusEntrega = statusEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void setEmpresaTransporte(String empresaTransporte) {
        this.empresaTransporte = empresaTransporte;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public String getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(String statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public boolean isEntregue() {
        return "ENTREGUE".equalsIgnoreCase(statusEntrega);
    }

    @Override
    public String toString() {
        return "EnderecoEntrega{" +
                "id=" + id +
                ", empresaTransporte='" + empresaTransporte + '\'' +
                ", codigoRastreio='" + codigoRastreio + '\'' +
                ", statusEntrega='" + statusEntrega + '\'' +
                '}';
    }
}
