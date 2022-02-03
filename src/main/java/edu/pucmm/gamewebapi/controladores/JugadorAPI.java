package edu.pucmm.gamewebapi.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pucmm.gamewebapi.entidades.Jugador;
import edu.pucmm.gamewebapi.servicios.JugadorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 1800, origins = "*")
@RestController
@RequestMapping("/jugador")
public class JugadorAPI {

    @Autowired
    private JugadorServices jugadorServices;

    @GetMapping("")
    public ResponseEntity<?> getAll() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return new ResponseEntity<>(objectMapper.writeValueAsString(jugadorServices.findAll()), null, 200);
    }

    @GetMapping("/find")
    public ResponseEntity<?> getByID(@RequestParam(name = "id", required = false) long id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return new ResponseEntity<>(objectMapper.writeValueAsString(jugadorServices.findByID(id)), null, 200);
    }

    @PostMapping("")
    public ResponseEntity<?> postScore(@RequestBody Jugador jugador) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        if(jugador.getNombreJugador().isEmpty()){
            return new ResponseEntity<>(objectMapper.writeValueAsString("ERROR: No se ha enviado el nombre del jugador"), null, 400);
        }

        return new ResponseEntity<>(objectMapper.writeValueAsString(jugadorServices.insert(jugador)), null, 200);
    }

    @PutMapping("")
    public ResponseEntity<?> getAll(@RequestBody Jugador jugador) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Jugador aux;

        try {
            aux = jugadorServices.findByID(jugador.getId());
        }catch (NullPointerException e){
            return new ResponseEntity<>(objectMapper.writeValueAsString("ERROR: El jugador de ID [" + jugador.getId() + "] no existe"),
                    null, 400);
        }

        aux.setNombreJugador(jugador.getNombreJugador());
        aux.setScore(jugador.getScore());


        return new ResponseEntity<>(objectMapper.writeValueAsString(jugadorServices.insert(aux)), null, 200);
    }
}
