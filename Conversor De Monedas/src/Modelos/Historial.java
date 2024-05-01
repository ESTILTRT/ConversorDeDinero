package Modelos;

import Modelos.Records.Conversor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Historial {
    public void GenerarHistorias(List<Conversor> conversiones) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter archivo = new FileWriter("Historial.json");
        archivo.write(gson.toJson(conversiones));
        archivo.close();
    }
}
