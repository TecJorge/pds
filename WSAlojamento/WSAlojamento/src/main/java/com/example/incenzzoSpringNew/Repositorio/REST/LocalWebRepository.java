package com.example.incenzzoSpringNew.Repositorio.REST;

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
public class LocalWebRepository {
    public Optional<NewLocalInfoDTO> findByCode(String code) {

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8070") // devia ser definido por configuração, e.g. em application.properties, Bean ou ser descoberto automaticamente
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8070"))
                .clientConnector( new ReactorClientHttpConnector( HttpClient.create(ConnectionProvider.newConnection())) )
                .build();

        NewLocalInfoDTO localInfoDTO;
        try {
            localInfoDTO = webClient
                    .get()
                    .uri("/Local/" + code) // idem configuração
                    .retrieve()

                    //tratamento de rros

                    .onStatus(HttpStatus::is4xxClientError, error -> { return Mono.empty(); })

                    .bodyToMono(NewLocalInfoDTO.class)

                    .onErrorReturn( null )

                    .doOnError(throwable -> { System.out.println( throwable.getMessage() );} )
                    .block();
        }
        catch( Exception e) {

            localInfoDTO = null;
        }

        if( localInfoDTO != null )
            return Optional.of(localInfoDTO);
        else
            return Optional.empty();
    }
}
