package com.implicit6


/**
  * @see https://www.oreilly.com/library/view/learning-scala/9781449368814/ch10.html
  */

object ImplicitClass {

  implicit class Hello(s: String) {
    def hello = s"Hello, $s"
  }

  def test = {
    println("World".hello)
  }
}

object ImplicitParam {

  def greet(greetName: String)(implicit greetHi: String) = s"$greetHi, $greetName"

  implicit val hi = "Hello"

  def test = {
    println( greet("Developers") )
  }
}

object ImplicitTest extends App {
  ImplicitClass.test
  ImplicitParam.test
}
