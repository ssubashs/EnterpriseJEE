package com.eai;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateMessage
 */
public class CreateMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//	@Resource(mappedName = "jms/localqueue")
//	private Queue localqueue;
//	 
//	@Resource(mappedName = "jms/localqueuefactory")
//	private ConnectionFactory localqueueconnfactory;
	
	
	javax.naming.Context ic = null;
	javax.jms.QueueConnectionFactory qConnFactory = null;
	javax.jms.QueueConnection qConn = null;
	javax.jms.Queue queue = null;
	Queue tempqueue = null;
	javax.jms.QueueSession qSession = null;
	javax.jms.QueueSender qSender = null;
	javax.jms.TextMessage message = null;
	
    public CreateMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message_text = request.getParameter("msg");
		String queuename = request.getParameter("queue");
		System.out.println("Message to be posted :: "+message_text);
		try {
			ic = new javax.naming.InitialContext();
			qConnFactory = (javax.jms.QueueConnectionFactory) ic.lookup("java:comp/env/jms/localqueuefactory");
			queue = (javax.jms.Queue) ic.lookup("java:comp/env/jms/localqueue");
			tempqueue = (javax.jms.Queue) ic.lookup("java:comp/env/jms/tempqueue");
			
		} catch (Exception e) {
			System.err.println("Sample MDB client : JNDI lookup failed : " + e);
		}

		try {
			qConn = qConnFactory.createQueueConnection();
			qSession = qConn.createQueueSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
			if(queuename != null && "tempqueue".equalsIgnoreCase(queuename))
				qSender = qSession.createSender(tempqueue);
			else
				qSender = qSession.createSender(queue);
			message = qSession.createTextMessage(message_text);
			qSender.send(message);
			qSender.close();
			qConn.close();
			System.out.println("Sample MDB client : Message sent !");
		} catch (Exception e) {
			System.err.println("Sample MDB client : Error during message sending : " + e);
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
