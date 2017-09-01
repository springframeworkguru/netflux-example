package guru.springframework.netfluxexample.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jt on 9/1/17.
 */
@Document
@Data
@NoArgsConstructor
public class Movie {

    private String id;

    @NonNull
    private String title;

}
