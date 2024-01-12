
INSERT INTO "public"."swtvap_categories" (id, name, status) VALUES (1,'Madera Colombina', 1);
INSERT INTO "public"."swtvap_categories" (id, name, status) VALUES (2,'Madera Pre-Colombina', 1);
INSERT INTO "public"."swtvap_categories" (id, name, status) VALUES (3,'Madera Post-Colombina', 1);


INSERT INTO "public"."swtvap_catalogs" (id, code, name, status) VALUES (1,'CAT-A00001', 'Madera Colombina', 1);
INSERT INTO "public"."swtvap_catalogs" (id, code, name, status) VALUES (2,'CAT-A00002', 'Madera Pre-Colombina', 1);
INSERT INTO "public"."swtvap_catalogs" (id, code, name, status) VALUES (3,'CAT-A00003', 'Madera Post-Colombina', 1);


INSERT INTO "public"."swtvap_categories_catalogs" (id, catalog_id, category_id) VALUES (1, 1, 1);
INSERT INTO "public"."swtvap_categories_catalogs" (id, catalog_id, category_id) VALUES (2, 2, 2);
INSERT INTO "public"."swtvap_categories_catalogs" (id, catalog_id, category_id) VALUES (3, 3, 3);


INSERT INTO "public"."swtvap_units" (id, unit_name, abbreviation, convertion_factor, status) VALUES (1, 'Pieza', 'pz', null, 1);
INSERT INTO "public"."swtvap_units" (id, unit_name, abbreviation, convertion_factor, status) VALUES (2, 'Kilogramo', 'kg', 1000, 1);
INSERT INTO "public"."swtvap_units" (id, unit_name, abbreviation, convertion_factor, status) VALUES (3,'Gramo', 'g', 1, 1);
INSERT INTO "public"."swtvap_units" (id, unit_name, abbreviation, convertion_factor, status) VALUES (4, 'Litro', 'L', null, 1);
INSERT INTO "public"."swtvap_units" (id, unit_name, abbreviation, convertion_factor, status) VALUES (5,'Mililitro', 'mL', 0.001, 1);
INSERT INTO "public"."swtvap_units" (id, unit_name, abbreviation, convertion_factor, status) VALUES (6, 'Metro', 'm', 1, 1);
INSERT INTO "public"."swtvap_units" (id, unit_name, abbreviation, convertion_factor, status) VALUES (7, 'Centímetro', 'cm', 0.01, 1);
INSERT INTO "public"."swtvap_units" (id, unit_name, abbreviation, convertion_factor, status) VALUES (8, 'Caja', 'caja', null, 1);
INSERT INTO "public"."swtvap_units" (id, unit_name, abbreviation, convertion_factor, status) VALUES (9, 'Paquete', 'pkt', null, 1);
