/*
 * Eder Mazariegos
 * COP3330
 * Fall 2016
 */
package inputOutput;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author eder
 */
public class XmlParser
{
    //will hold the data necessary for the connection
    private ConnectionData connectionData;
    
    //will contain the xml file from which connectionData is going to get
    //the data from
    private Document document; 
    
    public XmlParser(String file)
    {
        parseXmlFile(file);
    }
    
    private void parseXmlFile(String fileName)
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        try
        {
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            //load XML file and parse it
            document = db.parse(ClassLoader.getSystemResourceAsStream(fileName));
            
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            
            //extracting data from each node
            for(int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);
                
                if(node instanceof Element)
                {
                    //get the type(name) and value from the node in XML file
                    String type = node.getAttributes().getNamedItem("type").getNodeValue();
                    
                    //create connectionData
                    connectionData = new ConnectionData();
                    connectionData.setType(type); 
                    
                    NodeList childNodes = node.getChildNodes();
                    
                    //put everything together
                    for(int j = 0; j < childNodes.getLength(); j++)
                    {
                        Node cNode = childNodes.item(j);
                        
                        if (cNode instanceof Element)
                        {
                            String content = cNode.getLastChild().getTextContent().trim();
                            
                            switch (cNode.getNodeName())
                            {
                                case "url":
                                    connectionData.setUrl(content);
                                    break;
                                case "ipaddress":
                                    connectionData.setIpaddress(content);
                                    break;
                                case "port":
                                    connectionData.setPort(content);
                                    break;
                                case "database":
                                    connectionData.setDatabase(content);
                                    break;
                                case "login":
                                    connectionData.setLogin(content);
                                    break;
                                case "password":
                                    connectionData.setPassword(content);
                                    break;
                                    
                            }
                        }
                    }
                        
                }
            }
        }
        
        catch(ParserConfigurationException pce)
        {
            pce.printStackTrace();
        }
        catch(SAXException se)
        {
            se.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    /**
     * @return the connectionData
     */
    public ConnectionData getConnectionData()
    {
        return connectionData;
    }
}
