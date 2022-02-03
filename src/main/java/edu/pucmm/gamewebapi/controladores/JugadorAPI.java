package edu.pucmm.gamewebapi.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pucmm.gamewebapi.entidades.Jugador;
import edu.pucmm.gamewebapi.servicios.JugadorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(maxAge = 1800, origins = "*")
@RestController
@RequestMapping("/jugador")
public class JugadorAPI {

    @Autowired
    private JugadorServices jugadorServices;

    @GetMapping("")
    public ResponseEntity<?> getAll() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return new ResponseEntity<>(jugadorServices.findAll(), null, 200);
    }

    @GetMapping("/find")
    public ResponseEntity<?> getByID(@RequestParam(name = "id", required = false) long id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return new ResponseEntity<>(jugadorServices.findByID(id), null, 200);
    }

    @PostMapping("")
    public ResponseEntity<?> postScore(@RequestBody Jugador jugador) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        jugador.setId(0);
        jugador.setFechaRegistro(new Date());

        if(jugador.getNombreJugador().isEmpty()){
            return new ResponseEntity<>("ERROR: No se ha enviado el nombre del jugador", null, 400);
        }

        return new ResponseEntity<>(jugadorServices.insert(jugador), null, 200);
    }

    @PutMapping("")
    public ResponseEntity<?> getAll(@RequestBody Jugador jugador) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        jugador.setId(0);
        jugador.setFechaRegistro(new Date());

        if(jugador.getNombreJugador().isEmpty()){
            return new ResponseEntity<>("ERROR: No se ha enviado el nombre del jugador", null, 400);
        }

        return new ResponseEntity<>(jugadorServices.insert(jugador), null, 200);
    }
}
