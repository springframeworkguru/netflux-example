package guru.springframework.netfluxexample.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jt on 9/1/17.
 */
@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {

    private String id;

    @NonNull
    private String title;

}
