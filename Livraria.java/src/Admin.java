/**
 * Representa um usuário Administrador do sistema.
 * Herda de Usuário e adiciona o papel de ADMIN no construtor.
 */
public class Admin extends Usuario {

    public Admin(String id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        this.getRoles().add("ADMIN");
    }
}
