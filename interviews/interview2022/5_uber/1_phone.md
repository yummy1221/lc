Wednesday May 4, 2022 <br />
12:00pm to 1:00pm PDT Time <br />
interviewer: (PAN GAO)[https://www.linkedin.com/in/pan-gao-43890373/]

# Round 1

## Introductions
Interviewer from driver's side, driver uploading documents, for compliance issue.
Introduce myself

## algorithms
Give an array [3,1,1,1,2,2] <br />
Return top k frequent elements <br />
e.g. k = 2, [1,2]

```
object Solution {
    def getTopKFrequentElements(nums: List[Int], k: Int): List[Int] = {
        // 1. iterate and generate a map
        val elementToFrequencyMap = collection.mutable.Map[Int, Int]()
        for (e <- nums) {
            elementToFrequencyMap(e) = elementToFrequencyMap.get(e).getOrElse(0) + 1
        }

        // 2. enqueue to heap: (frequency, element)
        val pq = collection.mutable.PriorityQueue[(Int, Int)]().reverse

        for ((v, freq) <- elementToFrequencyMap) {
            if (pq.size >= k) {
                if (pq.head._1 < freq) {
                    pq.dequeue()
                    pq += ((freq, v))
                }
            } else {
                pq += ((freq, v))
            }
        }

        pq.map(_._2).toList
    }

    def main(args: Array[String]) {
        val rst = getTopKFrequentElements(List(3,1,1,1,2,2,2,3,4,5,3,2,1,3,10,2,4,6,7,8), 5)
        println(rst.mkString(", "))
        println("Hello, world")
    }
}

/*
0 1 2 3 4
[]
         l     r
0 pivot [1 2 3 4]

swap (r, pivot)
5   r  l
[5 4 3 6]

         r l
[1 2 3 4 5], k = 3
 r  l
[5, 2, 3, 4]
[5, 2, 3, 4] pivot = 0

target pivot = 2
1. pivot 0 start=0 end=4 => [5, 2, 3, 4, 1] pivot = 4 => start=0 end =3
2. pivot 0 l=1 r=3 => start = 1 end = 3 [5, 2, 3, 4, 1]
3.


[5,4,2]
[7,2,1]

*/
```

1. Using heap
2. Using heap with size K (write code)
3. quick select, only walk through several cases
4. If there's multiple threads to calculate, how to improve


## Q&A
17 mins left for QA
