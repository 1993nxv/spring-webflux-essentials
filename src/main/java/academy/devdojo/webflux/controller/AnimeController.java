package academy.devdojo.webflux.controller;

import academy.devdojo.webflux.domain.Anime;
import academy.devdojo.webflux.repository.AnimeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
@RequestMapping("/")
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping
    public Flux<Anime> listAll(){
        return animeRepository.findAll();
    }

}
