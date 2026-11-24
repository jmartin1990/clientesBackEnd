package org.example.clientes.controller;

// Importamos nuestro servicio para poder conectarlo con el controlador
import org.example.clientes.service.HoraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @RestController combina @Controller y @ResponseBody:
 * Le dice a Spring que esta clase recibe peticiones web y que todo lo que devuelvan
 * sus métodos debe serializarse directamente a formato JSON en el cuerpo de la respuesta HTTP.
 */
@RestController
// @RequestMapping define la ruta base (URL) que atenderá este controlador: http://localhost:8081/api/hora
@RequestMapping("/api/hora")
public class HoraController {

    // Declaramos el servicio como 'private final' para asegurar que no pueda ser modificado
    // después de construirse el controlador (inmutabilidad y seguridad).
    private final HoraService horaService;

    /**
     * INYECCIÓN DE DEPENDENCIAS POR CONSTRUCTOR:
     * No hacemos "new HoraService()". Spring detecta este constructor, busca el bean @Service
     * que creó al iniciar y lo pasa automáticamente como parámetro.
     * Es la mejor práctica en Spring porque desacopla las clases y facilita hacer tests unitarios.
     */
    public HoraController(HoraService horaService) {
        this.horaService = horaService;
    }

    /**
     * @GetMapping vincula este método con las peticiones HTTP de tipo GET a la ruta base (/api/hora).
     * Como el método devuelve un Map<String, String>, Spring responde por defecto con estado 200 OK
     * y convierte el mapa a JSON.
     */
    @GetMapping
    public Map<String, String> consultarHoraMadrid() {
        // El controlador no calcula nada: simplemente pide el resultado al servicio y lo retorna
        return horaService.obtenerHoraActualMadrid();
    }
}