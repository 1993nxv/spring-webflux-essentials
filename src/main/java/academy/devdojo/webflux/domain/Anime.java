package academy.devdojo.webflux.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("anime")
public class Anime {

    @Id
    @JsonProperty("id")
    private Integer id;

    @NotNull
    @NotEmpty(message = "O nome não pode ficar em branco.")
    @JsonProperty("name")
    private String name;
}
