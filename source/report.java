
/*
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class report extends HttpServlet {
    
    String report_link;
    
    @Override
    public void init(ServletConfig sc)
    {
        try {
            super.init(sc);
        } catch (ServletException exc) {
            Logger.getLogger(isotimiaservlet.class.getName()).log(Level.SEVERE, null, exc);
        }
    report_link = sc.getInitParameter("param2");
       
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
           response.sendRedirect(response.encodeRedirectURL(report_link)); 
            
        } finally {            
            out.close();
        }
    }

    
}

*/

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;




public class report extends HttpServlet {

    @Override
public void doGet (HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
    
        
    Attributeclass listener = (Attributeclass) getServletContext().getAttribute("link"); // edw pairnei to link
   
    String linkStr = listener.getLink();
    response.sendRedirect(linkStr);
}
}
