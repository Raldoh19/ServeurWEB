package Controller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class that will allow us to parse an xml file
 * to get information on the main application
 */
public class XMLParser
{
    /**
     * Default path to the configuration file
     */
    private final String path = "/tmp/server.cfg";
    /**
     * Default port used in case of no cfg file
     */
    private int port = 2009;
    /**
     * Default address used in case of no cfg file
     */
    private String ipaddress = "126546";

    /**
     * String that contains the error
     */
    private String ErrorParsing;

    /**
     * Constructor that will read the configuration file
     * and get the ipadress and the port of the main application
     */

    public XMLParser()
    {
        try
        {
            File fXmlFile = new File(path);
            if(!fXmlFile.isFile())
            {
                PrintWriter writer = new PrintWriter(path, "UTF-8");
                writer.println("<server>");
                writer.println("<ipaddress>"+ipaddress+"</ipaddress>");
                writer.println("<port>"+port+"</port>");
                writer.println("</server>");
                writer.close();
            }
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("server");
            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;
                    System.out.println("IP: '" + eElement.getElementsByTagName("ipaddress").item(0).getTextContent()+"'");
                    System.out.println("Port: '" + eElement.getElementsByTagName("port").item(0).getTextContent()+"'");
                    port = Integer.parseInt(eElement.getElementsByTagName("port").item(0).getTextContent());
                    ipaddress = eElement.getElementsByTagName("ipaddress").item(0).getTextContent();
                }
            }
        }
        catch (final ParserConfigurationException | SAXException | IOException e)
        {
            ErrorParsing = e.getMessage();
        }
    }

    /**
     * Getter of the port
     * @return port of the main application
     */
    public int getPort()
    {
        return port;
    }

    /**
     * Setter
     * @return
     */
    public String getIpaddress()
    {
        return ipaddress;
    }

    /**
     * Get the error
     * @return the error
     */
    public String getErrorParsing()
    {
        return ErrorParsing;
    }

}
