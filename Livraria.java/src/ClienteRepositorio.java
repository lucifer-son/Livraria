public class ClienteRepositorio extends AbstractRepositorio<Cliente> {

    private static int contadorInstancias = 0;

    public ClienteRepositorio() {
        super(Cliente.class); // Passa a classe Cliente para o construtor pai
        contadorInstancias++;
    }

    public Cliente buscar(String cpf) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (itens[i].getCpf().equals(cpf)) {
                return itens[i];
            }
        }
        return null;
    }

    public boolean remover(String cpf) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (itens[i].getCpf().equals(cpf)) {
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
