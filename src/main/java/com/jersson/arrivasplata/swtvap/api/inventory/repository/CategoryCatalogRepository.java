package com.jersson.arrivasplata.swtvap.api.inventory.repository;


import com.jersson.arrivasplata.swtvap.api.inventory.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Category;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CategoryCatalog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CategoryCatalogRepository extends JpaRepository<CategoryCatalog, Long> {

    List<CategoryCatalog> findAll(); // Obtiene todos los registros

    void deleteById(Long id); // Elimina por ID

    List<CategoryCatalog> findByCategoryName(String categoryName); // Busca por nombre de categoría

    @Transactional
    void deleteByCatalogCatalogId(Long catalogId); // Elimina todas las categorías con un catalog id específico

    @Transactional
    void deleteByCategoryCategoryId(Long categoryId); // Elimina todas los catalogos con un category id específico
}
