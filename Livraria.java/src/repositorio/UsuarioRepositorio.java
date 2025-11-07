package repositorio;

import model.Usuario;

import java.util.Optional;

/**
 * Interface específica para o repositório de Usuários.
 */
public interface UsuarioRepositorio extends RepositorioBase<Usuario, String> {

    /**
     * Busca um usuário pelo seu login.
     * @param login O login a ser buscado.
     * @return Um Optional contendo o usuário se encontrado, ou vazio caso contrário.
     */
    Optional<Usuario> buscarPorLogin(String login);
}
