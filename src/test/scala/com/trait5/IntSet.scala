package com.trait5

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

object IntSet {
  def apply(x: Int) = Empty.incl(x) //def singleton(first: Int): IntSet = Empty incl first
}