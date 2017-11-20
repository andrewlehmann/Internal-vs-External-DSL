require "minitest/autorun"
require './src/pizza_builder'

class TestPizza < MiniTest::Test
  def test_canary
    assert true
  end

  def test_create
    instance = evaluate('create Pizza')
    
    assert_equal 'Pizza', instance.class.name
  end

  def test_spread
    dsl = <<-DSL
      create Pizza do
        spread sauce
      end
    DSL
    
    instance = evaluate(dsl)

    assert_equal %w{ sauce }, instance.layers
  end

  def test_toppings
      dsl = <<-DSL
        create Pizza do 
          toppings onions, jalapenos, green_peppers
        end
      DSL

      instance = evaluate(dsl)
      assert_equal %w{ onions jalapenos green_peppers }, instance.toppings.first
  end

  def test_baked
      dsl = <<-DSL
        create Pizza do
          bake
        end
      DSL

      instance = evaluate(dsl)
      assert instance.baked
  end

  def test_to_s
    dsl = <<-DSL
      create Pizza do
        spread sauce
        toppings onions, jalapenos, green_peppers
        spread cheese
        bake
      end
    DSL

    instance = evaluate(dsl)


    expected = 'The layers of this pizza are sauce, onions, jalapenos, green_peppers, cheese'
      
    assert_equal expected, instance.to_s
  end
end
