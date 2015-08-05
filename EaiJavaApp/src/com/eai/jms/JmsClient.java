package com.eai.jms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsClient {
	

	public static void main(String[] args)
	{
		//Class initialization
        Context ctx = null;
			     QueueConnection connection = null;
			  Queue inQueue = null;
			  QueueSession session = null;
			  boolean transacted = false;
			
			  // Initialize properties for corba connection
			  Properties p = new Properties();
			  
			  p.put(Context.INITIAL_CONTEXT_FACTORY,
			    "com.ibm.websphere.naming.WsnInitialContextFactory");
			  //PROVIDER_URL: corbaloc:iiop:: Local
			  p.put(Context.PROVIDER_URL, "corbaloc:iiop:localhost:2814");
			  p.put("com.ibm.CORBA.ORBInit", "com.ibm.ws.sib.client.ORB");
			  
			  System.out.println("put env - finished");
			
			  try {
			   ctx = new InitialContext(p);
			   if (null != ctx)
			    System.out.println("Got naming context");
			                
			   //Get the Queue Connection Factory
			   QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) ctx
			     .lookup("jms/localqueuefactory");
//			   QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) ctx
//					     .lookup("jms/QueueConnectionFactory");
			    
			   
			            //Get the actual queue
			   inQueue = (Queue) ctx.lookup("jms/localqueue");
			   
			   
			            //Start the Connection
			      connection = queueConnectionFactory.createQueueConnection();
			   connection.start();
			   
			            //Create a transacted session
			   session = connection.createQueueSession(transacted,
			     Session.AUTO_ACKNOWLEDGE);
			                    
			            //Create a queue browser
			   QueueBrowser qb = session.createBrowser(inQueue);
			   
			   //Send a JMS Queue Message
			   QueueSender queueSender = session.createSender(inQueue);
			            
			            //Dummy message
			   DateFormat dateFormat = new SimpleDateFormat(
			     "yyyy/MM/dd HH:mm:ss");
			   Date date = new Date();
			
			   TextMessage outMessage = session
			     .createTextMessage("From client "
			       + dateFormat.format(date));
			                            
			            //Send dummy message
			   queueSender.send(outMessage);
		/*	   
			            //Generate a receiver for the queue
			   QueueReceiver queueReceiver = session.createReceiver(inQueue);
			   Message inMessage = queueReceiver.receive(2000); //2000 = timeout
			            
			            //Print out received message
			   if (inMessage instanceof TextMessage) {
			    String replyString = ((TextMessage) inMessage).getText();
			    System.out
			      .println("Message received from queue is a TextMessage: "
			        + replyString);
			   }
		*/	
			   System.out.println("successfully posted message");
			  } catch (NamingException e) { 
			   e.printStackTrace();
			  } catch (JMSException e) {
			   e.printStackTrace();
			
				}
			
	}
}
