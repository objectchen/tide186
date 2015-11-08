package tide.activemq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ListenerTopic {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD,
				"tcp://112.126.81.181:61616"
				);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("MessageTopic");
		
		MessageConsumer consumer = session.createConsumer(topic);
		consumer.setMessageListener(new MessageListener(){
			public void onMessage(Message message) {
				TextMessage tm = (TextMessage)message;
				try{
					System.out.println(tm.getText());
				}catch(JMSException e){}
			}
		});
		//connection.close();
		System.out.println("======ok");
	}

}
