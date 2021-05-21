import com.github.tomakehurst.wiremock.extension.requestfilter.RequestFilterAction;
import com.github.tomakehurst.wiremock.extension.requestfilter.StubRequestFilter;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class MyUriFilter extends StubRequestFilter {

    @Override
    public RequestFilterAction filter(Request request) {
        if (request.getUrl().toString().toLowerCase().equals("/hello") ||
                request.getUrl().toString().toLowerCase().equals("/goodbye")) {
            return RequestFilterAction.continueWith(request);
        }

        return RequestFilterAction.stopWith(ResponseDefinition.notPermitted("Not valid uri"));
    }

    @Override
    public String getName() {
        return "uri-filter";
    }
}