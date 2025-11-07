package repositorio.memoria;

import model.Notificacao;
import repositorio.NotificacaoRepositorio;

/**
 * Implementação concreta do repositório de Notificações que usa uma lista em memória.
 */
public class NotificacaoRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<Notificacao, String>
        implements NotificacaoRepositorio {

    @Override
    protected String obterId(Notificacao entidade) {
        return entidade.getId();
    }
}
