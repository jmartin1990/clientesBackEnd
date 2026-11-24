package org.example.clientes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; /**
 * Controlador REST: recibe las peticiones HTTP y devuelve JSON.
 *
 *   GET    /api/clientes        -> lista todos los clientes
 *   GET    /api/clientes/{id}   -> obtiene un cliente
 *   POST   /api/clientes        -> crea un cliente
 *   PUT    /api/clientes/{id}   -> actualiza un cliente
 *   DELETE /api/clientes/{id}   -> borra un cliente
 */
@RestController

@RequestMapping("/ping")
public class PingController {
    @GetMapping
    public String ping() {return "Pong!";}
}
