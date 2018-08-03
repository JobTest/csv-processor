package com.ajax_systems.akka.service.dto

//class Thing (private var _value: Int) {
class Thing {

  private var _value: Int = 0

  def value = _value

  def value_= (newValue: Int) = _value = newValue

  override def toString = "Thing[ _value = " + _value + " ]"

}
