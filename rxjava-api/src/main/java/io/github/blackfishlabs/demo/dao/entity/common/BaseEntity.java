package io.github.blackfishlabs.demo.dao.entity.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Setter
@Getter
public abstract class BaseEntity implements Serializable {

    @Id
    private String id;
    private Boolean delete = Boolean.FALSE;

}