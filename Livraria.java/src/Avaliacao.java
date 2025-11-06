import java.util.Date;

public class Avaliacao {
    private int id;
    private int nota;
    private String comentario;
    private Date data;
    private boolean aprovado;

    public Avaliacao(int id, int nota, String comentario, Date data, boolean aprovado) {
        this.id = id;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
        this.aprovado = aprovado;
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
}
