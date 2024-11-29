package co.edu.udea.arqui.parcial.resolver;

import co.edu.udea.arqui.parcial.entity.Cliente;
import co.edu.udea.arqui.parcial.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Obtener un cliente por su UUID
    @GetMapping("/{uuid}")
    public ResponseEntity<?> getCliente(@PathVariable("uuid") UUID uuid) {
        try {
            Cliente cliente = clienteService.getCliente(uuid);
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado con UUID: " + uuid);
        }
    }

    @GetMapping("/")
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PostMapping("/")
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteService.createCliente(cliente);
    }

    @PostMapping("/update")
    public Cliente updateCliente(@RequestBody Cliente clienteDetails){
        return clienteService.updateCliente(clienteDetails.getUuid(), clienteDetails);
    }

    @PostMapping("/delete/{uuid}")
    public void deleteCliente(@PathVariable("uuid") UUID uuid){
        clienteService.deleteCliente(uuid);
    }
}
