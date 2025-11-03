import java.lang.reflect.Array;
import java.util.Arrays;


public abstract class AbstractRepositorio<T> {

    protected T[] itens;
    protected int proximaPosicao;

    @SuppressWarnings("unchecked")
    public AbstractRepositorio(Class<T> clazz) {
        // Usa reflection para criar um array do tipo genérico T, de forma segura.
        this.itens = (T[]) Array.newInstance(clazz, 10);
        this.proximaPosicao = 0;
    }


    public void adicionar(T item) {
        if (this.proximaPosicao >= this.itens.length) {
            this.itens = Arrays.copyOf(this.itens, this.itens.length * 2);
        }
        this.itens[this.proximaPosicao] = item;
        this.proximaPosicao++;
    }

    public T[] listarTodos() {
        return Arrays.copyOf(this.itens, this.proximaPosicao);
    }
}
