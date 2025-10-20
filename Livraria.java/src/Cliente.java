import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    private String id;
    private String nome;
    private String email;
    private String senha;
    private List<String> telefones;
    private List<Endereco> enderecos;
    private Date dataRegistro;
    private WishList wishlist;
    private Pedido.Carrinho carrinho;
    private List<Pedido> historicoPedidos;

    public Cliente(String id, String nome, String email, String senha, List<String> telefones, List<Endereco> enderecos, Date dataRegistro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefones = telefones;
        this.enderecos = enderecos;
        this.dataRegistro = dataRegistro;
        this.historicoPedidos = new ArrayList<>(); // Inicializa a lista de pedidos
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
}
