package edu.pucmm.gamewebapi.servicios;

import edu.pucmm.gamewebapi.entidades.Jugador;
import edu.pucmm.gamewebapi.repositorios.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServices {

    @Autowired
    private JugadorRepository jugadorRepository;

    public void init(){
        jugadorRepository.save(new Jugador("Jugador de prueba", 999));
    }

    public Jugador insert(Jugador jugador){
        return jugadorRepository.save(jugador);
    }

    public List<Jugador> findAll(){
        return jugadorRepository.findAll();
    }

    public Jugador findByID(long id){
        return jugadorRepository.findById(id);
    }

    public Jugador delete(Jugador jugador) {
        jugadorRepository.delete(jugador);
        return jugador;
    }

    public void clearAll() {

        for(Jugador a : jugadorRepository.findAll()){
            jugadorRepository.delete(a);
        }
    }
}
