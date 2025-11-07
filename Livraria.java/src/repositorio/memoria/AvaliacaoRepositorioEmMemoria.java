package repositorio.memoria;

import model.Avaliacao;
import repositorio.AvaliacaoRepositorio;

/**
 * Implementação concreta do repositório de Avaliações que usa uma lista em memória.
 */
public class AvaliacaoRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<Avaliacao, String>
        implements AvaliacaoRepositorio {

    @Override
    protected String obterId(Avaliacao entidade) {
        return entidade.getId();
    }
}
