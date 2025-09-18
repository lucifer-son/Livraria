import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashSet;

public class Programa {
    public static void main(String[] args) {
        // Categoria
        Categoria categoria = new Categoria("1", "Ficção Científica", "Livros de ficção futurista");
        System.out.println("Categoria criada: " + categoria.getNome());

        // Endereco
        Endereco endereco = new Endereco("1", "Rua das Estrelas", "42", "Apto 101", "São Paulo", "SP", "01000-000", "Brasil");

        // Cliente
        List<String> telefones = new ArrayList<>();
        telefones.add("(11) 99999-9999");
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        Cliente cliente = new Cliente("1", "João da Silva", "joao@email.com", "123456", telefones, enderecos, new Date());

        // Wishlist e Carrinho do Cliente
        WishList wishList = new WishList(1);
        cliente.setWishlist(wishList);
        Carrinho carrinho = new Carrinho(1, new ArrayList<>());
        cliente.setCarrinho(carrinho);
        System.out.println("Cliente criado: " + cliente.getNome());

        // Livro
        List<String> autores = new ArrayList<>();
        autores.add("Autor Exemplo");
        Livro livro = new Livro("LIV001", "Uma Aventura no Espaço", autores, "Editora Galáxia", "978-3-16-148410-0", 2023, "Descrição do livro...", 49.90, 100, 0.5, categoria.getId(), "/img/livro.jpg", 300);
        System.out.println("Livro criado: " + livro.getTitulo());

        // Avaliacao do Livro
        Avaliacao avaliacao = new Avaliacao(1, 5, "Ótimo livro!", new Date(), true);
        List<Avaliacao> avaliacoes = new ArrayList<>();
        avaliacoes.add(avaliacao);
        livro.setAvaliacoes(avaliacoes);

        // ItemPedido e adição ao Carrinho
        ItemPedido itemPedido = new ItemPedido(1, livro.getId(), 1, livro.getPreco());
        cliente.getCarrinho().getItens().add(itemPedido);
        System.out.println("Item adicionado ao carrinho: " + itemPedido.getLivro());

        // EnderecoEntrega
        EnderecoEntrega enderecoEntrega = new EnderecoEntrega(1, "Transportadora XYZ", "BR123456789", "EM_TRANSITO");

        // Pedido
        Pedido pedido = new Pedido(1, cliente.getId(), new Date(), Pedido.StatusPedido.PROCESSANDO, enderecoEntrega, "Cartão de Crédito", 10.0, 59.90);
        pedido.setItens(cliente.getCarrinho().getItens());
        System.out.println("Pedido criado com status: " + pedido.getStatus());

        // Pagamento do Pedido
        Pagamento pagamento = new Pagamento(1, "Cartão de Crédito", "**** **** **** 1234", "APROVADO", new Date());
        pedido.setPagamento(pagamento);

        // Devolucao (opcional)
        Devolucao devolucao = new Devolucao(1, "Produto danificado", new Date(), "EM_ANALISE");
        pedido.setDevolucao(devolucao);

        // Cupom Promocional
        CupomPromocional cupom = new CupomPromocional(1, "PROMO10", "PORCENTAGEM", new Date(), new Date(), 50.0, 100);
        System.out.println("Cupom criado: " + cupom.getCodigo());

        // Usuario (Admin)
        Usuario usuario = new Usuario(1, "admin", "admin123");
        usuario.setRoles(new HashSet<>(List.of("ADMIN", "USER")));
        System.out.println("Usuário admin criado com roles: " + usuario.getRoles());

        // Notificacao
        Notificacao notificacao = new Notificacao(1, "CONFIRMACAO_PEDIDO", "Seu pedido foi confirmado!", new Date(), "ENVIADA");
        System.out.println("Notificação enviada: " + notificacao.getTipo());

        // Relatorio de Vendas
        RelatorioVendas relatorio = new RelatorioVendas();
        List<RelatorioVendas.VendaResumo> resumo = relatorio.gerarResumoSimulado(new Date(), new Date());
        System.out.println("Relatório de vendas gerado com " + resumo.size() + " registro(s).");
    }
}
