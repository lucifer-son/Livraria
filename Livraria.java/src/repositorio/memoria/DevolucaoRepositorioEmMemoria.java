package repositorio.memoria;

import model.Devolucao;
import repositorio.DevolucaoRepositorio;

/**
 * Implementação concreta do repositório de Devoluções que usa uma lista em memória.
 */
public class DevolucaoRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<Devolucao, String>
        implements DevolucaoRepositorio {

    @Override
    protected String obterId(Devolucao entidade) {
        return entidade.getId();
    }
}
