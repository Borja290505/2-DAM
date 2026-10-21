package org.iesch.ad.demoSpring1.config;

import org.iesch.ad.demoSpring1.modelo.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Configuracion {
    @Bean
    public List<Persona> dameLista(){
//        Persona p = Persona.builder().id(1L).build();
//        Persona p1 = Persona.builder().id(2L).build();
//        Persona p2 = Persona.builder().id(3L).build();
//        Persona p3 = Persona.builder().id(4L).build();
//        Persona p4 = Persona.builder().id(5L).nombre("Andres").build();

        List<Persona> personaList = new ArrayList<>(Arrays.asList(p, p1, p2, p3, p4));

        return personaList;
    }

}
