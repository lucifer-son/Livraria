package repositorio.memoria;

import model.Pagamento;
import repositorio.PagamentoRepositorio;

/**
 * Implementação concreta do repositório de Pagamentos que usa uma lista em memória.
 */
public class PagamentoRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<Pagamento, String>
        implements PagamentoRepositorio {

    @Override
    protected String obterId(Pagamento entidade) {
        return entidade.getId();
    }
}
