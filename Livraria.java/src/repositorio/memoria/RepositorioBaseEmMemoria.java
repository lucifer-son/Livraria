package repositorio.memoria;

import repositorio.RepositorioBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementação base abstrata para repositórios que usam uma lista em memória.
 * Contém toda a lógica comum de manipulação da lista, evitando repetição de código.
 * Esta classe é abstrata porque precisa que a classe filha (concreta) ensine
 * a ela como obter o ID de uma entidade.
 *
 * @param <T> O tipo da entidade.
 * @param <ID> O tipo do ID da entidade.
 */
public abstract class RepositorioBaseEmMemoria<T, ID> implements RepositorioBase<T, ID> {

    // A lista onde todos os elementos serão guardados em memória.
    // 'protected' para que as classes filhas possam acessá-la se precisarem.
    protected final List<T> elementos = new ArrayList<>();

    /**
     * Este é o método abstrato que FORÇA a classe filha a implementar a lógica
     * para obter o ID de uma entidade específica. É o elo entre o código genérico
     * desta classe e o código específico da classe filha.
     *
     * @param entidade A entidade da qual o ID será extraído.
     * @return O ID da entidade.
     */
    protected abstract ID obterId(T entidade);

    @Override
    public void inserir(T entidade) {
        // Simplesmente adiciona a nova entidade à lista.
        // Uma melhoria seria verificar se o ID já existe para evitar duplicados.
        elementos.add(entidade);
    }

    @Override
    public void atualizar(T entidade) {
        // Busca a entidade existente pelo ID.
        buscarPorId(obterId(entidade)).ifPresent(existente -> {
            // Se encontrou, descobre o índice dela na lista.
            int indice = elementos.indexOf(existente);
            // Substitui o elemento antigo pelo novo (atualizado) no mesmo lugar.
            elementos.set(indice, entidade);
        });
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        // Percorre a lista e retorna o primeiro elemento que tiver o ID correspondente.
        return elementos.stream()
                .filter(elemento -> obterId(elemento).equals(id))
                .findFirst();
    }

    @Override
    public List<T> buscarTodos() {
        // Retorna uma CÓPIA da lista para evitar que o código externo
        // modifique a lista original do repositório diretamente.
        return new ArrayList<>(elementos);
    }

    @Override
    public void deletarPorId(ID id) {
        // Busca o elemento pelo ID e, se encontrar, o remove da lista.
        buscarPorId(id).ifPresent(elementos::remove);
    }
}
