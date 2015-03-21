package sample.stream

import akka.actor.ActorSystem
import akka.stream.FlowMaterializer
import akka.stream.scaladsl.Source

import scala.concurrent.Future

object Exemple1 {

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("Sys")
    import system.dispatcher

    implicit val materializer = FlowMaterializer()

    val range = (1 to 10)

    //Scala Stream
    val result = range.toStream.filter(x => x % 2 == 0).fold(0)(_+_)
    println(result)

    //Aka Streams
    val fResult:Future[Int] = Source(range).filter(x => x % 2 == 0).fold(0)(_+_)
    fResult.onComplete{x =>
      println(x)
      system.shutdown()
    }
  }
}
