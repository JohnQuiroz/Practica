package co.edu.udea.arqui.parcial.service;

import co.edu.udea.arqui.parcial.entity.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ClienteService {
    public Cliente getCliente(UUID uuid){
        return null;
    }
}
