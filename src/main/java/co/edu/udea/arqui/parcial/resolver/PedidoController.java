package co.edu.udea.arqui.parcial.resolver;

import co.edu.udea.arqui.parcial.entity.Pedido;
import co.edu.udea.arqui.parcial.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable("id") Integer id) {
        return pedidoService.getPedido(id);
    }
}
