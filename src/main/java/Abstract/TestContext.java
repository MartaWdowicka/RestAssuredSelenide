package Abstract;

import org.json.JSONObject;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class TestContext {
	private String endpoint;
	private String JSONBody;
	private Response response;
	private JSONObject testData;
}