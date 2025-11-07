package repositorio;

import model.Pedido;

import java.util.List;

/**
 * Interface específica para o repositório de Pedidos.
 */
public interface PedidoRepositorio extends RepositorioBase<Pedido, String> {

    /**
     * Busca todos os pedidos que estão com um determinado status.
     * @param status O status do pedido a ser buscado.
     * @return Uma lista de pedidos com o status especificado.
     */
    List<Pedido> buscarPorStatus(Pedido.StatusPedido status);
}
