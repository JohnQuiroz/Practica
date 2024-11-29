package co.edu.udea.arqui.parcial.service;


import co.edu.udea.arqui.parcial.dao.IClienteDao;
import co.edu.udea.arqui.parcial.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private IClienteDao clienteRepository;

    // Obtener un cliente por UUID
    public Cliente getCliente(UUID uuid) {
        return clienteRepository.findById(uuid.toString())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con UUID: " + uuid));
    }

    // Obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Crear un nuevo cliente
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente updateCliente(UUID uuid, Cliente clienteDetails) {
        Cliente cliente = getCliente(uuid);
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setDireccion(clienteDetails.getDireccion());
        cliente.setTelefono(clienteDetails.getTelefono());
        return clienteRepository.save(cliente);
    }

    // Eliminar un cliente
    public void deleteCliente(UUID uuid) {
        Cliente cliente = getCliente(uuid);
        clienteRepository.delete(cliente);
    }
}
