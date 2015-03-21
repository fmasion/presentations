package sample.stream

import akka.actor.ActorSystem
import akka.stream.{scaladsl, FlowMaterializer}
import akka.stream.scaladsl._

import scala.concurrent.Future

object Exemple2 {

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("Sys")
    import system.dispatcher

    implicit val materializer = FlowMaterializer()

    val range = (1 to 10)

    //Aka Streams
    val source: Source[Int] = Source(range)
    val sink: FoldSink[Int, Int] = Sink.fold[Int, Int](0)(_+_)
    val flow = Flow[Int].filter(_ % 2 == 0)

    val step1: Source[Int] = source via flow
    val runnable: RunnableFlow = source via flow to sink
    val matMap: MaterializedMap = runnable.run()
    val fResult: Future[Int] = matMap.get(sink)


    println(matMap)
    fResult.onComplete{x =>
      println(x)
      system.shutdown()
    }
  }
}
