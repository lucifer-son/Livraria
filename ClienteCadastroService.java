import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ClienteCadastroService {

    private ClienteRepositorio clienteRepo;
    private UsuarioRepositorio usuarioRepo;

    public ClienteCadastroService(ClienteRepositorio clienteRepo, UsuarioRepositorio usuarioRepo) {
        this.clienteRepo = clienteRepo;
        this.usuarioRepo = usuarioRepo;
    }

    public Cliente cadastrar(String nome, String cpf, String email, String senha, List<String> telefones, List<Endereco> enderecos) 
            throws DadoDuplicadoException {

        if (usuarioRepo.buscarPorEmail(email) != null) {
            throw new DadoDuplicadoException("O email '" + email + "' já está em uso.");
        }
        if (clienteRepo.buscar(cpf) != null) {
            throw new DadoDuplicadoException("O CPF '" + cpf + "' já está cadastrado.");
        }

        String id = UUID.randomUUID().toString();
        Cliente novoCliente = new Cliente(id, nome, cpf, email, senha, telefones, enderecos, new Date());
        usuarioRepo.adicionar(novoCliente);
        clienteRepo.adicionar(novoCliente);
        System.out.println("CADASTRO(Cliente) INFO: Cliente '" + nome + "' cadastrado com sucesso!");
        return novoCliente;
    }
}
