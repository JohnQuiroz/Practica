package co.edu.udea.arqui.parcial.service;

import co.edu.udea.arqui.parcial.dao.IpedidoDao;
import co.edu.udea.arqui.parcial.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private IpedidoDao ipedidoDao;

    // Obtener un pedido por ID
    public Pedido getPedido(Integer id) {
        return ipedidoDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con el ID: " + id));
    }

    // Crear un nuevo pedido
    public Pedido createPedido(Pedido pedido) {
        return ipedidoDao.save(pedido);
    }

    // Actualizar un pedido existente
    public Pedido updatePedido(Integer id, Pedido pedidoDetails) {
        Pedido pedido = getPedido(id);
        pedido.setEstado(pedidoDetails.getEstado());
        pedido.setHoraEntrega(pedidoDetails.getHoraEntrega());
        pedido.setHoraPedido(pedidoDetails.getHoraPedido());
        pedido.setCliente(pedidoDetails.getCliente());
        return ipedidoDao.save(pedido);
    }

    // Eliminar un pedido por ID
    public void deletePedido(Integer id) {
        Pedido pedido = getPedido(id);
        ipedidoDao.delete(pedido);
    }
}
