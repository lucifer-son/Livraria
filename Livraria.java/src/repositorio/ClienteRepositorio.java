package repositorio;

import model.Cliente;

import java.util.Optional;

/**
 * Interface específica para o repositório de Clientes.
 */
public interface ClienteRepositorio extends RepositorioBase<Cliente, String> {

    /**
     * Busca um cliente pelo seu endereço de e-mail.
     * @param email O e-mail a ser buscado.
     * @return Um Optional contendo o cliente se encontrado, ou vazio caso contrário.
     */
    Optional<Cliente> buscarPorEmail(String email);
}
