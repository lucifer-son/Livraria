package repositorio.memoria;

import model.CupomPromocional;
import repositorio.CupomPromocionalRepositorio;

import java.util.Optional;

/**
 * Implementação concreta do repositório de Cupons Promocionais que usa uma lista em memória.
 */
public class CupomPromocionalRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<CupomPromocional, String>
        implements CupomPromocionalRepositorio {

    @Override
    protected String obterId(CupomPromocional entidade) {
        return entidade.getId();
    }

    @Override
    public Optional<CupomPromocional> buscarPorCodigo(String codigo) {
        for (CupomPromocional cupom : this.elementos) {
            if (cupom.getCodigo().equalsIgnoreCase(codigo)) {
                return Optional.of(cupom);
            }
        }
        return Optional.empty();
    }
}
