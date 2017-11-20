cd build/classes/scala/main 
cat <<EOF | scala -language:postfixOps
:load ../../../../src/main/scala/main.scala 
EOF
