package jp.fieldnotes.jjug.pact.provider;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(PactRunner.class)
@Provider("test_provider")
@PactFolder("../pact-jvm-example-consumer/target/pacts")
public class AnimalContractTest {

    private static  ExecutorService executor = Executors.newSingleThreadExecutor();

    @TestTarget
    public final Target target = new HttpTarget(8080);

    @BeforeClass
    public static  void beforeClass() throws IOException, InterruptedException {
        executor.submit(
                () -> SpringApplication.run(PactJvmExampleProviderApplication.class, new String[]{}));
        for (int i=0; i<300; i++){
            try (Socket s = new Socket("localhost", 8080)){
                    return;
            } catch (IOException e) {
            }
            Thread.sleep(100);
        }
        throw new IllegalStateException();
    }

    @State("a serval exists")
    public void stateChange() {}

    @AfterClass
    public static void afterClass(){
        executor.shutdownNow();
    }
}
