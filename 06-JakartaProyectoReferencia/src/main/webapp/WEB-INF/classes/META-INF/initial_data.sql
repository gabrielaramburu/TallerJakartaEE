use tallerJava;
insert into peaje_Vehiculo (matricula, tag, marca, modelo, nacionalidad) values ('BAA 1234', 1111, 'Ford', 'Fiesta', 1);
insert into peaje_Vehiculo (matricula, tag, marca, modelo, nacionalidad) values ('AA XSD 4567', 2222, 'Hiunday', 'Tucson', 2);

insert into peaje_tarifa (DTYPE, fechaAplicacion, valor) values ('comun','2024-05-22 12:24:58.524493',180);
insert into peaje_tarifa (DTYPE, fechaAplicacion, valor) values ('preferencial','2024-05-22 12:24:58.524493',100);

insert into gestion_cuenta (fechaApertura, descripcion) values ('2024-05-29 10:34:14.533008', 'Cuenta PrePaga');
insert into gestion_cuentaPrePaga (saldo, id) values (1000, 1);
insert into gestion_clienteTelepeaje (ctaPostPaga_id, ctaPrepaga_id) values (null, 1);
insert into gestion_usuario (clienteTelepeaje_idClienteTelepeaje, email, nacionalidad, nombre) values (1, 'nom1@gmail.com', 1, 'nom1');

insert into gestion_cuenta (fechaApertura, descripcion) values ('2024-05-29 10:34:14.533008', 'Cuenta PrePaga');
insert into gestion_cuentaPrePaga (saldo, id) values (0, 2);
insert into gestion_clienteTelepeaje (ctaPostPaga_id, ctaPrepaga_id) values (null, 2);
insert into gestion_usuario (clienteTelepeaje_idClienteTelepeaje, email, nacionalidad, nombre) values (2, 'nom2@gmail.com', 1, 'nom2');

