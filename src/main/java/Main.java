import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class Main {
    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(options().extensions(
                new MyUriFilter(), new MyTransformer()).port(8080));

        wireMockServer.start();
    }
}
