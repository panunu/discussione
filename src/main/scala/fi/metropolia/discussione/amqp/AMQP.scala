package fi.metropolia.discussione.amqp

import com.rabbitmq.client._
import com.rabbitmq.client.AMQP.BasicProperties
import sun.misc.{BASE64Decoder, BASE64Encoder}

class AMQP {

  private val connection = {
    val factory = new ConnectionFactory
    factory.setHost("localhost")
    factory.setRequestedHeartbeat(0)
    factory.newConnection
  }

  private val channel: Channel = connection.createChannel()
  
  def consume(queue:String, action:String => Unit): Unit = {
    val consumer = new DefaultConsumer(channel) {
      override def handleDelivery(tag: String, env: Envelope, props: BasicProperties, body: Array[Byte]) {        
        val message = AMQP.decode(body.map(_.toChar).mkString)
        action(message)
      }
    }

    channel.queueDeclare(queue, true, false, false, null)
    channel.basicConsume(queue, true, consumer)
  }
  
  def produce(queue:String, message: String): Unit = {
    val props = new BasicProperties.Builder().build()
    
    channel.queueDeclare(queue, true, false, false, null)
    channel.basicPublish(queue, "", null, message.getBytes("UTF-8"))
  }
  
  def close(): Unit = if (channel.isOpen()) channel.close()  
}

object AMQP {
  def decode(message: String): String = new String(new BASE64Decoder().decodeBuffer(message))
  def encode(message: String): String = new String(new BASE64Encoder().encodeBuffer(message.getBytes()))
}
