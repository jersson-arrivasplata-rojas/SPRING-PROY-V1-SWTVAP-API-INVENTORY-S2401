package com.jersson.arrivasplata.swtvap.api.inventory.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class CategoryResponse {
    private Long categoryId;
    private String name;
    private String description;
    private Status status;
    private LocalDate deletedAt;
}
//(Modelo de respuesta)
