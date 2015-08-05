package com.eai;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: MessageConsumer
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"
		) },
		mappedName = "jms/localqueue")
public class MessageConsumer implements MessageListener {

    /**
     * Default constructor. 
     */
    public MessageConsumer() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        System.out.println("Incoming messages .... ");
        try {
		        if(message != null )        	
		        {
		        	
						System.out.println("message id ::: "+message.getJMSMessageID());
					
		        	String msg = message.toString();
		        	System.out.println(""+msg);
		        }	
        } catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
//    @Resource(name="jms/localQueueConnectionFactory")
//    private ConnectionFactory connectionfactory;
//
//    @Resource(name="jms/dataDestinationQ")
//    private Destination destination;

}
