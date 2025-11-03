import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cliente extends Usuario {
    private String cpf;
    private List<String> telefones;
    private List<Endereco> enderecos;
    private Date dataRegistro;
    private WishList wishlist;
    private Pedido.Carrinho carrinho;
    private List<Pedido> historicoPedidos;

    public Cliente(String id, String nome, String cpf, String email, String senha, List<String> telefones, List<Endereco> enderecos, Date dataRegistro) {
        super(id, nome, email, senha);
        this.cpf = cpf;
        this.telefones = telefones;
        this.enderecos = enderecos;
        this.dataRegistro = dataRegistro;
        this.historicoPedidos = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public WishList getWishlist() {
        return wishlist;
    }

    public void setWishlist(WishList wishlist) {
        this.wishlist = wishlist;
    }

    public Pedido.Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Pedido.Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public List<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public void setHistoricoPedidos(List<Pedido> historicoPedidos) {
        this.historicoPedidos = historicoPedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "usuario=" + super.toString() +
                ", cpf='" + cpf + '\'' +
                ", telefones=" + telefones +
                ", enderecos=" + enderecos +
                ", dataRegistro=" + dataRegistro +
                ", wishlist=" + wishlist +
                ", carrinho=" + carrinho +
                ", historicoPedidos=" + historicoPedidos +
                '}';
    }
}
