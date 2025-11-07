package repositorio;

import model.CupomPromocional;

import java.util.Optional;

/**
 * Interface específica para o repositório de Cupons Promocionais.
 */
public interface CupomPromocionalRepositorio extends RepositorioBase<CupomPromocional, String> {

    /**
     * Busca um cupom pelo seu código único.
     * @param codigo O código do cupom.
     * @return Um Optional contendo o cupom se encontrado.
     */
    Optional<CupomPromocional> buscarPorCodigo(String codigo);
}
