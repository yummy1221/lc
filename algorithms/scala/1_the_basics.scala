// :paste => Ctrl + D
/** Chapter 1: the basics */

// rule of thumbs:
// 1. a parameterless method that doesn't modify the object has no parentheses


B >: Char // B is any supertype of class Char
B <: Char // B is any subtype of class Char


/** Chapter 2: Control Structures and Functions */
// string interpolation: 1. f - formatted 2. s - string without format 3. raw - raw string not evaluating escapes
print(f"Hello, $name! In six months, you'll be ${age + 0.5}%7.2f years old.%n")

// read from console:
io.StdIn.readLine("hello, your name:")
io.StdIn.readInt()

// loops
for (i <- expression)
  do operation

for (i <- 1 to 3) // 1, 2, 3
for (i <- 1 until 3) // 1, 2

for (i <- 1 to 3; j <- 1 to 10) // for loop i outer, for loop j inner, two for loops
for (i <- 1 to 3; from = 4 - i; j <- from to 10) yield i+j // for comprehension

// recursive sum
def recursiveSum(args: Int*): Int = {
  if (args.length == 0) 0
  else args.head + recursiveSum(args.tail: _*)
}

// val, lazy val, def
// val: evaluated as soon as words is defined
val words = scala.io.Source.fromFile("xxxxxx").mkString

// lazy val: evaluated the first time words is used
lazy val words = scala.io.Source.fromFile("xxxxxx").mkString

// def: evaluated each time words is used
def words = scala.io.Source.fromFile("xxxxxx").mkString
