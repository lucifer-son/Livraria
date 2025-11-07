package repositorio;

import java.util.List;
import java.util.Optional;

/**
 * Interface base para os repositórios do projeto.
 * Define as operações CRUD (Create, Read, Update, Delete) básicas
 * que todos os repositórios devem ter, alinhado com o exemplo da aula.
 *
 * @param <T> O tipo da entidade (ex: Livro, Cliente).
 * @param <ID> O tipo do identificador da entidade (ex: Long, Integer).
 */
public interface RepositorioBase<T, ID> {

    /**
     * Insere uma nova entidade no banco de dados.
     * @param entidade A nova entidade a ser inserida.
     */
    void inserir(T entidade);

    /**
     * Atualiza uma entidade existente no banco de dados.
     * @param entidade A entidade com os dados atualizados.
     */
    void atualizar(T entidade);

    /**
     * Busca uma entidade pelo seu identificador (ID).
     * @param id O ID da entidade a ser buscada.
     * @return um Optional contendo a entidade se encontrada, ou vazio caso contrário.
     */
    Optional<T> buscarPorId(ID id);

    /**
     * Busca todas as entidades de um tipo.
     * @return uma Lista com todas as entidades.
     */
    List<T> buscarTodos();

    /**
     * Deleta uma entidade pelo seu identificador (ID).
     * @param id O ID da entidade a ser deletada.
     */
    void deletarPorId(ID id);
}
