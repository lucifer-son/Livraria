import java.util.ArrayList;
import java.util.List;

public class Programa {

    public static void main(String[] args) {
        System.out.println("#################################################################");
        System.out.println("###      DEMONSTRAÇÃO COM TRATAMENTO DE EXCEÇÕES (TRY-CATCH)     ###");
        System.out.println("#################################################################\n");

        // --- 1. Inicialização ---
        ClienteRepositorio clienteRepo = new ClienteRepositorio();
        UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();
        LivroRepositorio livroRepo = new LivroRepositorio();
        PedidoRepositorio pedidoRepo = new PedidoRepositorio();
        ClienteCadastroService clienteCadastro = new ClienteCadastroService(clienteRepo, usuarioRepo);
        LivroCadastroService livroCadastro = new LivroCadastroService(livroRepo);
        LivrariaFacade livrariaFacade = new LivrariaFacade(clienteRepo, livroRepo, pedidoRepo);
        System.out.println("Serviços e Repositórios inicializados.\n");

        // --- 2. Cadastrando um Livro e um Cliente ---
        System.out.println("--- 2. Cadastrando Entidades ---");
        Livro.Categoria categoria = new Livro.Categoria("cat1", "Ficção Científica", "Livros sobre o futuro.");
        livroCadastro.cadastrar("Duna", new ArrayList<>(List.of("Frank Herbert")), "Editora Aleph", "978-8576570137", 1965, "Épico de ficção científica.", 79.90, 1, 0.8, categoria, "duna.jpg", 680);
        
        try {
            Endereco endereco = new Endereco("end1", "Rua das Flores", "123", "Apto 4B", "São Paulo", "SP", "01234-567", "Brasil");
            clienteCadastro.cadastrar("João da Silva", "111.222.333-44", "joao.silva@example.com", "senha123", new ArrayList<>(List.of("11987654321")), new ArrayList<>(List.of(endereco)));
        } catch (DadoDuplicadoException e) {
            System.err.println("ERRO CAPTURADO: " + e.getMessage());
        }
        System.out.println();

        // --- 3. Testando o Tratamento de Exceções ---
        System.out.println("--- 3. Testando o Tratamento de Exceções ---");
        
        // Teste 1: Tentar cadastrar cliente com CPF duplicado
        try {
            System.out.println("Tentando cadastrar cliente com CPF duplicado...");
            Endereco dummyEndereco = new Endereco();
            clienteCadastro.cadastrar("Maria Oliveira", "111.222.333-44", "maria.o@example.com", "senha456", new ArrayList<>(), new ArrayList<>(List.of(dummyEndereco)));
        } catch (DadoDuplicadoException e) {
            System.err.println("SUCESSO NO TESTE: Exceção de CPF duplicado capturada! -> " + e.getMessage());
        }

        // Teste 2: Tentar realizar pedido com cliente inexistente
        try {
            System.out.println("\nTentando realizar pedido com cliente que não existe...");
            livrariaFacade.realizarPedido("000.000.000-00", "Duna");
        } catch (EntidadeNaoEncontradaException | EstoqueInsuficienteException e) {
            System.err.println("SUCESSO NO TESTE: Exceção de cliente não encontrado capturada! -> " + e.getMessage());
        }

        // Teste 3: Realizar pedido com sucesso e depois tentar comprar sem estoque
        try {
            System.out.println("\nRealizando um pedido válido...");
            livrariaFacade.realizarPedido("111.222.333-44", "Duna");

            System.out.println("\nTentando comprar o mesmo livro (agora sem estoque)...");
            livrariaFacade.realizarPedido("111.222.333-44", "Duna");
        } catch (LivrariaException e) { // Capturando a exceção mais genérica
            System.err.println("SUCESSO NO TESTE: Exceção de estoque insuficiente capturada! -> " + e.getMessage());
        }

        System.out.println("\n#################################################################");
        System.out.println("###            FIM DA DEMONSTRAÇÃO COM EXCEÇÕES            ###");
        System.out.println("#################################################################");
    }
}
