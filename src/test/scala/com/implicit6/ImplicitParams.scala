//package com.implicit6
//
//object ImplicitParams {
//
//  def greet(name: String)(implicit greeting: String) = s"$greeting, $name"
//
//  implicit val hi = "Hello"
//
//  def test = {
//    println( greet("Developers") )
//  }
//
//  def main(args: Array[String]): Unit = {
//    ImplicitParams.test
//  }
//}
