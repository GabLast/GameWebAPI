package edu.pucmm.gamewebapi;

import edu.pucmm.gamewebapi.servicios.JugadorServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GameWebApiApplication {

    public static void main(String[] args) {
//        SpringApplication.run(GameWebApiApplication.class, args);
        ApplicationContext applicationContext = SpringApplication.run(GameWebApiApplication.class, args);
        JugadorServices jugadorServices = (JugadorServices) applicationContext.getBean("jugadorServices");
        jugadorServices.init();
    }

}
