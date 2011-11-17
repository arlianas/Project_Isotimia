





import javax.servlet.*;


public class Listenerreport implements ServletContextListener{
    
     @Override
    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext sc = event.getServletContext();
          
        Attributeclass newLink = new Attributeclass(sc.getInitParameter("url"));
        
        
        sc.setAttribute("link", newLink);
    }
     
     
    @Override
    public void contextDestroyed(ServletContextEvent event)
    {}
}
