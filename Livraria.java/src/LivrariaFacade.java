public class LivrariaFacade {

    private ClienteRepositorio clienteRepo;
    private LivroRepositorio livroRepo;
    private PedidoRepositorio pedidoRepo;

    public LivrariaFacade(ClienteRepositorio clienteRepo, LivroRepositorio livroRepo, PedidoRepositorio pedidoRepo) {
        this.clienteRepo = clienteRepo;
        this.livroRepo = livroRepo;
        this.pedidoRepo = pedidoRepo;
    }

    public Pedido realizarPedido(String clienteCpf, String livroTitulo) 
            throws EntidadeNaoEncontradaException, EstoqueInsuficienteException { // Declara as exceções que pode lançar

        Cliente cliente = clienteRepo.buscar(clienteCpf);
        if (cliente == null) {
            throw new EntidadeNaoEncontradaException("Cliente com CPF '" + clienteCpf + "' não encontrado.");
        }

        Livro livro = livroRepo.buscar(livroTitulo);
        if (livro == null) {
            throw new EntidadeNaoEncontradaException("Livro com título '" + livroTitulo + "' não encontrado.");
        }

        if (!livro.verificarDisponibilidade()) {
            throw new EstoqueInsuficienteException("Livro '" + livroTitulo + "' fora de estoque.");
        }

        Pedido.Carrinho carrinho = new Pedido.Carrinho(cliente.getCarrinho() != null ? cliente.getCarrinho().getId() + 1 : 1);
        carrinho.adicionarItem(livro.getId(), 1, livro.getPreco());

        Pedido novoPedido = new Pedido(pedidoRepo.listarTodos().length + 1, cliente.getId(), cliente.getEnderecos().get(0).toString(), "Cartão de Crédito", 10.0, carrinho);
        pedidoRepo.adicionar(novoPedido);

        livro.setEstoque(livro.getEstoque() - 1);

        System.out.println("FACADE INFO: Pedido para o livro '" + livroTitulo + "' realizado com sucesso pelo cliente '" + cliente.getNome() + "'!");
        return novoPedido;
    }

    public void atualizarEstoque(String livroTitulo, int novaQuantidade) throws EntidadeNaoEncontradaException {
        Livro livro = livroRepo.buscar(livroTitulo);
        if (livro != null) {
            livro.setEstoque(novaQuantidade);
            System.out.println("FACADE INFO: Estoque do livro '" + livroTitulo + "' atualizado para " + novaQuantidade + ".");
        } else {
            throw new EntidadeNaoEncontradaException("Não foi possível atualizar o estoque. Livro não encontrado.");
        }
    }
}
