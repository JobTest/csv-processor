//package com.trait5_
//
///**
//  * @see http://qaru.site/questions/9727/scala-application-structure
//  */
//sealed abstract class Tree
//case class Node(left: Tree, right: Tree) extends Tree
//case class Leaf(n: Int) extends Tree
//
//object TreeTest extends App {
//
//  def isLeaf(t: Tree) = t match {
//    case Leaf(n: Int) => println("Leaf " + n)
//  }
//
//  val treeB = Node(Node(Leaf(2), Leaf(3)), Leaf(5))
//
//  println("Tree B: " + treeB)
//  isLeaf(treeB)
//}
