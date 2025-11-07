package repositorio.memoria;

import model.Usuario;
import repositorio.UsuarioRepositorio;

import java.util.Optional;

/**
 * Implementação concreta do repositório de Usuários que usa uma lista em memória.
 */
public class UsuarioRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<Usuario, String>
        implements UsuarioRepositorio {

    @Override
    protected String obterId(Usuario entidade) {
        return entidade.getId();
    }

    @Override
    public Optional<Usuario> buscarPorLogin(String login) {
        for (Usuario usuario : this.elementos) {
            if (usuario.getLogin().equalsIgnoreCase(login)) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }
}
