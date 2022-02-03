package edu.pucmm.gamewebapi.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Jugador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String nombreJugador;
    private long score;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fechaRegistro = new Date();
}
