package repositorio.memoria;

import model.Pedido;
import repositorio.PedidoRepositorio;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação concreta do repositório de Pedidos que usa uma lista em memória.
 */
public class PedidoRepositorioEmMemoria
        extends RepositorioBaseEmMemoria<Pedido, String>
        implements PedidoRepositorio {

    @Override
    protected String obterId(Pedido entidade) {
        return entidade.getId();
    }

    @Override
    public List<Pedido> buscarPorStatus(Pedido.StatusPedido status) {
        List<Pedido> pedidosComStatus = new ArrayList<>();
        for (Pedido pedido : this.elementos) {
            if (pedido.getStatus() == status) {
                pedidosComStatus.add(pedido);
            }
        }
        return pedidosComStatus;
    }
}
