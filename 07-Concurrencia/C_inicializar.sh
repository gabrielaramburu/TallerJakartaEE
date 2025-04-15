curl -X POST http://localhost:8080/07_Concurrencia/api/cuentasC/100/inicializar
echo "nuevo saldo:"
curl -X GET http://localhost:8080/07_Concurrencia/api/cuentasC/100/movimientos/saldo
echo "Fin inicializacion"
