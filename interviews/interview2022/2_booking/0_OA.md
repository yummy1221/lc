1. Meandering Array

[largest, smallest, 2nd_largest, 2nd_smallest, ...]
e.g.
input: [5, 2, 7, 8, -2, 25, 25]
output: [25, -2, 25, 2, 8, 5, 7]

2. Parking Dilemma
list of unsorted integers, denotes parking spot with cars
k: number of cars to cover
input: array, k
output: minimum length of cover to cover k cars

e.g.
input: [6, 2, 12, 7], k = 3
output: 6
explanation: 2, 6, 7


3. Award Top K Hotels

review contains positiveKeywords, +3
review contains negativeKeywords, -1
hotelIds length m = reviews length n

input:
  positiveKeywords: String
  negativeKeywords: String
  hotelIds: Array[Int]
  reviews: Array[String]
  k: Int

output:
  Array[Int]: list of hotelId

