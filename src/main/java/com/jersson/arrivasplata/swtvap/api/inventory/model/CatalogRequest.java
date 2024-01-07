package com.jersson.arrivasplata.swtvap.api.inventory.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalogRequest {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Status status;
}
