import java.util.UUID;

public class UsuarioCadastroService {

    private UsuarioRepositorio usuarioRepo;

    public UsuarioCadastroService(UsuarioRepositorio usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public Admin cadastrarAdmin(String nome, String email, String senha) {
        if (usuarioRepo.buscarPorEmail(email) != null) {
            System.out.println("CADASTRO(Admin) ERRO: O email '" + email + "' já está em uso.");
            return null;
        }
        String id = UUID.randomUUID().toString();
        Admin novoAdmin = new Admin(id, nome, email, senha);
        usuarioRepo.adicionar(novoAdmin);
        System.out.println("CADASTRO(Admin) INFO: Administrador '" + nome + "' cadastrado com sucesso!");
        return novoAdmin;
    }
}

