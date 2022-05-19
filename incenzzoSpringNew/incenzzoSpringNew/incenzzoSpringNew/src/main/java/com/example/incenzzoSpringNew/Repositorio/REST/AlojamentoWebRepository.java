package com.example.incenzzoSpringNew.Repositorio.REST;

import com.example.incenzzoSpringNew.DTO.NewAlojamentoInfoDTO;
import com.example.incenzzoSpringNew.DTO.NewLocalInfoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.util.Collections;
import java.util.Optional;

@Repository
public class AlojamentoWebRepository {
    public Optional<NewAlojamentoInfoDTO> findByCode(String code) {

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8060") // devia ser definido por configuração, e.g. em application.properties, Bean ou ser descoberto automaticamente
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8060"))
                .clientConnector( new ReactorClientHttpConnector( HttpClient.create(ConnectionProvider.newConnection())) )
                .build();

        NewAlojamentoInfoDTO alojamentoInfoDTO;
        try {
            alojamentoInfoDTO = webClient
                    .get()
                    .uri("/Alojamento/" + code) // idem configuração
                    .retrieve()

                    //tratamento de rros

                    .onStatus(HttpStatus::is4xxClientError, error -> { return Mono.empty(); })

                    .bodyToMono(NewAlojamentoInfoDTO.class)

                    .onErrorReturn( null )

                    .doOnError(throwable -> { System.out.println( throwable.getMessage() );} )
                    .block();
        }
        catch( Exception e) {

            alojamentoInfoDTO = null;
        }

        if( alojamentoInfoDTO != null )
            return Optional.of(alojamentoInfoDTO);
        else
            return Optional.empty();
    }
}
