package ConsumoApI;

import Modelos.Records.Conversor;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConversor {
    public Conversor consultaConversion (String monedaBase, String monedaTarget, double cantidad){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/9f052f7ee4d7864a3051c7b9/pair/"
                        +monedaBase+"/"+monedaTarget+"/"+cantidad))
                .build();
        HttpResponse<String> response;
        try{
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), Conversor.class);
    }
}
