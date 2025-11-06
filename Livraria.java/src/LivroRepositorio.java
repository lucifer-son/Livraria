public class LivroRepositorio extends AbstractRepositorio<Livro> {

    private static int contadorInstancias = 0;

    public LivroRepositorio() {
        super(Livro.class); 
        contadorInstancias++;
    }

    public Livro buscar(String titulo) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (itens[i].getTitulo().equals(titulo)) {
                return itens[i];
            }
        }
        return null;
    }

    public boolean remover(String titulo) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (itens[i].getTitulo().equals(titulo)) {
                // Desloca os elementos para a esquerda para preencher o espaço
                for (int j = i; j < proximaPosicao - 1; j++) {
                    itens[j] = itens[j + 1];
                }
                itens[proximaPosicao - 1] = null; // Limpa a última posição
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

