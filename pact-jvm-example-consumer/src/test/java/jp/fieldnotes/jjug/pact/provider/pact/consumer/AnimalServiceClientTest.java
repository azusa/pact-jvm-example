package jp.fieldnotes.jjug.pact.provider.pact.consumer;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import jp.fieldnotes.jjug.pact.provider.pact.consumer.model.Animals;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnimalServiceClientTest {

    Map<String, String> headers = Collections.singletonMap("Content-Type", "application/json");

    @Rule
    public PactProviderRule provider = new PactProviderRule("test_provider", "localhost", 1234, this);

    @Pact(provider="test_provider", consumer="test_consumer")
    public PactFragment configurationFragment(PactDslWithProvider builder) {
        return builder
            .given("a serval exists")
            .uponReceiving("a request for an serval")
            .path("/animals/serval")
            .method("GET")
            .willRespondWith()
            .headers(headers)
            .status(200)
            .body(
                    "{\n" +
                            "\"animals\": [\n" +
                            "    {\n" +
                            "                    \"id\": 1,\n" +
                            "                    \"name\": \"サーバルちゃん\"\n" +
                            "    }\n" +
                            "]\n" +
                            "}"
            )
            .toFragment();
    }

    @PactVerification("test_provider")
    @Test
    public void get_serval() throws IOException {
        AnimalServiceClient providerRestClient = new AnimalServiceClient();
        Animals response = providerRestClient.getAnimalInformation("http://localhost:1234", "serval");
        assertThat(response.getAnimals().get(0).getName(), is("サーバルちゃん"));
    }
}
