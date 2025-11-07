package repositorio.memoria;

import model.WishList;
import repositorio.WishListRepositorio;

/**
 * Implementação concreta do repositório de WishLists que usa uma lista em memória.
 */
public class WishListRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<WishList, String>
        implements WishListRepositorio {

    @Override
    protected String obterId(WishList entidade) {
        return entidade.getId();
    }
}
