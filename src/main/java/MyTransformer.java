import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class MyTransformer extends ResponseDefinitionTransformer {

    @Override
    public ResponseDefinition transform(Request request, ResponseDefinition responseDefinition, FileSource files, Parameters parameters) {
        String s;
        s = request.getUrl().replaceAll("/", "").toLowerCase();
        s = s.substring(0, 1).toUpperCase() + s.substring(1);

        return new ResponseDefinitionBuilder()
                .withStatus(200)
                .withBody(s + ", " + request.getBodyAsString() + "!").build();
    }

    @Override
    public String getName() {
        return "my-transformer";
    }
}