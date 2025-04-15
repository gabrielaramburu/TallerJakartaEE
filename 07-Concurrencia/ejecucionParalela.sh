##https://www.baeldung.com/linux/curl-repeat-url-request
## Apache Benchmark (ab) is a specialized tool for performance testing and load generation
ab -T application/json -p infoBody.txt -n 100 -c 10 http://localhost:8080/07_Concurrencia/api/cuentas/100/movimientos
