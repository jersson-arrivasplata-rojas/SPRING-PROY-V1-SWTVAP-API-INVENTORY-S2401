package com.jersson.arrivasplata.swtvap.api.inventory.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    private Long categoryId;
    private String name;
    private String description;
    private Status status;
}
//(Modelo de solicitud)