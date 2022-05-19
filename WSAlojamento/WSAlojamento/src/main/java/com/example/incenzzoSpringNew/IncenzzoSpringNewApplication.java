package com.example.incenzzoSpringNew;

import com.example.incenzzoSpringNew.Services.AlojamentoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IncenzzoSpringNewApplication {

  //  private static final Logger log = LoggerFactory.getLogger(IncenzzoSpringNewApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(IncenzzoSpringNewApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AlojamentoService alojamentoService) {
        return (args) -> {
        };
    }
}
