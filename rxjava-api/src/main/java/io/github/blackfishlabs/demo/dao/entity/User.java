package io.github.blackfishlabs.demo.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.blackfishlabs.demo.dao.entity.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "user")
public class User extends BaseEntity {

    @JsonProperty("api_key")
    private String apiKey;

}
