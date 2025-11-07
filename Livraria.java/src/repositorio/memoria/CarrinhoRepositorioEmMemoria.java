package repositorio.memoria;

import model.Carrinho;
import repositorio.CarrinhoRepositorio;

/**
 * Implementação concreta do repositório de Carrinhos que usa uma lista em memória.
 */
public class CarrinhoRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<Carrinho, String>
        implements CarrinhoRepositorio {

    @Override
    protected String obterId(Carrinho entidade) {
        return entidade.getId();
    }

    // Como a interface CarrinhoRepositorio não tem métodos específicos,
    // não precisamos implementar mais nada aqui. A herança já fez todo o trabalho.
}
