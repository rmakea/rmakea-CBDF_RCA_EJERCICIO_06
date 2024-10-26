package com.upiiz.cam.services;

import com.upiiz.cam.models.ClienteEntity;
import com.upiiz.cam.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos
    public List<ClienteEntity> obtenerTodos() {
        return clienteRepository.findAll();
    }

    // Guardar un cliente
    public ClienteEntity guardarCliente(ClienteEntity clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }


    // Actualizar un cliente
    public ClienteEntity actualizarCliente(ClienteEntity clienteEntity) {
        if (clienteRepository.existsById(clienteEntity.getId())) {
            return clienteRepository.save(clienteEntity);
        }
        return null;
    }

    // Eliminar un cliente
    public boolean eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }


}