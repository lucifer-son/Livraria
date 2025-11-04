import java.util.List;
import java.util.UUID;

public class LivroCadastroService {

    private LivroRepositorio livroRepo;

    public LivroCadastroService(LivroRepositorio livroRepo) {
        this.livroRepo = livroRepo;
    }

    public Livro cadastrar(String titulo, List<String> autores, String editora, String isbn, int ano, String descricao, double preco, int estoque, double peso, Livro.Categoria categoria, String imagem, int paginas) {
        if (livroRepo.buscar(titulo) != null) {
            System.out.println("CADASTRO(Livro) ERRO: Já existe um livro com o título '" + titulo + "'.");
            return null;
        }

        String id = UUID.randomUUID().toString();
        Livro novoLivro = new Livro(id, titulo, autores, editora, isbn, ano, descricao, preco, estoque, peso, categoria, imagem, paginas);
        livroRepo.adicionar(novoLivro);
        System.out.println("CADASTRO(Livro) INFO: Livro '" + titulo + "' cadastrado com sucesso!");
        return novoLivro;
    }
}
