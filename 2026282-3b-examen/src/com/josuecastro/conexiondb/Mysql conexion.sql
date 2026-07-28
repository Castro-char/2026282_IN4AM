drop database examn_3B_IN4AM;
create database exam_3B_IN4AM;	
use exam_3B_IN4Am;

create table Usuario(
id_usuario  int not null primary key unique ,
nombre_completo varchar (70) not null unique,
user_name varchar (70) not null unique,
email varchar (70) not null,
clave varchar (70) not null,
rol varchar (25) not null default 'USER'
);

delimiter $$
	create procedure sp_crear_usuario(in id_usurio_p int,
										in nombre_completo_p varchar(70),
				
						in user_name_p varchar (70),
										in email_p varchar(70),
										in clave_p varchar(70),
										in rol_p varchar(70))
	begin
		insert into Usuario(id_usurio, nombre_completo, user_name_, email, clave, rol)
			values(id_usurio_p, nombre_completo_p, user_name_p, email_p, clave_p, rol_p);
    end$$
delimiter ;


-- ======================== Leer ==========================
delimiter $$
create procedure sp_leer_Usuario()

begin
	select * from Usuario;
end$$

delimiter ;


-- ========================= Validar login =======================
delimiter $$
	create procedure sp_login_Usuario(in user_name_p varchar(70), in clave_p varchar(70))
    
    begin
		select * from Usuario
        where user_name = user_name_p and clave_p;
    end$$

delimiter ;


