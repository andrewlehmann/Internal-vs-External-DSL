import com.pizza._
import org.scalatest._
import PizzaBuilder._

class TestPizzaBuilder extends FlatSpec {
    "canary" should "return true" in {
        assert(true)
    }
    
    "create Pizza" should "create a new object of type Pizza" in {
        val instance = 
          PizzaBuilder create Pizza
        
        assert(instance.getClass.getSimpleName == "Pizza")
    }

    "spread sauce" should "add sauce to the pizza's layer list" in {
       def instance = (
         PizzaBuilder create Pizza
           spread "sauce"
       )                
       
       assert(instance.layers(0) == "sauce")
    }
    
    "spread cheese" should "add cheese to the pizza's layer list" in {
        def instance = (
          PizzaBuilder create Pizza
            spread "cheese"
        )

       assert(instance.layers(0) == "cheese")
    }

    "toppings one, two, three" should "add one, two, and three to the layers list" in {
        def instance = (
          PizzaBuilder create Pizza
            toppings("one", "two", "three")
        )

        assert(instance.layers.toList == List("one", "two", "three"))
    }

    "bake" should "create and bake the pizza along with any contents added to it" in {
        def instance = (
          PizzaBuilder create Pizza
            bake
        )

        assert(instance.baked)
    }

    "toString" should "print all the layers on the pizza" in {
        def instance = (
          PizzaBuilder create Pizza
            spread "sauce"
            spread "cheese"
            toppings ("onions", "jalapenos", "green_pepper")
            spread "cheese"
            bake
        )

       var expected = "The layers on this pizza are: sauce, cheese, onions, jalapenos, green_pepper, cheese"
       
       assert(instance.toString == expected)
    }
}
