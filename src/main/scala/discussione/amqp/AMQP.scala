package discussione.amqp

import com.rabbitmq.client._
import com.rabbitmq.client.AMQP.BasicProperties

class AMQP {

  val connection = {
    val factory = new ConnectionFactory
    factory.setHost("localhost")
    factory.setRequestedHeartbeat(0)
    factory.newConnection
  }
  
  val channel: Channel = connection.createChannel()
  val queue = "processed"
  
  def subscribe(action:String => Unit) = {
    val consumer = new DefaultConsumer(channel) {
      override def handleDelivery(tag: String, env: Envelope, props: BasicProperties, body: Array[Byte]) {        
    	val message = body.map(_.toChar).mkString    	
    	action(message)
    	channel.basicAck(env.getDeliveryTag, false)
      }
    }
    
    channel.queueDeclare(queue, false, false, true, null)
    channel.basicConsume(queue, false, consumer)
  }
  
  def publish(message: String) = {
    val props = new BasicProperties.Builder().replyTo(queue).build()
        
    channel.queueDeclare(queue, false, false, true, null)
    channel.basicPublish("", queue, props, message.getBytes("UTF-8"))
  }
  
  def close() = if (channel.getConnection().isOpen()) channel.getConnection().close()
  
}