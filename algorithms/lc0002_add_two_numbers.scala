/**
  * This is not an elegant way to implement in scala
  * corner cases:
  * 1. length l1 and l2 different
  * 2. 99 + 999, result is 4 digits, longer than the longest
  */

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    }
}
