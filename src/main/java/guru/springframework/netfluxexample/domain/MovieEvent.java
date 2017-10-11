package guru.springframework.netfluxexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by jt on 9/1/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEvent {

    private String movieId;
    private Date date;
}
