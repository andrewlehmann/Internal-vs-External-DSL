package com.pizza

object PizzaBuilder {
  val Pizza = classOf[Pizza]
  
  def create[T](klass : Class[T])  = klass.newInstance
}
