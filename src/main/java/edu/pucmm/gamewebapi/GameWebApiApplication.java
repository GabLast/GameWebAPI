package edu.pucmm.gamewebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameWebApiApplication.class, args);
//        ApplicationContext applicationContext = SpringApplication.run(GameWebApiApplication.class, args);
//        JugadorServices jugadorServices = (JugadorServices) applicationContext.getBean("jugadorServices");
//        jugadorServices.init();
    }

}
