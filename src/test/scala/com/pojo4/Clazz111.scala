package com.pojo4

case class Clazz111(val immutableField: Int) { }

object Clazz111 {
  def apply() = new Clazz111(0)
//  def apply(immutableField: Int) = new Clazz111(immutableField)
}