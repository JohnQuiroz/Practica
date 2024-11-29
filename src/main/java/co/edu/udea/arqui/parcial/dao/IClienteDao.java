package co.edu.udea.arqui.parcial.dao;

import co.edu.udea.arqui.parcial.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, String> {

    // Buscar un cliente por su nombre
    Optional<Cliente> findByNombre(String nombre);

    // Buscar clientes por dirección
    Optional<Cliente> findByDireccion(String direccion);
}
