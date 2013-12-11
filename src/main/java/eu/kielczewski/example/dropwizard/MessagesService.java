package eu.kielczewski.example.dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import eu.kielczewski.example.dropwizard.config.MessagesConfiguration;
import eu.kielczewski.example.dropwizard.hello.MessageResource;

public class MessagesService extends Service<MessagesConfiguration> {

public static void main(String[] args) throws Exception {
        new MessagesService().run(new String[] { "server" });
        }

@Override
public void initialize(Bootstrap<MessagesConfiguration> bootstrap) {
        bootstrap.setName("");
        }

@Override
public void run(MessagesConfiguration conf, Environment env) throws Exception {
        env.addResource(new MessageResource());
        }
}
