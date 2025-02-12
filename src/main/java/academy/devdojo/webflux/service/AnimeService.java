package academy.devdojo.webflux.service;

import academy.devdojo.webflux.domain.Anime;
import academy.devdojo.webflux.repository.AnimeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Flux<Anime> findAll() {
        return animeRepository.findAll();
    }

    public Mono<Anime> findById(Integer id){
        return animeRepository.findById(id);
    }

    public Mono<Anime> save(Anime anime) {
        return animeRepository.save(anime);
    }

    public Mono<Void> update(Integer id, Anime anime) {
        return findById(id)
                .map(animeFound -> (Anime) anime.withId(animeFound.getId()))
                .flatMap(animeRepository::save)
                .then();
    }

    public Mono<Void> delete(Integer id) {
        return findById(id)
                .flatMap(animeRepository::delete);
    }
}
