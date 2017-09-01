package guru.springframework.netfluxexample.repositories;

import guru.springframework.netfluxexample.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by jt on 9/1/17.
 */
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
