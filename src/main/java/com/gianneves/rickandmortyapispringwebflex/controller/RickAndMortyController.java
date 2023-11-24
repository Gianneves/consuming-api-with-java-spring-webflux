package com.gianneves.rickandmortyapispringwebflex.controller;

import com.gianneves.rickandmortyapispringwebflex.client.RickAndMortyClient;
import com.gianneves.rickandmortyapispringwebflex.response.CharacterResponse;
import com.gianneves.rickandmortyapispringwebflex.response.EpisodeResponse;
import com.gianneves.rickandmortyapispringwebflex.response.ListOfEpisodesResponse;
import com.gianneves.rickandmortyapispringwebflex.response.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
@AllArgsConstructor
public class RickAndMortyController {

    RickAndMortyClient rickAndMortyClient;

    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyClient.findACharacterById(id);
    }

    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id) {
        return rickAndMortyClient.findLocationById(id);
    }

    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id) {
        return rickAndMortyClient.findEpisodeById(id);
    }

    @GetMapping("/episode")
    public Flux<ListOfEpisodesResponse> getAllEpisode() {
        return rickAndMortyClient.getAllEpisodes();
    }


}
