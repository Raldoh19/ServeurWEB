package Test;

import model.Client.SendCommand;
import model.Client.StaticClient;

import java.io.IOException;

public class Client
{
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        SendCommand client = StaticClient.sendRequest();
        client.getInformations();
    }
}
