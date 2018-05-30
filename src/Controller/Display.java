package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client.SendCommand;
import model.Client.StaticClient;
import model.Information;

/**
 * Servlet implementation class ResultEnd
 */
public class Display extends HttpServlet
{
    /**
     * Default constructor.
     */
    public Display()
    {

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            SendCommand client = StaticClient.sendRequest();
            List<Information> informations = client.getInformations();
            request.setAttribute("informations", informations);
            this.getServletContext().getRequestDispatcher("/chooseRoute.jsp").forward(request, response);
        }
        catch (InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            XMLParser xmlParser = new XMLParser();
            String param = "Current parameter: " + xmlParser.getIpaddress()+":"+xmlParser.getPort() + "\nError: " + xmlParser.getErrorParsing();
            request.setAttribute("errorMsg", param);
            this.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
