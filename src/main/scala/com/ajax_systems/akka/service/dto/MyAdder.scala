package com.ajax_systems.akka.service.dto

class MyAdder(x: Int) {

  def apply(y: Int) = x + y

  override def toString = "MyAdder[ x=" + x + " ]"
}
