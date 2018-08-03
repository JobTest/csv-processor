package com.ajax_systems.akka.service.dto

class Person {

  private var _age: Int = 0

  def age: Int = _age

  def age_=(value: Int) = {
    _age = value
  }

}
