package tide.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * activeMq基于queue的点对点消息发送
 * @author home
 *
 */
public class SendQueue {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD,
				"tcp://192.168.1.200:61616"
				);
		Connection connection=connectionFactory.createConnection();
		connection.start();
		
		// Session.AUTO_ACKNOWLEDGE	表示session会自动确认所接收的消息
		// Session.CLIENT_ACKNOWLEDGE	表示由客户端程序通过调用消息的确认方法来确认所收到的消息
		// Session.DUPS_OK_ACKNOWLEDGE	表示session将懒惰地确认消息，即不会立刻确认消息，这样有可能导致消息重复投递
		Session session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue("MessageQueue");
		
		MessageProducer producer=session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		ObjectMessage message = session.createObjectMessage("hello everyone");
		producer.send(message);
		
		session.commit();
		
	}

}
