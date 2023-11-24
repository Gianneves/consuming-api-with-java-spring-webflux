package com.gianneves.rickandmortyapispringwebflex.client;

import com.gianneves.rickandmortyapispringwebflex.response.CharacterResponse;
import com.gianneves.rickandmortyapispringwebflex.response.EpisodeResponse;
import com.gianneves.rickandmortyapispringwebflex.response.ListOfEpisodesResponse;
import com.gianneves.rickandmortyapispringwebflex.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class RickAndMortyClient {

    private final WebClient webClient;


    public RickAndMortyClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();

    }

    public Mono<CharacterResponse> findACharacterById(String id) {
        log.info("Search a character by id [{}]", id);
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findLocationById(String id) {
        log.info("Search location by id [{}]", id);
        return webClient
                .get()
                .uri("/location/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findEpisodeById(String id) {
        log.info("Search episode by id [{}]", id);
        return webClient
                .get()
                .uri("/episode/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(EpisodeResponse.class);
    }

    public Flux<ListOfEpisodesResponse> getAllEpisodes() {
        log.info("Get all episodes");
        return webClient
                .get()
                .uri("/episode/")
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(ListOfEpisodesResponse.class);
    }

}
