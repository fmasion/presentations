package example

import org.scalajs.dom._
import org.scalajs.dom.raw.{CSSStyleSheet, HTMLDivElement}

import scala.scalajs.js.annotation.JSExport

@JSExport
object Demo2  {
  @JSExport
  def run(): Unit = {
    println("Hello from DEMO2")

    val div = Option(document.getElementById("toto").asInstanceOf[HTMLDivElement])

    val stylesheet: CSSStyleSheet = Option(document.getElementById("notExist").asInstanceOf[CSSStyleSheet]).getOrElse{
      val newStyle = document.createElement("style").asInstanceOf[CSSStyleSheet]
      newStyle.id = "notExist"
      document.head.appendChild(newStyle.asInstanceOf[Node])
      newStyle
    }
    println("creation d'une feuille de style " + stylesheet)
  }
}
