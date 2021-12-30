// ---------- Tuples
val x = (1, 2.3, "abc")
x._1 // starts from 1
val (a, b, c) = x

alist.zip(blist).toMap
alist.zipWithIndex.toMap


// ---------- Map

// immutable
val m = Map(1->2, 2->3, 3->4)
val m = Map((1, 2), (2, 3), (3, 4))

// mutable
val mutable_map = scala.collection.mutable.Map(1->2, 3->4)
val mutable_map = scala.collection.mutable.Map[String, Int]()
val mutable_map = scala.collection.mutable.SortedMap[String, Int]()

m.get(1) // Some(2)
m.get(1).exists(_!=10) // false
m(1) // 2

for ((k, v) <- map) process k and v
for (k <- map.keySet) process k
for (v <- map.values) process v

// ---------- Array
val arr
arr.length
arr.isEmpty

// Array: when length is fixed, values mutable
// ArrayBuffer: when length can vary
val s = Array[Int](10)     // Array with 1 element 10
val s = new Array[Int](10) // Array with 10 elements 0
s(3) = 4   // value is mutable

val ab = ArrayBuffer[Int]()
val ab = new ArrayBuffer[Int]()
ab.toArray // ArrayBuffer => Array

for (i <- 0 until s.length) { operation }
for (i <- 0 until s.length by 2) { operation } // 0, 2, 4, 6 ...
for (elem <- s) {xxx}

for (elem <- s) yield 2 * elem // generate new array
for (elem <- s if elem % 2 == 0) yield 2 * elem // generate new array
s.filter(_ % 2 == 0).map(_ * 2)

val mt = new Array[Array[Int]](10)
for (i <- mt.indices) mt(i) = new Array[Int](i + 1)

//
