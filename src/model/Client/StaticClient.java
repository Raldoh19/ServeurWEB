package model.Client;

import java.io.IOException;

/**
 *  Singleton that create a single client that
 *  connects to the main application
 *  @author Aymane RAMACH
 */

public class StaticClient
{
    /**
     * Object 'Client' that will send the command to
     * the server
     */
    static SendCommand client;

    /**
     * Private constructor that cannot be
     * instancied
     */
    private StaticClient()
    {

    }

    /**
     * Get the client to send command
     * @return Object 'Client' that will allow us to send command
     */
    public static synchronized SendCommand sendRequest() throws IOException {
        if(client == null)
        {
            try {
                client = new SendCommand();
            }catch(IOException e)
            {
                throw e;
            }
            Thread thread = new Thread(client);
            thread.start();
        }
        return client;
    }
}
