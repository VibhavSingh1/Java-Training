package com.thunderdrive.mavenproject1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.thunderdrive.bean.Connection;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome To Spring Core Session" );
        // Traditionally we create objects in java using new keyword.
        // Programatically we add data in objects.
        
      /*  Connection con1 = new Connection();
        con1.setUrl("jdbc:mysql//localhost/estoredb");
        con1.setUsername("public1");
        con1.setPassword("Public_pass1");
        
        System.out.println("con1 is :");
        System.out.println(con1);	*/
     
        // As the part of security, we may change the password regularly for db
        //Hence, in our above example we will need to recompile and redeploy the code everytime we change the password.
        
        //Spring FW is the Solution
        //Spring Procedure steps:-
        //1. Configure dependencies i.e. Jar files for Spring Core
        //2. Create XML file in src directory and configure java objects there
        //3. USE IOC i.e. Inversion of Control
        //	IOC: we will not create objects as developers, let Spring FW create it for us.
        //	IOC Containers, which will manage the objects for us from creation till destruction.
        //	3.1 BeanFactory (not used much industrially)
        //	3.2 ApplicationContext
        //4. Use IOC Containers to get the reference of the Beans i.e., Java Objects and use them in your program.
        //5. Close the Context  to remove the objects (Optional) 
        
        
        //Using Beanfactory: creates object lazily i.e. when requested.
        //Object will be created when requested by using getBean.
        //Object won't be created by instantiating BeanFactory.
        
       /* Resource resource = new ClassPathResource("beans.xml");
        BeanFactory factory = new XmlBeanFactory(resource);// Deprecated XmlBeanFactory...just to understand, no one use it
        
        //Using container to get the reference of the Bean.
        Connection c1 = (Connection)factory.getBean("con1");
        Connection c2 = factory.getBean("con2", Connection.class);
        
        System.out.println("c1 is: " + c1 + " and hashcode is: " + c1.hashCode());
        System.out.println("c2 is: " + c2 + " and hashcode is: " + c2.hashCode());
        */
        
        // 3.2 ApplicationContext IOC container: creates object eagerly or beforehand.
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        Connection c1 = (Connection)context.getBean("con1");
//        Connection c2 = context.getBean("con2", Connection.class);
//        Connection c3 = context.getBean("con2", Connection.class);
        
        System.out.println("c1 is: " + c1 + " and hashcode is: " + c1.hashCode());
//        System.out.println("c2 is: " + c2 + " and hashcode is: " + c2.hashCode());
//        System.out.println("c3 is: " + c3 + " and hashcode is: " + c2.hashCode()); // same hashcode as that of c1 i.e. Singleton model
//        
        ClassPathXmlApplicationContext ctx = (ClassPathXmlApplicationContext)context;
        ctx.close();
    } 
       
}
