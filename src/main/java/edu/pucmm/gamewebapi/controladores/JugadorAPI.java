package edu.pucmm.gamewebapi.controladores;

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
    public ResponseEntity<?> getAll() {

        return new ResponseEntity<>(jugadorServices.findAll(), null, 200);
    }

    @GetMapping("/find")
    public ResponseEntity<?> getByID(@RequestParam(name = "id", required = false) int id) {

        return new ResponseEntity<>(jugadorServices.findByID(id), null, 200);
    }

//    @PostMapping("")
//    public ResponseEntity<?> postScore(@RequestBody Jugador jugador) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        jugador.setId(0);
//        jugador.setFechaRegistro(new Date());
//
//        if(jugador.getNombreJugador().isEmpty()){
//            return new ResponseEntity<>("ERROR: No se ha enviado el nombre del jugador", null, 400);
//        }
//
//        return new ResponseEntity<>(jugadorServices.insert(jugador), null, 200);
//    }

    @PutMapping("")
    public ResponseEntity<?> put(@RequestBody Jugador jugador) {

        jugador.setId(0);
        jugador.setFechaRegistro(new Date());

        if(jugador.getNombreJugador().isEmpty()){
            return new ResponseEntity<>("ERROR: No se ha enviado el nombre del jugador", null, 400);
        }

        return new ResponseEntity<>(jugadorServices.insert(jugador), null, 200);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Jugador jugador) {
        Jugador player;

        try {
            player = jugadorServices.findByID(jugador.getId());
        }catch (NullPointerException e){
            return new ResponseEntity<>("ERROR: Jugador no existe", null, 400);
        }
        player.setScore(jugador.getScore());
        player.setNombreJugador(jugador.getNombreJugador());

        return new ResponseEntity<>(jugadorServices.insert(player), null, 200);
    }

    @PutMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam(name = "id") int id) {
        Jugador player;

        try {
            player = jugadorServices.findByID(id);
        }catch (NullPointerException e){
            return new ResponseEntity<>("ERROR: Jugador no existe", null, 400);
        }

        return new ResponseEntity<>(jugadorServices.delete(player), null, 200);
    }

    @DeleteMapping("/PELIGROSO")
    public ResponseEntity<?> alldelete() {
        jugadorServices.clearAll();
        return new ResponseEntity<>("Everything has been deleted", null, 200);
    }
}
