/**
  * 1. There's duplicates, iterate whole array, will find one
  * 2. The input array is not sorted
  *
  */

object Solution {
    // Complexity: time O(n), space O(n)
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
      val nums_with_index = nums.zipWithIndex
      val value_index_map = nums_with_index.toMap

      nums_with_index.collectFirst {
        case (v, i) if value_index_map.get(target - v).exists(_!=i) => Array(i, value_index_map(target - v))
      }.get
    }

    def main(args: Array[String]): Unit = {
      println("start calculating:")

      //val input_arr = Array(2, 7, 11, 15)
      //val target = 9
      val input_arr = Array(3, 4, 9, 6, 4)
      val target = 8

      for (i <- twoSum(input_arr, target)) {
        println(i)
      }
    }
}
