import com.pizza._
import PizzaBuilder._


println (
    PizzaBuilder create Pizza
        spread "sauce"
        spread "cheese"
        toppings("pinnepple", "ham")
        spread "cheese"
        bake
)