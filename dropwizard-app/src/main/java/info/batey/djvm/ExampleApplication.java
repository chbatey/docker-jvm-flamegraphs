package info.batey.djvm;

import io.dropwizard.Application;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.setup.Environment;
import org.apache.http.client.HttpClient;

public class ExampleApplication extends Application<Config> {

    public static void main(String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public void run(Config config, Environment environment) throws Exception {
        environment.jersey().register(new Service());
    }
}
