package com.example.incenzzoSpringNew.Repositorio.REST;

import com.example.incenzzoSpringNew.DTO.NewTipoAlojamentoInfoDTO;
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
public class TipoAlojamentoWebRepository    {
    public Optional<NewTipoAlojamentoInfoDTO> findByCode(String code) {

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8090") // devia ser definido por configuração, e.g. em application.properties, Bean ou ser descoberto automaticamente
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8090"))
                .clientConnector( new ReactorClientHttpConnector( HttpClient.create(ConnectionProvider.newConnection())) )
                .build();

        NewTipoAlojamentoInfoDTO TipoAlojamentoRestDTO;
        try {
            TipoAlojamentoRestDTO = webClient
                    .get()
                    .uri("/TipoAlojamento/" + code) // idem configuração
                    .retrieve()

                    //tratamento de rros

                    .onStatus(HttpStatus::is4xxClientError, error -> { return Mono.empty(); })

                    .bodyToMono(NewTipoAlojamentoInfoDTO.class)

                    .onErrorReturn( null )

                    .doOnError(throwable -> { System.out.println( throwable.getMessage() );} )
                    .block();
        }
        catch( Exception e) {

            TipoAlojamentoRestDTO = null;
        }

        if( TipoAlojamentoRestDTO != null )
            return Optional.of(TipoAlojamentoRestDTO);
        else
            return Optional.empty();
    }
}
