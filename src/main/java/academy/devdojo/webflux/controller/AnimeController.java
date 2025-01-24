package academy.devdojo.webflux.controller;

import academy.devdojo.webflux.domain.Anime;
import academy.devdojo.webflux.service.AnimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping
    public Flux<Anime> listAll(){
        return animeService.findAll();
    }

    @GetMapping("{id}")
    public Mono<Anime> findById(@PathVariable int id){
        return animeService.findById(id);
    }

}
