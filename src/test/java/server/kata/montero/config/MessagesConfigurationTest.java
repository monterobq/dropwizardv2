package server.kata.montero.config;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by montero on 12/12/13.
 */
public class MessagesConfigurationTest extends TestCase {

    @Test
    public void testCreateClass() throws Exception {
        boolean result=true;

        try {
            MessagesConfiguration messagesConfiguration=new MessagesConfiguration();
        } catch (Exception e) {
            result=false;
        }

              assertTrue(result);
    } 
}
