package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client.SendCommand;
import model.Client.StaticClient;
import model.Information;
import model.Node;

/**
 * Servlet implementation class ResultEnd
 */
public class ResultEnd extends HttpServlet
{
    /**
     * Default constructor. 
     */
    public ResultEnd()
	{
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Information infoSource = null, infoDest = null;
			String infoSourceString = request.getParameter("pointDepart");
			String infoDestString = request.getParameter("pointArrive");

			SendCommand client = StaticClient.sendRequest();
			List<Information> informations = client.getInformations();

			for (Information information : informations)
			{
				if (information.getName().equals(infoSourceString))
					infoSource = information;
				if (information.getName().equals(infoDestString))
					infoDest = information;
				if (infoDest != null && infoSource != null)
					break;
			}
			List<Node> listNoeud= client.getRoute(infoSource, infoDest);
			HttpSession session = request.getSession() ;
			session.setAttribute("listNoeud", listNoeud) ;
			request.setAttribute("index", 0);
			this.getServletContext().getRequestDispatcher("/printRoute.jsp").forward(request, response);
		}
		catch (InterruptedException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
