def create(klass, &block)
    instance = klass.new
    instance.instance_eval &block if block_given?
    instance
end

def evaluate(dsl)
  code =<<-READ_UNTIL
    require './src/pizza'
    
    #{dsl}
  READ_UNTIL
  
  eval(code)
end
