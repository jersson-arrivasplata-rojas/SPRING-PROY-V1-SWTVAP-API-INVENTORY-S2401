package com.jersson.arrivasplata.swtvap.api.inventory.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CategoryResponse {
    private Long categoryId;
    private String name;
    private String description;
    private Status status;
}
//(Modelo de respuesta)
