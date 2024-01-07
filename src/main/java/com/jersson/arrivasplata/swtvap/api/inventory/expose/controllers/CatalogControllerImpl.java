package com.jersson.arrivasplata.swtvap.api.inventory.expose.controllers;


import com.jersson.arrivasplata.swtvap.api.inventory.business.service.CatalogService;
import com.jersson.arrivasplata.swtvap.api.inventory.expose.CatalogController;
import com.jersson.arrivasplata.swtvap.api.inventory.mapper.CatalogMapper;
import com.jersson.arrivasplata.swtvap.api.inventory.model.*;
import com.jersson.arrivasplata.swtvap.api.inventory.util.UtilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/api/catalogs", produces = "application/vnd.swtvap-api-inventory.v1+json")
public class CatalogControllerImpl implements CatalogController {
    private final CatalogService catalogService;
    private final UtilityService utilityService;
    private final CatalogMapper catalogMapper;


    public CatalogControllerImpl(CatalogService catalogService, CatalogMapper catalogMapper, UtilityService utilityService) {
        this.catalogService = catalogService;
        this.catalogMapper = catalogMapper;
        this.utilityService = utilityService;
    }

    @GetMapping
    public Flux<ResponseEntity<CatalogResponse>> getAllCatalogs() {
        return catalogService.getAllCatalogs()
                .map(catalog -> {
                    CatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(catalog);
                    return ResponseEntity.ok(catalogResponse);
                });
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CatalogResponse>> getCatalogById(@PathVariable Long id) {
        return catalogService.getCatalogById(id)
                .map(catalog -> {
                    CatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(catalog);
                    return ResponseEntity.ok(catalogResponse);

                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<CatalogResponse>> createCatalog(@RequestBody CatalogRequest catalogRequest) {
        Catalog catalog = catalogMapper.catalogRequestToCatalog(catalogRequest);

        return catalogService.createCatalog(catalog)
                .map(newCatalog -> {
                    CatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(newCatalog);
                    return ResponseEntity.status(HttpStatus.CREATED).body(catalogResponse);
                });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CatalogResponse>> updateCatalog(@PathVariable Long id, @RequestBody CatalogRequest catalogRequest) {
        Catalog catalog = catalogMapper.catalogRequestToCatalog(catalogRequest);
        catalog.setId(id);
        return catalogService.updateCatalog(catalog)
                .map(updatedCatalog -> {
                    CatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(updatedCatalog);
                    return ResponseEntity.ok(catalogResponse);
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCatalog(@PathVariable Long id) {
        return catalogService.deleteCatalogById(id)
                .map(r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/doSomething")
    public Mono<ResponseEntity<String>> performUsefulOperationWithResponse() {
        utilityService.doSomething();
        return Mono.just(ResponseEntity.ok("Operación útil realizada de manera reactiva"));
    }

    // Implementa otros métodos del controlador si es necesario
}