package co.edu.udea.arqui.parcial.resolver;

import co.edu.udea.arqui.parcial.entity.Cliente;
import co.edu.udea.arqui.parcial.entity.Pedido;
import co.edu.udea.arqui.parcial.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Obtener un pedido por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPedido(@PathVariable("id") Integer id) {
        try {
            Pedido pedido = pedidoService.getPedido(id);
            return ResponseEntity.ok(pedido);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido no encontrado con el ID: " + id);
        }
    }

    @PostMapping("/")
    public Pedido createPedido(@RequestBody Pedido pedido){
        return pedidoService.createPedido(pedido);
    }

    @PostMapping("/update")
    public Pedido updatePedido(@RequestBody Pedido pedido){
        return pedidoService.updatePedido(pedido.getNumero(), pedido);
    }

    @PostMapping("/delete/{numero}")
    public void deletePedido(@PathVariable("numero") Integer numero){
        pedidoService.deletePedido(numero);
    }
}
