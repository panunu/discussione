package discussione.amqp

import com.rabbitmq.client._
import com.rabbitmq.client.AMQP.BasicProperties

class AMQP {

  private val connection = {
    val factory = new ConnectionFactory
    factory.setHost("localhost")
    factory.setRequestedHeartbeat(0)
    factory.newConnection
  }
  
  private val channel: Channel = connection.createChannel()
  
  def consume(queue:String, action:String => Unit) = {
    val consumer = new DefaultConsumer(channel) {
      override def handleDelivery(tag: String, env: Envelope, props: BasicProperties, body: Array[Byte]) {        
    	val message = body.map(_.toChar).mkString
    	action(message)
      }
    }
    
    channel.basicConsume(queue, true, consumer)
  }
  
  def produce(queue:String, message: String) = {
    val props = new BasicProperties.Builder().replyTo(queue).build()
    
    channel.basicPublish("", queue, props, message.getBytes("UTF-8"))
  }
  
  def close() = if (channel.isOpen()) channel.close()
  
}