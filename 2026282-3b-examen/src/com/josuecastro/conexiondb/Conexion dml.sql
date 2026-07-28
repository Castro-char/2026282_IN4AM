use exam_3B_IN4AM;

call sp_crear_usuario(1001, "Jose Carlos Garcia Granados", "Jgarcia", "Jgarcia@.com","garciagrn", "Jefe");
call sp_crear_usuario(1002, "Armando Daniel Martinez Gonzales", "Adaniel", "Adaniel@.com","armandan", "Gerente de financias");

select * from Usuario;