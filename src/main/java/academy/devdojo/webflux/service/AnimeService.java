package academy.devdojo.webflux.service;

import academy.devdojo.webflux.domain.Anime;
import academy.devdojo.webflux.repository.AnimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.management.monitor.MonitorNotification;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public Flux<Anime> findAll() {
        return animeRepository.findAll();
    }

    public Mono<Anime> findById(int id){
        return animeRepository.findById(id);
    }

    public Mono<Anime> save(Anime anime) {
        return animeRepository.save(anime);
    }

    public Mono<Void> update(Anime anime) {
        return findById(anime.getId())
                .map(animeFound -> anime.withId(animeFound.getId()))
                .flatMap(animeRepository::save)
                .then();
    }
}
