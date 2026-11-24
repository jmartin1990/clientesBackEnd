// Define el paquete donde se ubica esta clase dentro de la estructura del proyecto
package org.example.clientes.service;

// Anotación de Spring que marca esta clase como un componente de lógica de negocio
import org.springframework.stereotype.Service;

// Clases modernas de Java (java.time) para manejar zonas horarias y formatos de fecha/hora
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @Service le indica a Spring Boot que cree una instancia única (Singleton) de esta clase
 * al arrancar la aplicación y la guarde en su contenedor para poder inyectarla donde se necesite.
 */
@Service
public class HoraService {

    // Definimos la zona horaria oficial de Madrid como una constante (static final).
    // Usar "Europe/Madrid" garantiza que el cálculo funcione igual aunque el servidor
    // esté alojado en otro país o en un contenedor Docker con hora UTC, y ajusta solo el cambio de horario (verano/invierno).
    private static final ZoneId ZONA_HORARIA_MADRID = ZoneId.of("Europe/Madrid");

    // Definimos el patrón de formato de 24 horas como constante para no recrearlo en cada petición.
    // "HH" en mayúscula indica formato 24h (00 a 23). Si fuera "hh" en minúscula sería formato 12h (AM/PM).
    // "mm" son minutos y "ss" son segundos.
    private static final DateTimeFormatter FORMATO_24_HORAS = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * Obtiene la hora actual en Madrid y la prepara en una estructura clave-valor.
     *
     * @return Un Map (diccionario) con la clave "madrid" y el valor de la hora formateada.
     */
    public Map<String, String> obtenerHoraActualMadrid() {
        // 1. Obtenemos la fecha y hora exacta en este instante dentro de la zona de Madrid
        ZonedDateTime fechaHoraMadrid = ZonedDateTime.now(ZONA_HORARIA_MADRID);

        // 2. Aplicamos la plantilla "HH:mm:ss" para convertir ese objeto de tiempo en un texto legible (ej. "18:20:45")
        String horaFormateada = fechaHoraMadrid.format(FORMATO_24_HORAS);

        // 3. Devolvemos un Map inmutable con un solo par clave-valor.
        // Spring Boot (mediante la librería Jackson) transformará este Map automáticamente al JSON: {"madrid": "18:20:45"}
        return Map.of("madrid", horaFormateada);
    }
}