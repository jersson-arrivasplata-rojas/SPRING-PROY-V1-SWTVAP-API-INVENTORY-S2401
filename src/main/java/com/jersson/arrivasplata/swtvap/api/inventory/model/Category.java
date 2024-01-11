package com.jersson.arrivasplata.swtvap.api.inventory.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "swtvap_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long categoryId;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @OneToMany(mappedBy = "category")
    private List<CategoryCatalog> categoryCatalogs;
}
//(Modelo de entidad)