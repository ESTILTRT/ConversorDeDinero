package Main;

import ConsumoApI.APIConversor;
import Modelos.Historial;
import Modelos.Records.Conversor;
import com.sun.source.tree.WhileLoopTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        APIConversor conversor = new APIConversor();
        Scanner write = new Scanner(System.in);
        Historial historial = new Historial();

        HashMap diccionariosmonedas = new HashMap();
        diccionariosmonedas.put("Colones", "CRC");
        diccionariosmonedas.put("Dolares", "USD");
        diccionariosmonedas.put("Euros", "EUR");
        diccionariosmonedas.put("Pesos Mexicanos", "MXN");
        List<Conversor> listaDeHistorial = new ArrayList<>();
        var monedaskeys = diccionariosmonedas.keySet();
        var monedasValores = diccionariosmonedas.values();
        String nombreMoneda1 = "";
        String nombreMoneda2 = "";

        System.out.println("Bienvenido a la casa de los cambios, aquí podrás realizar la conversión de tu moneda.");

        String menssaje = """
                **********************************************
                    Que deseas Realizar?
                        1- Colones => Dolares
                        2- Dolares => colones
                        3- Colones => Euros
                        4- Euros => Colones
                        5- Colones => Pesos Mexicanos
                        6- Pesos Mexicanos => Colones
                        9-Salir
                    Favor colocar el número de la opción a elegir...  
                **********************************************  
                """;
            int opcion = 0;



        while (opcion != 9){
            try {
                System.out.println(menssaje);
                opcion = write.nextInt();
                String moneda1 = "";
                String moneda2 = "";

                switch (opcion) {

                    default:
                        System.out.println("Opción invalida");
                    case 1:
                        moneda1 = "Colones";
                        moneda2 = "Dolares";
                        break;
                    case 2:
                        moneda1 = "Dolares";
                        moneda2 = "Colones";
                        break;
                    case 3:
                        moneda1 = "Colones";
                        moneda2 = "Euros";
                        break;
                    case 4:
                        moneda1 = "Euros";
                        moneda2 = "Colones";
                        break;
                    case 5:
                        moneda1 = "Colnes";
                        moneda2 = "Pesos Mexicanos";
                        break;
                    case 6:
                        moneda1 = "Pesos Mexicanos";
                        moneda2 = "Colones";
                        break;
                    case 9:
                        System.out.println("Saliendo...");
                }

                if (moneda1.equals("") && moneda2.equals(""))
                    continue;

                System.out.println("¿Cuál es la cantidad por la cual deseas hacer la conversión?");
                double cantidad = write.nextDouble();
                System.out.println("Esdperando");
                for (var codigos: monedasValores) {
                    for (var monedas: monedaskeys){
                        if (moneda1.equals(monedas) && codigos.equals(diccionariosmonedas.get(moneda1))) {
                            nombreMoneda1 = monedas.toString();
                            moneda1 = codigos.toString();
                            break;
                        } else if (moneda2.equals(monedas) && codigos.equals(diccionariosmonedas.get(moneda2))){
                            nombreMoneda2 = monedas.toString();
                            moneda2 = codigos.toString();
                            break;
                        }
                    }
                }
                Conversor resultado = conversor.consultaConversion(moneda1,moneda2,cantidad);
                System.out.println("La convercion de "+cantidad+" "+nombreMoneda1+" a "
                        +nombreMoneda2+" es de: "+resultado.conversion_result());
                listaDeHistorial.add(resultado);
            }catch (RuntimeException e){
                System.out.println("Finalizando programa por error");
                System.out.println(e);
            }
        }

        try {
            historial.GenerarHistorias(listaDeHistorial);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
