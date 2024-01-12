package com.jersson.arrivasplata.swtvap.api.inventory.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UnitResponse {
    private Long unitId;
    private String unitName;
    private String abbreviation;
    private BigDecimal conversionFactor;
    private Status status;
}
