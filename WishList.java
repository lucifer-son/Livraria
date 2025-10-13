import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishList wishList = (WishList) o;
        return id == wishList.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", livrosDesejados=" + livrosDesejados +
                '}';
    }
}
