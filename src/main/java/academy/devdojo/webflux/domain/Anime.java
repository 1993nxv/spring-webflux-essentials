package academy.devdojo.webflux.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Builder
@With
@Table("anime")
public class Anime {

    @Id
    @JsonProperty("id")
    private final Integer id;

    @NotNull
    @NotEmpty(message = "O nome não pode ficar em branco.")
    @JsonProperty("name")
    private final String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
