# Jakarta Authentication

## Probar API sin seguridad

Levantar servidor con mvn clean package wildfly:dev

Probar API que no implementa seguridad (sacar curl desde comentario de código). 
Observar en el servidor que la operación se ejecuta sin problemas


## Probar API con seguridad

Primero probar sin pasar nombre de usuario (usar curls)
Observar que la petición es rechazada por el servidor (error 401 no autorizado)

Después probar enviando credenciales en la petición (hay curl de ejemplo)
		¿funciona? ¿por qué?

Agregar usuario y el rol al que pertenece en el servidor. (seguir nota de abajo)		

Probar nuevamente.

	
##Notas:

### Configurar permisos en servidor

Crear usuario en el servidor, setearle constraseña y asignarle el rol
   
   Usar aplicación /add-usr.sh (ver archivo anexado EjemploCreacionUsuario.txt)
	
   Verificar si todo quedo bien en los archivos &nbsp;
   			application-roles.properties 
   			application-users.properties 
   			localizados en 03a_JakartaEE-Authorization/target/server/standalone/configuration

### Crear usuario para acceder a consola gráfica

Crear usuario administrador para entrar a la consola de wildfly
	/target/server/bin/add-usr.sh (seguir las indicaciones)

Tener en cuenta que hay varias maneras de hacer esto.
		[más info](https://www.mastertheboss.com/jbossas/jboss-configuration/how-to-access-wildfly-admin-console/)