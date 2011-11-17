
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;
import java.util.*;
import javax.servlet.ServletConfig;

public class isotimiaservlet extends HttpServlet
{
    Vector country = new Vector();
    Vector rate = new Vector();
    
    String rate_link;
    
    @Override
    public void init(ServletConfig sc)
    {
        try {
            super.init(sc);
        } catch (ServletException exc) {
            Logger.getLogger(isotimiaservlet.class.getName()).log(Level.SEVERE, null, exc);
        }
        rate_link = sc.getInitParameter("param");
        // "http://www.ecb.int/stats/eurofxref/eurofxref-daily.xml"
    
        SAXBuilder saxBuilder = new SAXBuilder();
        
       
        try 
        {
            Document doc = saxBuilder.build(rate_link);
            
            Element rootNode = doc.getRootElement(); // root
            
            List children = rootNode.getChildren();  // 3
            
            Element child = (Element)children.get(2);  // Cube
           
            List children1 = child.getChildren(); // 1
            
            Element child1 = (Element)children1.get(0); // Cube
            
            List children2 = child1.getChildren();
            
            
            for(int i=0; i<33; i++)
            {
                Element child3 = (Element)children2.get(i); 
                
                country.add((String)child3.getAttribute("currency").getValue());
                country.trimToSize();
                
                rate.add((String)child3.getAttribute("rate").getValue());
                rate.trimToSize();
                
            }
            
        } 
        catch (JDOMException ex) 
        {
            Logger.getLogger(isotimiaservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(isotimiaservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
         response.setContentType("text/html;charset=UTF-8");

         PrintWriter out = response.getWriter();
         
         double analogia1 = 0;
         
         double analogia2 = 0;
         
         try
         {
           String Currency1 = request.getParameter("Currency1");
           String Currency2 = request.getParameter("Currency2");
           String amount = request.getParameter("amount");
           
           double answer = 0;
           
           double poso = Double.parseDouble(amount);
           
                      /* comparison with EURO */
           
           if ((Currency1).equals("EURO")==true && (Currency2).equals("EURO")==true)
           {
                answer=poso;
           }
           
           else if (Currency1.equals("EURO"))
           {
               
           for(int i=0; i<country.size(); i++)
           {
               String m = (String)country.get(i);
               String s = (String)rate.get(i);
               
               if(m.equals(Currency2)==true)
               {
                   
                   answer = poso*Double.parseDouble(s);
               }
           }
           }
           
           else if (Currency2.equals("EURO"))
           {
               
           for(int i=0; i<country.size(); i++)
           {
               String m = (String)country.get(i);
               String s = (String)rate.get(i);
               
               if(m.equals(Currency1)==true)
               {
                   
                   answer = poso/Double.parseDouble(s);}
           }
           
           }
                  
                      /*comparison of other than EURO Currencies*/
           
           else if ((Currency1).equals("EURO")==false && (Currency2).equals("EURO")==false)
           {
           for(int i=0; i<country.size(); i++)
           {
               String m = (String)country.get(i);
               if(m.equals(Currency1)==true)
               {
                   String s = (String)rate.get(i);
                   analogia1 = Double.parseDouble(s);
               }
           }
           
           for(int i=0; i<country.size(); i++)
           {
               String m = (String)country.get(i);
               String s = (String)rate.get(i);
               
               if(m.equals(Currency2)==true)
               {
                   
                   analogia2 = Double.parseDouble(s);
               }
           }
           
           
           
           System.out.println("amount "+poso);
           System.out.println("analogia1 "+analogia1);
           System.out.println("analogia2 "+analogia2);
           
           answer = poso * ((analogia2/analogia1));
           }
           
           System.out.println("answer"+answer);
           
           response.sendRedirect("index.jsp?answer=" + answer);
           
           /*out.println("<html>");
           out.println("<body>");
           out.println("<h1 style=\"color:navy\">"+ poso + "  " + Currency1 + "  =  "+ answer + "  " + Currency2 +"</h1>");
           out.println("</body>");
           out.println("</html>");
           */
         }
         finally
         {
            out.close();
         }
    }

    @Override
    public void destroy()
    {
        country.clear();
        country.trimToSize();
        rate.clear();
        rate.trimToSize();
    }

}


    