package Quotely;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ForismaticAPIEndpoint {

    public static ForismaticQuote call(String languageCode){

        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .uri(URI.create("http://api.forismatic.com/api/1.0/get?method=getQuote&format=json&lang="+languageCode))
                .GET()
                .build();

        HttpResponse<String> response = null;
        ForismaticQuote quote = null;
        try (HttpClient client = HttpClient.newHttpClient()) {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            quote = mapper.readValue(response.body(), ForismaticQuote.class);
        } catch (JsonProcessingException e){
            System.out.println("There was an issue parsing the JSON");
            e.printStackTrace();
            System.out.println(response.body());
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            e.printStackTrace();
        }

        return quote;
    }
}
