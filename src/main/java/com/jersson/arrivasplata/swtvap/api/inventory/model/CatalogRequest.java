package com.jersson.arrivasplata.swtvap.api.inventory.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Lang;
import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CatalogRequest {
    private Long catalogId;
    private String code;
    private String name;
    private String description;
    private Status status;
    private Lang lang;
    private LocalDate deletedAt;
}
