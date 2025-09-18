import java.util.ArrayList;
import java.util.List;

public class WishList {
    private int id;
    private List<String> livrosDesejados;

    public WishList(int id) {
        this.id = id;
        this.livrosDesejados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getLivrosDesejados() {
        return livrosDesejados;
    }

    public void setLivrosDesejados(List<String> livrosDesejados) {
        this.livrosDesejados = livrosDesejados;
    }

    public void adicionarLivro(String livro) {
        livrosDesejados.add(livro);
    }

    public void removerLivro(String livro) {
        livrosDesejados.remove(livro);
    }

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", livrosDesejados=" + livrosDesejados +
                '}';
    }
}
