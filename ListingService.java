import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ListingService {
    private Long id;
    private String address;
    private String city;
    private String state;
    private int zipcode;

    HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://zillow69.p.rapidapi.com/agent/soldListings?zuid=%3CREQUIRED%3E"))
		.header("X-RapidAPI-Key", "#")
		.header("X-RapidAPI-Host", "#")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
}
