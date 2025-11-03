import java.util.Date;
import java.util.Objects;

public class Avaliacao {
    private int id;
    private int nota;
    private String comentario;
    private Date data;
    private boolean aprovado;
    private static int contadorInstancias = 0;

    public Avaliacao(int id, int nota, String comentario, Date data, boolean aprovado) {
        this.id = id;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
        this.aprovado = aprovado;
        contadorInstancias++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public boolean validarNota() {
        return this.nota >= 1 && this.nota <= 5;
    }

    public static int getContadorInstancias() {
        return contadorInstancias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return id == avaliacao.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                ", data=" + data +
                ", aprovado=" + aprovado +
                '}';
    }
}