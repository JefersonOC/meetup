package io.github.blackfishlabs.demo.dao.entity;

import io.github.blackfishlabs.demo.dao.entity.common.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "note")
public class Note extends BaseEntity {

    private String note;
    private String timestamp;
}
