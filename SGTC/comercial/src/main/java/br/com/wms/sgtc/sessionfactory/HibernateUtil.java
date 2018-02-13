package br.com.wms.sgtc.sessionfactory;
	
import org.hibernate.SessionFactory;  
import org.hibernate.cfg.AnnotationConfiguration;
 
public class HibernateUtil {  
   
   private static final SessionFactory sessionFactory;  

   static  {  
	     
	   sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();  
   }  
	  
   public static SessionFactory getSessionFactory()   {  
	      
	   return sessionFactory;  
   }
   
   public void closeSession()   {
	   
	   	if ( !sessionFactory.isClosed()){
	   		sessionFactory.close();
	   		
	   	}
   }
}  
