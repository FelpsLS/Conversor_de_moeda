import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class Conversor {
    public Moeda convertMoeda(String moeda){
        URI end = URI.create("https://v6.exchangerate-api.com/v6/b14b85b7c86d884e0bff9e0b/latest/" + moeda);
        HttpRequest request = HttpRequest.newBuilder()
            .uri(end)
            .build();
        try{
            HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
            // System.out.println("Resposta da API:" + response.body());
            return new Gson().fromJson(response.body(), Moeda.class);
        }catch(Exception e){
            throw new RuntimeException("Nao consegui o endereco a partir dessa moeda");
        }
    }
}
