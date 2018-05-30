package model.Client;

import Controller.XMLParser;
import model.Information;
import model.Node;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 *  Object that send commands to the main application
 *  and get results
 *  @author Aymane RAMACH
 */

public class SendCommand implements Runnable
{
    /**
     * Socket with the main application
     */
    private Socket socket;
    /**
     * Buffer to send data
     */
    private PrintWriter out = null;
    /**
     * Buffer to read data
     */
    private BufferedReader in = null;

    /**
     * Create an object that connect to the socket
     * and initialize all the buffers
     */
    public SendCommand() throws IOException {
        try
        {
            XMLParser xmlParser = new XMLParser();
            socket = new Socket(xmlParser.getIpaddress(), xmlParser.getPort());
            out = new PrintWriter(socket.getOutputStream());
            System.out.println(out);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e)
        {
            throw e;
        }
    }

    /**
     * Method that send a request 'GET INFORMATIONS' to the SERVER
     * and get a list with all the information
     * @return An Object List that contains a lot of Informations on the nodes
     * @throws InterruptedException Return an exception if the connection is refused
     * @throws IOException Return an exception if an error occured
     * @throws ClassNotFoundException Return an error when used class doesn't match with the server's class
     */
    public List<Information> getInformations() throws InterruptedException, IOException, ClassNotFoundException
    {
        out.println("GET INFORMATIONS");
        out.flush();
        Thread.sleep(100);
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        System.out.println("Reponse reçu");
        return (List<Information>)is.readObject();
    }

    /**
     * Methode that ask the main application for the shortest path
     * between two nodes
     * @param nodeStart The starting node
     * @param nodeEnd The ending node
     * @return A List of Node that represents the shortest path
     * @throws InterruptedException Return an exception if the connection is refused
     * @throws IOException Return an exception if an error occured
     * @throws ClassNotFoundException Return an error when used class doesn't match with the server's class
     */
    public List<Node> getRoute(Information nodeStart, Information nodeEnd) throws IOException, InterruptedException, ClassNotFoundException {
        out.println("GET ROUTE");
        out.flush();
        System.err.println("Sending route request message..");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(nodeStart);
        oos.flush();
        ObjectOutputStream oos2 = new ObjectOutputStream(socket.getOutputStream());
        oos2.writeObject(nodeEnd);
        oos2.flush();
        System.err.println("ROUTE REQUEST SENT BETWEEN " + nodeStart.getName() + " AND " + nodeEnd.getName());
        Thread.sleep(100);
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        return (List<Node>)is.readObject();
    }

    /**
     * Method that allow the client to run
     */
    public void run()
    {
        while(true)
        {
            break;
        }
    }
}
