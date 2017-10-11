package guru.springframework.netfluxexample.bootstrap;

import guru.springframework.netfluxexample.domain.Movie;
import guru.springframework.netfluxexample.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

/**
 * Created by jt on 9/1/17.
 */
@Component
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //clear old data
        movieRepository.deleteAll()
                .thenMany(
                Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
                        "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                        .map(title -> new Movie(title))
                        .flatMap(movieRepository::save))
                        .subscribe(null, null, () -> {
                            movieRepository.findAll().subscribe(System.out::println);
                        });
    }
}
