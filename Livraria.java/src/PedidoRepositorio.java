public class PedidoRepositorio extends AbstractRepositorio<Pedido> {

    private static int contadorInstancias = 0;

    public PedidoRepositorio() {
        super(Pedido.class); // Passa a classe Pedido para o construtor pai
        contadorInstancias++;
    }

    public Pedido buscar(int id) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (itens[i].getId() == id) {
                return itens[i];
            }
        }
        return null;
    }

    public boolean remover(int id) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (itens[i].getId() == id) {
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
