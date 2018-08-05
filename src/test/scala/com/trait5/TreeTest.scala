package com.trait5

sealed abstract class Tree

case class Node(left: Tree, right: Tree) extends Tree
case class Leaf[A](value: A) extends Tree
case object EmptyLeaf extends Tree


object TreeTest {

  def main(args: Array[String]): Unit = {
    // DSL-like assignment:
    val treeA = Node(EmptyLeaf, Leaf(5))
    val treeB = Node(Node(Leaf(2), Leaf(3)), Leaf(5))

    // On Scala 2.8, modification through cloning:
    val treeC = treeA.copy(left = treeB.left)

    // Pretty printing:
    println("Tree A: "+treeA)
    println("Tree B: "+treeB)
    println("Tree C: "+treeC)

    // Comparison:
    println("Tree A == Tree B: %s" format (treeA == treeB).toString)
    println("Tree B == Tree C: %s" format (treeB == treeC).toString)
  }
}