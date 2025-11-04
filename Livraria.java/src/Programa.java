import java.util.Date;
import java.util.List;

public class Programa {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Testes do Sistema da Livraria ---");

        try {
            // Inicializa os repositórios
            LivroRepositorio livroRepo = new LivroRepositorio();
            ClienteRepositorio clienteRepo = new ClienteRepositorio();
            PedidoRepositorio pedidoRepo = new PedidoRepositorio();

            // Executa os testes
            testarLivros(livroRepo);
            testarClientes(clienteRepo);
            testarCarrinhoPedido(pedidoRepo, clienteRepo, livroRepo);
            testarWishlist(clienteRepo, livroRepo);

        } catch (LivrariaException e) {
            System.err.println("Ocorreu um erro na execução: " + e.getMessage());
        }

        System.out.println("\n--- Testes Finalizados ---");
    }

    public static void testarLivros(LivroRepositorio livroRepo) throws DadoDuplicadoException {
        System.out.println("\n--- Testando Cadastro de Livros ---");

        // Criando categorias
        Livro.Categoria ficcao = new Livro.Categoria("1", "Ficção Científica", "Livros sobre futuros distópicos e tecnologia.");
        Livro.Categoria fantasia = new Livro.Categoria("2", "Fantasia", "Livros com elementos mágicos e mundos imaginários.");

        // Criando e adicionando livros
        System.out.println("Adicionando livros ao repositório...");
        livroRepo.adicionar(new Livro("L001", "Duna", List.of("Frank Herbert"), "Editora Aleph", "978-8576570013", 1965, "Um épico de ficção científica.", 65.90, 10, 0.8, ficcao, "duna.jpg", 680));
        livroRepo.adicionar(new Livro("L002", "O Senhor dos Anéis", List.of("J.R.R. Tolkien"), "HarperCollins", "978-8595084759", 1954, "A jornada para destruir o Um Anel.", 89.90, 5, 1.2, fantasia, "lotr.jpg", 1200));
        livroRepo.adicionar(new Livro("L003", "Neuromancer", List.of("William Gibson"), "Editora Aleph", "978-8576572192", 1984, "O clássico cyberpunk.", 45.50, 8, 0.6, ficcao, "neuro.jpg", 320));

        // Listando todos os livros
        System.out.println("\nLivros no repositório:");
        for (Livro livro : livroRepo.listarTodos()) {
            System.out.println("- " + livro.getTitulo() + " (Estoque: " + livro.getEstoque() + ")");
        }

        // Buscando um livro específico
        System.out.println("\nBuscando o livro 'Duna':");
        Livro livroEncontrado = livroRepo.buscar("Duna");
        if (livroEncontrado != null) {
            System.out.println("Encontrado: " + livroEncontrado.getTitulo() + ", Preço: R$" + livroEncontrado.getPreco());
        }

        // Removendo um livro
        System.out.println("\nRemovendo o livro 'Neuromancer'...");
        boolean removido = livroRepo.remover("Neuromancer");
        System.out.println("Removido com sucesso? " + removido);

        // Listando livros novamente
        System.out.println("\nLivros restantes no repositório:");
        for (Livro livro : livroRepo.listarTodos()) {
            System.out.println("- " + livro.getTitulo());
        }
    }

    public static void testarClientes(ClienteRepositorio clienteRepo) throws DadoDuplicadoException {
        System.out.println("\n--- Testando Cadastro de Clientes ---");

        // Criando endereço
        Endereco endereco = new Endereco("E001", "Rua Fictícia", "123", "Apto 4B", "Cidade Exemplo", "EX", "12345-678", "Brasil");
        
        // Criando e adicionando um cliente
        System.out.println("Adicionando cliente ao repositório...");
        Cliente cliente = new Cliente("C001", "João Silva", "123.456.789-00", "joao.silva@example.com", "senha123", List.of("11999998888"), List.of(endereco), new Date());
        clienteRepo.adicionar(cliente);

        // Listando clientes
        System.out.println("\nClientes no repositório:");
        for (Cliente c : clienteRepo.listarTodos()) {
            System.out.println("- " + c.getNome() + " (Email: " + c.getEmail() + ")");
        }
    }

    public static void testarCarrinhoPedido(PedidoRepositorio pedidoRepo, ClienteRepositorio clienteRepo, LivroRepositorio livroRepo) throws EntidadeNaoEncontradaException {
        System.out.println("\n--- Testando Carrinho e Pedido ---");

        // Recuperando cliente e livros
        Cliente cliente = clienteRepo.buscar("123.456.789-00");
        Livro livro1 = livroRepo.buscar("Duna");
        Livro livro2 = livroRepo.buscar("O Senhor dos Anéis");

        if (cliente == null || livro1 == null || livro2 == null) {
            throw new EntidadeNaoEncontradaException("Cliente ou livros de teste não encontrados.");
        }

        // Criando um carrinho e adicionando itens
        System.out.println("Criando carrinho e adicionando itens para o cliente: " + cliente.getNome());
        Pedido.Carrinho carrinho = new Pedido.Carrinho(1);
        carrinho.adicionarItem(livro1.getTitulo(), 1, livro1.getPreco());
        carrinho.adicionarItem(livro2.getTitulo(), 1, livro2.getPreco());
        cliente.setCarrinho(carrinho);

        System.out.println("Itens no carrinho:");
        for (Pedido.ItemPedido item : cliente.getCarrinho().getItens()) {
            System.out.println("- " + item.getLivro() + " | Qtd: " + item.getQuantidade());
        }

        // Criando um pedido a partir do carrinho
        System.out.println("\nCriando pedido a partir do carrinho...");
        Pedido pedido = new Pedido(1, cliente.getId(), cliente.getEnderecos().get(0).toString(), "Cartão de Crédito", 15.0, carrinho);
        pedidoRepo.adicionar(pedido);
        
        // Adicionando ao histórico do cliente
        cliente.getHistoricoPedidos().add(pedido);

        System.out.println("Pedido criado com sucesso!");
        System.out.println(pedido);
    }

    public static void testarWishlist(ClienteRepositorio clienteRepo, LivroRepositorio livroRepo) throws EntidadeNaoEncontradaException {
        System.out.println("\n--- Testando Wishlist ---");

        // Recuperando cliente e livro
        Cliente cliente = clienteRepo.buscar("123.456.789-00");
        Livro livro = livroRepo.buscar("Duna");

        if (cliente == null || livro == null) {
            throw new EntidadeNaoEncontradaException("Cliente ou livro de teste não encontrado.");
        }

        // Criando wishlist e adicionando item
        System.out.println("Adicionando '" + livro.getTitulo() + "' à wishlist do cliente " + cliente.getNome());
        WishList wishlist = new WishList(1);
        wishlist.adicionarLivro(livro.getTitulo());
        cliente.setWishlist(wishlist);

        // Exibindo wishlist
        System.out.println("Itens na wishlist:");
        for (String nomeLivro : cliente.getWishlist().getLivrosDesejados()) {
            System.out.println("- " + nomeLivro);
        }
    }
}
