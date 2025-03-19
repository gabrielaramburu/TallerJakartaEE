#se agrega imagen base
FROM quay.io/wildfly/wildfly:27.0.0.Final-jdk17
#copio configuracion 
ADD config_docker.cli /opt/jboss/wildfly/bin/config.cli
#copio driver
ADD mariadb-java-client-3.3.3.jar /opt/jboss/wildfly/bin/
#se copia el war de la aplicacion
ADD target/06-JakartaProyectoReferencia.war /opt/jboss/wildfly/standalone/deployments/
CMD ["/opt/jboss/wildfly/bin/jboss-cli.sh --file=/opt/jboss/wildfly/bin/config.cli"]
