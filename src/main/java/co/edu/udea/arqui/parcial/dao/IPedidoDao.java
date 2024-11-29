package co.edu.udea.arqui.parcial.dao;

import co.edu.udea.arqui.parcial.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPedidoDao extends JpaRepository<Pedido, Integer> {


    // Metodo para obtener un pedido por nombre del cliente
    Optional<Pedido> findByClienteNombre(String nombre);
}
