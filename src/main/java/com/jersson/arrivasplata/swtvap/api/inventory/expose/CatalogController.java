package com.jersson.arrivasplata.swtvap.api.inventory.expose;

import com.jersson.arrivasplata.swtvap.api.inventory.model.CatalogRequest;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CatalogResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CatalogController {
    Flux<ResponseEntity<CatalogResponse>> getAllCatalogs();
    Mono<ResponseEntity<CatalogResponse>> createCatalog(CatalogRequest catalogRequest);
    Mono<ResponseEntity<CatalogResponse>> updateCatalog(Long id, CatalogRequest catalogRequest);
    Mono<ResponseEntity<Void>> deleteCatalog(Long id);
    Mono<ResponseEntity<String>> performUsefulOperationWithResponse();
    // Otros métodos relacionados con catalogo usando Reactor Core
}
