package edu.pucmm.gamewebapi.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pucmm.gamewebapi.entidades.Jugador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 1800, origins = "*")
@RestController
@RequestMapping("/jugador")
public class JugadorAPI {

    @PostMapping("")
    public ResponseEntity<?> postScore(@RequestBody Jugador jugador) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return new ResponseEntity<>(objectMapper.writeValueAsString("nice"), null, 200);
    }
}
