package com.pojo4

import scala.beans.BeanProperty


/**
  * Способ №3
  * SCALA, подобно JAVA, тоже поддерживает библиотеку типа 'lombok' - это позволяет анотировать поля класа для которых будут генерироваться get-set-методы (при этом не нужен конструктор с параметрами...)
  */
class Clazz33 {

  @BeanProperty
  var mutableField: Int = _

  override def toString: String = s"Clazz33($mutableField)"
}
