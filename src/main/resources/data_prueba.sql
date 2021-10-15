INSERT INTO public.categoria (ccategoria, nombre) VALUES(1, 'Normal');
INSERT INTO public.categoria (ccategoria, nombre) VALUES(2, 'VIP');


INSERT INTO public.departamento (cdepartamento, nombre, ccategoria) VALUES(1, 'Departamento Planta baja', 1);
INSERT INTO public.departamento (cdepartamento, nombre, ccategoria) VALUES(2, 'Departamento Lujo', 2);


INSERT INTO public.empleado (cempelado, apellido, edad, nombre, cdepartamento) VALUES(1, 'juan', 14, 'pablo', 1);
