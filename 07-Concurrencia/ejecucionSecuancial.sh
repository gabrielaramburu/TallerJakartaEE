echo "Inicio ejecucion"
for i in {1..10};do curl -X POST http://localhost:8080/07_Concurrencia/api/cuentas/100/movimientos -H "Content-Type: application/json" -d '{"importe":100,"tipoMovimiento":"DEPOSITO", "concepto":"prueba concurrencia"}' ; done
echo "Fin ejecucion"

echo "Saldo final "
curl -X GET http://localhost:8080/07_Concurrencia/api/cuentas/100/movimientos/saldo
echo ""
