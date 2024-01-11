
INSERT INTO "public"."swtvap_categories" (id, name, status) VALUES (1,'Madera Colombina', 1);
INSERT INTO "public"."swtvap_categories" (id, name, status) VALUES (2,'Madera Pre-Colombina', 1);
INSERT INTO "public"."swtvap_categories" (id, name, status) VALUES (3,'Madera Post-Colombina', 1);


INSERT INTO "public"."swtvap_catalogs" (id, code, name, status) VALUES (1,'CAT-A00001', 'Madera Colombina', 1);
INSERT INTO "public"."swtvap_catalogs" (id, code, name, status) VALUES (2,'CAT-A00002', 'Madera Pre-Colombina', 1);
INSERT INTO "public"."swtvap_catalogs" (id, code, name, status) VALUES (3,'CAT-A00003', 'Madera Post-Colombina', 1);


INSERT INTO "public"."swtvap_categories_catalogs" (id, catalog_id, category_id) VALUES (1, 1, 1);
INSERT INTO "public"."swtvap_categories_catalogs" (id, catalog_id, category_id) VALUES (2, 2, 2);
INSERT INTO "public"."swtvap_categories_catalogs" (id, catalog_id, category_id) VALUES (3, 3, 3);