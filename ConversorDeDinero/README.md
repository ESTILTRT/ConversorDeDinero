# ConversorDeDinero
Trabajare Bajo el consumo de una API para hacer las Operaciones necesarias para hacer un Conversor de monedas

![Programa Funcionando](https://github.com/ESTILTRT/ConversorDeDinero/assets/157448750/7605b4be-a59f-4a93-ae3b-796d923e2f44)


<h2>Api</h2>
La API que se está utilizando es Exchangerare API (https://www.exchangerate-api.com)

Esta se consulta por medio de Gson, generando consultas por medio obteniendo un GET.

![API en consumo](https://github.com/ESTILTRT/ConversorDeDinero/assets/157448750/795d15c5-e88e-49c7-8c9c-49d076cf9f43)
Aquí estoy generando la conversión directamente con una de las extensiones que tenía la API que se hace de forma automatica.
nada más se necesita mandar los códigos de las monedas base y a la que se desea cambiar más el monto.
Nos apoyamos en Gson para hacer la recolección de los datos por medio de un récord, el cual es Conversor.

<h3>Generar Historial</h3>
![Historial](https://github.com/ESTILTRT/ConversorDeDinero/assets/157448750/9a94050f-697d-41c9-a9cc-dbb293141108)
Gracias a los datos dados por el usuario por medio del main, se genera un pequeño historial el cual obtiene los datos por medio de un List de tipo Conversor, así colocando el monto y los dos códigos de monedas mandados.
Este sería un ejemplo del Json.
![Json del historial](https://github.com/ESTILTRT/ConversorDeDinero/assets/157448750/6412df2c-b486-4f58-b1b6-848c4faa4a64)

