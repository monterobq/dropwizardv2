package server.kata.montero;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;

import org.junit.Test;
import server.kata.montero.config.MessagesConfiguration;
import server.kata.montero.hello.MessageResource;

import java.util.ServiceConfigurationError;

/**
 * Created by montero on 12/12/13.
 */
public class MessagesServiceTest extends junit.framework.TestCase {
    @Test
    public void testMain() throws Exception {
        String server="server";
        boolean result=true;
        try {
            new MessagesService().run(new String[]{server});
        } catch (Exception e) {
            result=false;
        }
        assertTrue(result);

    }
    @Test
    public void testInitialize(Service<MessagesConfiguration> smc) throws Exception {

        Bootstrap<MessagesConfiguration> bootstrap;
        boolean result=true;

        try {
            bootstrap = new Bootstrap<MessagesConfiguration>(smc);
            bootstrap.setName("");
        } catch (Exception e) {
            result=false;
        }
        assertTrue(result);


    }
    @Test
    public void testRun(Environment env) throws Exception {
        MessageResource messageResource=new MessageResource();
        boolean result=true;
        try {
            env.addResource(messageResource);

        } catch (Exception e) {
            result=false;
        }
        assertTrue(result);

    }
}
