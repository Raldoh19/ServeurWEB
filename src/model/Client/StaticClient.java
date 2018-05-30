package model.Client;

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
    public static synchronized SendCommand sendRequest()
    {
        if(client == null)
        {
            client = new SendCommand();
            Thread thread = new Thread(client);
            thread.start();
        }
        return client;
    }
}
