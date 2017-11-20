package com.pizza

import scala.collection.mutable.ListBuffer

class Pizza {
   var layers = new ListBuffer[String]()
   var baked = false

   def spread(ingredient : String) = {
       layers += ingredient
       this
   }

   def toppings(ingredients: String*) = {
       layers ++= ingredients.to[ListBuffer]
       this
   }

   def bake() = {
       baked = true
       this
   }

   override def toString() : String = {
     "The layers on this pizza are: " + layers.mkString(", ")
   }

}
