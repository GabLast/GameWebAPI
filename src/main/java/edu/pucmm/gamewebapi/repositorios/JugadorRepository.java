package edu.pucmm.gamewebapi.repositorios;

import edu.pucmm.gamewebapi.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    Jugador findById(long id);
}
