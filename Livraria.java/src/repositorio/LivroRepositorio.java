package repositorio;

import model.Livro;
import java.util.List;

/**
 * Interface específica para o repositório de Livros.
 * Herda o contrato básico de RepositorioBase e pode adicionar
 * métodos de busca que só fazem sentido para Livros.
 */
public interface LivroRepositorio extends RepositorioBase<Livro, String> {

    /**
     * Exemplo de um método de busca específico para livros.
     * @param autor O nome do autor a ser buscado.
     * @return Uma lista de livros que correspondem ao autor.
     */
    List<Livro> buscarPorAutor(String autor);
}
