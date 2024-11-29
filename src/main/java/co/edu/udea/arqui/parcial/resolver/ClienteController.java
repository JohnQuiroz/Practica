package co.edu.udea.arqui.parcial.resolver;

import co.edu.udea.arqui.parcial.entity.Cliente;
import co.edu.udea.arqui.parcial.entity.Pedido;
import co.edu.udea.arqui.parcial.service.ClienteService;
import co.edu.udea.arqui.parcial.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{uuid}")
    public Cliente getCliente(@PathVariable("uuid") UUID uuid) {
        return clienteService.getCliente(uuid);
    }
}
