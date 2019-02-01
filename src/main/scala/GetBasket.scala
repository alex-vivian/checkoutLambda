import com.amazonaws.services.lambda.runtime.Context
import com.itv.chuckwagon.lambda._
import io.circe.generic.auto._
import awscala._, sqs._

case class Response(response:String)

class GetBasket extends Handler[Unit, Response]{
  implicit val sqs = SQS.at(Region.Ohio)

  def handler(query:Unit, context:Context): Response = {
    val queue: Queue = sqs.createQueueAndReturnQueueName("orders")

    val messages: Seq[Message] = queue.messages()
    messages.foreach(x => println(x.body))
    Response(messages(0).body)
  }
}
