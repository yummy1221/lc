/**
  * ---------- ---------- Getter & Setter
  */

// Scala by default generate getter & setter
obj.age        // getter, age()
obj.age = 10   // setter, age_=

class Person(val primaryConstructArgs: Int, private var age: Int) {
  // primaryConstructArgs becomes val in class
class Person(param1: Int, age: Int) {
  // if param1 used in def methods, it becoms object-private field
  // otherwise just params

// make primary constructor private
class Person private(param1: Int, age: Int) {

  // primary constructor
  // all statements in the class body will be executed as constructor
  println("Anything here is part of primary constructor")


  // auxiliary constructors
  def this(someParams: Int) {
    this() // calls primary constructor

     // other operations
  }

  def this(someParams: Int, someOther: String) {
    this(someParams) // must call another constructor first
  }



  // declare as private, getter and setter will also be private
  // class private field
  private var privateAge = 0  // privateAge has its own setter and getter

  // access using var name age
  def age = privateAge
  def age_=(newAge: Int) : Unit = {
    privateAge = newAge + 1
  }

  // not allow to access someOtherObj.value
  // object-private field, no getter or setter generated
  private[this] var value = xxx
}

// for val, not setter generated



/**
  * ---------- ---------- Companion Objects
  * used as static method
  * must be in same source file
  */

class Account {
  val id = Account.newUniqueNumber()
}

// can access each other's private features
object Account {   // companion object
  private var lastNumber = 0
  private def newUniqueNumber() = {
    lastNumber += 1
    lastNumber
  }

  // apply method allows creation object of class Account without using new keyword
  // e.g. val acct = Account(123.0) is actually calling apply method
  def apply(initialBalance: Double) = new Account(newUniqueNumber(), initialBalance)
}

/**
  * test class type
  */

p.isInstanceOf[Employee]
p.asInstanceOf[Employee]
p.getClass == classOf[Employee]

// pattern matching
p match {
  case s: Employee => xxx
  case _ => ...
}
