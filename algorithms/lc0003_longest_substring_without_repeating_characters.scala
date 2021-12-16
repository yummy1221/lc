import scala.collection._
object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        val charIndexMap = mutable.Map[Char, Int]()
        var l = 0
        var length = 0
        for ((c, r) <- s.zipWithIndex) {
            charIndexMap.get(c) foreach {i => l = l max i + 1}
            length = length max (r - l + 1)
            charIndexMap(c) = r
        }
        length
    }
}
