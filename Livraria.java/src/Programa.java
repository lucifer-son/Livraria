import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

// Importações para as classes do pacote model
import model.Endereco;
import model.Cliente;
import model.WishList;
import model.Carrinho;
import model.Livro;
import model.Avaliacao;
import model.ItemPedido;
import model.Pedido;
import model.Pagamento;
import model.Devolucao;
import model.CupomPromocional;
import model.Usuario;
import model.Notificacao;
import model.RelatorioVendas;


public class Programa {

    public static void main(String[] args) {
        System.out.println("Iniciando testes...");

        // Teste da classe Endereco
        Endereco endereco = new Endereco("1", "Rua das Estrelas", "42", "Apto 101", "São Paulo", "SP", "01000-000", "Brasil", "Transportadora XYZ, Rastreio: XYZ987654321, Status: PROCESSANDO");
        assert "Rua das Estrelas".equals(endereco.getRua());
        System.out.println("Classe Endereco testada com sucesso.");

        // Teste da classe Cliente
        List<String> telefones = new ArrayList<>();
        telefones.add("(11) 99999-9999");
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        Cliente cliente = new Cliente("1", "João da Silva", "joao@email.com", "123456", telefones, enderecos, new Date());
        assert "João da Silva".equals(cliente.getNome());
        System.out.println("Classe Cliente testada com sucesso.");

        // Teste da classe WishList
        WishList wishList = new WishList("1"); // ID alterado para String
        cliente.setWishlist(wishList);
        assert cliente.getWishlist() != null;
        System.out.println("Classe WishList testada com sucesso.");

        // Teste da classe Carrinho
        Carrinho carrinho = new Carrinho("1", new ArrayList<>()); // ID alterado para String
        cliente.setCarrinho(carrinho);
        assert cliente.getCarrinho() != null;
        System.out.println("Classe Carrinho testada com sucesso.");

        // Teste da classe Livro
        List<String> autores = new ArrayList<>();
        autores.add("Autor Exemplo");
        Livro livro = new Livro("LIV001", "Uma Aventura no Espaço", autores, "Editora Galáxia", "978-3-16-148410-0", 2023, "Descrição do livro...", 49.90, 100, 0.5, "Ficção Científica", "/img/livro.jpg", 300);
        assert "Uma Aventura no Espaço".equals(livro.getTitulo());
        System.out.println("Classe Livro testada com sucesso.");

        // Teste da classe Avaliacao
        Avaliacao avaliacao = new Avaliacao("1", 5, "Ótimo livro!", new Date(), true); // ID alterado para String
        assert 5 == avaliacao.getNota(); // getRating() não existe, usei getNota()
        System.out.println("Classe Avaliacao testada com sucesso.");

        // Teste da classe ItemPedido
        ItemPedido itemPedido = new ItemPedido("1", livro.getId(), 1, livro.getPreco()); // ID alterado para String
        carrinho.getItens().add(itemPedido);
        assert carrinho.getItens().size() == 1;
        System.out.println("Classe ItemPedido testada com sucesso.");

        // Teste da classe Pedido
        Pedido pedido = new Pedido.Builder("1", cliente.getId(), new Date()) // ID alterado para String
                .withStatus(Pedido.StatusPedido.PROCESSANDO)
                .withEndereco(endereco)
                .withMetodoPagamento("Cartão de Crédito")
                .withFrete(10.0)
                .withValorTotal(59.90)
                .withItens(carrinho.getItens())
                .build();
        assert Pedido.StatusPedido.PROCESSANDO.equals(pedido.getStatus());
        System.out.println("Classe Pedido testada com sucesso.");

        // Teste da classe Pagamento
        Pagamento pagamento = new Pagamento("1", "Cartão de Crédito", "**** **** **** 1234", "APROVADO", new Date()); // ID alterado para String
        assert "APROVADO".equals(pagamento.getStatus());
        System.out.println("Classe Pagamento testada com sucesso.");

        // Teste da classe Devolucao
        Devolucao devolucao = new Devolucao("1", "Produto danificado", new Date(), "EM_ANALISE"); // ID alterado para String
        assert "EM_ANALISE".equals(devolucao.getStatus());
        System.out.println("Classe Devolucao testada com sucesso.");

        // Teste da classe CupomPromocional
        CupomPromocional cupom = new CupomPromocional("1", "PROMO10", "PORCENTAGEM", new Date(), new Date(), 50.0, 100); // ID alterado para String
        assert "PROMO10".equals(cupom.getCodigo());
        System.out.println("Classe CupomPromocional testada com sucesso.");

        // Teste da classe Usuario
        Usuario usuario = new Usuario("1", "admin", "admin123"); // ID alterado para String
        usuario.setRoles(new HashSet<>(List.of("ADMIN", "USER")));
        assert usuario.getRoles().contains("ADMIN");
        System.out.println("Classe Usuario testada com sucesso.");

        // Teste da classe Notificacao
        Notificacao notificacao = new Notificacao("1", "CONFIRMACAO_PEDIDO", "Seu pedido foi confirmado!", new Date(), "ENVIADA"); // ID alterado para String
        assert "ENVIADA".equals(notificacao.getStatus());
        System.out.println("Classe Notificacao testada com sucesso.");

        // Teste da classe RelatorioVendas
        RelatorioVendas relatorio = new RelatorioVendas();
        List<RelatorioVendas.VendaResumo> resumo = relatorio.gerarResumoSimulado(new Date(), new Date());
        assert resumo != null;
        System.out.println("Classe RelatorioVendas testada com sucesso.");

        System.out.println("Todos os testes foram concluídos com sucesso!");
    }
}
