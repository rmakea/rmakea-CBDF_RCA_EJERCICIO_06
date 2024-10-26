package com.upiiz.cam.controllers;

import com.upiiz.cam.models.ClienteEntity;
import com.upiiz.cam.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getClientes() {
        return ResponseEntity.ok(clienteService.obtenerTodos());
    }

    @PostMapping // Agregada la anotación para manejar solicitudes POST
    public ResponseEntity<ClienteEntity> guardar(@RequestBody ClienteEntity clienteEntity) {
        ClienteEntity nuevoCliente = clienteService.guardarCliente(clienteEntity);
        return ResponseEntity.ok(nuevoCliente);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteEntity> actualizar(@PathVariable Long id, @RequestBody ClienteEntity clienteEntity) {
        clienteEntity.setId(id); // Aseguramos que el ID del path coincida con el del objeto
        ClienteEntity clienteActualizado = clienteService.actualizarCliente(clienteEntity);
        if (clienteActualizado != null) {
            return ResponseEntity.ok(clienteActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (clienteService.eliminarCliente(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
