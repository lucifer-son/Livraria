import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashSet;

public class Programa {
    public static void main(String[] args) {

        // Endereco
        Endereco endereco = new Endereco("1", "Rua das Estrelas", "42", "Apto 101", "Recife", "PE", "01000-000", "Brasil");
        System.out.println("Cidade:" + endereco.getCidade());

        // Cliente
        List<String> telefones = new ArrayList<>();
        telefones.add("(11) 99999-9999");
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        Cliente cliente = new Cliente("1", "Mariana Oliveira", "mariana.oliveira@email.com", "123456", telefones, enderecos, new Date());

        WishList wishList = new WishList(1);
        cliente.setWishlist(wishList);
        Pedido.Carrinho carrinho = new Pedido.Carrinho(1);
        cliente.setCarrinho(carrinho);
        System.out.println("Cliente criado: " + cliente.getNome());

        // Livro
        List<String> autores = new ArrayList<>();
        autores.add("Autor Exemplo");
        // TODO: A classe Categoria ainda não foi encontrada.
        // Categoria categoria = new Categoria(1, "Ficção Científica"); 
        // Livro livro = new Livro("LIV001", "Uma Aventura no Espaço", autores, "Editora Galáxia", "978-3-16-148410-0", 2023, "Descrição do livro...", 49.90, 100, 0.5, categoria.getId(), "/img/livro.jpg", 300);
        // System.out.println("Livro criado: " + livro.getTitulo());

        // Avaliacao avaliacao = new Avaliacao(1, 5, "Ótimo livro!", new Date(), true);
        // List<Avaliacao> avaliacoes = new ArrayList<>();
        // avaliacoes.add(avaliacao);
        // livro.setAvaliacoes(avaliacoes);

        // EnderecoEntrega
        EnderecoEntrega enderecoEntrega = new EnderecoEntrega(1, "Transportadora XYZ", "BR123456789", "EM_TRANSITO");

        // Pedido
        Pedido pedido1 = new Pedido(1, "Mariana Oliveira", "Rua das Flores, 123", "Cartão de Crédito", 15.0);
        pedido1.adicionarItem("Livro: Java para Iniciantes", 2, 89.90);
        pedido1.adicionarItem("Livro: Estruturas de Dados", 1, 120.00);

        Pedido pedido2 = new Pedido(1, "Mariana Oliveira", "Rua das Flores, 123", "Cartão de Crédito", 15.0);

        System.out.println(pedido1);
        System.out.println("pedido1.equals(pedido2)? " + pedido1.equals(pedido2)); // true

        // Pagamento do Pedido
        Pagamento pagamento = new Pagamento(1, "Cartão de Crédito", "**** **** **** 1234", "APROVADO", new Date());
        pedido1.setPagamento(pagamento);

        // Devolucao (opcional)
        Devolucao devolucao = new Devolucao(1, "Produto danificado", new Date(), "EM_ANALISE");
        pedido1.setDevolucao(devolucao);

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
        Pedido.RelatorioVendas relatorio = new Pedido.RelatorioVendas();
        List<Pedido.RelatorioVendas.VendaResumo> resumo = relatorio.gerarResumoSimulado(new Date(), new Date());
        System.out.println("Relatório de vendas gerado com " + resumo.size() + " registro(s).");
    }
}
