package com.jersson.arrivasplata.swtvap.api.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "swtvap_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long categoryId;

    @Column(length = 200)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "name_en", length = 200)
    private String name_en;

    @Column(name = "description_en", columnDefinition = "text")
    private String description_en;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<CategoryCatalog> categoryCatalogs;
}
//(Modelo de entidad)