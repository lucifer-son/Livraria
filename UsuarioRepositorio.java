public class UsuarioRepositorio extends AbstractRepositorio<Usuario> {

    private static int contadorInstancias = 0;

    public UsuarioRepositorio() {
        super(Usuario.class); // Passa a classe Usuario para o construtor pai
        contadorInstancias++;
    }

    public Usuario buscarPorEmail(String email) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (itens[i].getEmail().equals(email)) {
                return itens[i];
            }
        }
        return null;
    }

    public boolean removerPorEmail(String email) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (itens[i].getEmail().equals(email)) {
                for (int j = i; j < proximaPosicao - 1; j++) {
                    itens[j] = itens[j + 1];
                }
                itens[proximaPosicao - 1] = null;
                proximaPosicao--;
                return true;
            }
        }
        return false;
    }

    public static int getContadorInstancias() {
        return contadorInstancias;
    }
}
