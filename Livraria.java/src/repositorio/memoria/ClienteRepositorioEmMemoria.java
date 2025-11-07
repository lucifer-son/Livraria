package repositorio.memoria;

import model.Cliente;
import repositorio.ClienteRepositorio;

import java.util.Optional;

/**
 * Implementação concreta do repositório de Clientes que usa uma lista em memória.
 */
public class ClienteRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<Cliente, String>
        implements ClienteRepositorio {

    @Override
    protected String obterId(Cliente entidade) {
        return entidade.getId();
    }

    @Override
    public Optional<Cliente> buscarPorEmail(String email) {
        // Percorre a lista de elementos herdada da classe pai
        for (Cliente cliente : this.elementos) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                // Retorna o cliente encontrado dentro de um Optional
                return Optional.of(cliente);
            }
        }
        // Se o loop terminar sem encontrar, retorna um Optional vazio
        return Optional.empty();
    }
}
