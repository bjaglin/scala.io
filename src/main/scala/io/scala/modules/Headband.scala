package io.scala.modules

import io.scala.Data

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.html

object Headband {
  def apply(): Div = div(
    span(
      Data.Headband.left,
      className := "headband__information"
    ),
    span(
      Data.Headband.right,
      className := "headband__information"
    ),
    className := "headband"
  )
}