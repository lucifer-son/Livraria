package repositorio.memoria;

import model.Livro;
import repositorio.LivroRepositorio;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação concreta do repositório de Livros que usa uma lista em memória.
 * Herda toda a lógica CRUD da classe RepositorioBaseEmMemoria.
 */
public class LivroRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<Livro, String>
        implements LivroRepositorio {

    /**
     * Ensina à classe pai como obter o ID de um objeto Livro.
     * Este é o único método obrigatório pela classe abstrata.
     */
    @Override
    protected String obterId(Livro entidade) {
        return entidade.getId();
    }

    /**
     * Implementação do método de busca específico para livros.
     * Este método é obrigatório pela interface LivroRepositorio.
     */
    @Override
    public List<Livro> buscarPorAutor(String autor) {
        List<Livro> livrosDoAutor = new ArrayList<>();
        // Percorre a lista de elementos (que foi herdada da classe pai)
        for (Livro livro : this.elementos) {
            // O método contains é uma forma simples de verificar se o autor está na lista de autores do livro
            if (livro.getAutores().contains(autor)) {
                livrosDoAutor.add(livro);
            }
        }
        return livrosDoAutor;
    }
}
