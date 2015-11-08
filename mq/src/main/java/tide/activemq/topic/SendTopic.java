package tide.activemq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class SendTopic {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory =new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD,
				"tcp://192.168.1.200:61616"
				);
		
		Connection connection=connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		
		Topic topic = session.createTopic("MessageTopic");
		
		MessageProducer producer = session.createProducer(topic);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		TextMessage message = session.createTextMessage();
		message.setText("message_hello_001");
		
		producer.send(message);
		
		
	}

}
