class Pizza
    attr_accessor :layers, :baked

    def initialize
        @layers = []
    end
                                                         
    def spread(ingredient)
        @layers << ingredient
    end

    def toppings(*ingredients)
        @layers << ingredients
    end

    def baked
        @baked = true
    end

    def method_missing(name) 
        name.to_s
    end
    
    def to_s
        "The layers of this pizza are #{layers.join(", ")}"
    end
end
