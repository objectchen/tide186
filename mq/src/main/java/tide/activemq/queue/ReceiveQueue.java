package tide.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ReceiveQueue {

	public static void main(String[] args) {
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD,
				"tcp://112.126.81.181:61616"
				);
		Connection connection=null;
		try {
			connection=connectionFactory.createConnection();
			connection.start();
			
			Session session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("MessageQueue");
			
			MessageConsumer consumer = session.createConsumer(destination);
			
			while(true){
				//取出消息
				ObjectMessage message = (ObjectMessage)consumer.receive(10000);
				if(null != message){
					String messageContent = (String)message.getObject();
					System.out.println(messageContent);
				}else{
					break;
				}
			}
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		System.out.println("====ok");
		
		
	}

}
