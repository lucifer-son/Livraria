public class Admin extends Usuario {

    public Admin(String id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        this.getRoles().add("ADMIN");
    }
}
