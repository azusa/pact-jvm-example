package jp.fieldnotes.jjug.pact.provider.pact.consumer;

import com.google.gson.Gson;
import jp.fieldnotes.jjug.pact.provider.pact.consumer.model.Animals;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.charset.Charset;

public class AnimalServiceClient {

    public Animals getAnimalInformation(String baseUrl, String name)
            throws IOException {

        String response =  Request.Get(baseUrl + "/animals/" + name).execute().returnContent().asString(Charset.forName("UTF-8"));
        Gson gson = new Gson();
        return gson.fromJson(response, Animals.class);
    }
}
