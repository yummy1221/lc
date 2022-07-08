Monday May 9, 2022

# Round 1: 7:00pm - 8:00pm
interviewer: [Zhicai Miao](https://www.linkedin.com/in/zhicai-miao-98342a105/?originalSubdomain=cn)

## projects
- gateway service design: API, role, downstreams
- RESTFUL

## Algorithms
given a binary tree, return the largest path
```
// DFS
// helper (root node) => (sum, List[Node])

// return list of: leaf -> root
def getLargestPath(root: TreeNode): List[TreeNode] = {
	getLargestSumAndPath(root)._2
}

// return (path sum, path)
def getLargestSumAndPath(root: TreeNode): (Int, List[TreeNode]) = {
	if (root == null) {
		return ((0, List[TreeNode]()))
	}

	val left = getLargestSumAndPath(root.left)
	val right = getLargestSumAndPath(root.right)

	if (left._1 >= right._1) {
		return ((left._1 + root.value, left._2 + root))
	} else {
		return ((right._1 + root.value, right._2 + root))
	}

}
```

Given n, return all subarrays from [1, n]
```
// n: Int => 1 - n [[]]
// DFS:

// helper: (List[Int], k)
// result List[List[Int]]

// return: 1-n combinations
def getAllSubArrays(n: Int): List[List[Int]] = {
	val rst = ArrayBuffer[List[Int]]()
	val subarray = ArrayBuffer[Int]()

	def getSubArray(startNumber: Int): Unit = {
		if (startNumber == n + 1) {
			rst += subarray.toList
			return
		}

		// add startNumber to subarray
		subarray += startNumber
		getSubArray(startNumber + 1)
		subarray.remove(subarray.length - 1)

		// do not add startNumber to subarray
		getSubArray(startNumber + 1)
	}

	getSubArray(1)

	rst.toList
}
```

# Round 2: 8:00pm - 9:00pm
interviewer: [Zhixuan Zhang](https://www.linkedin.com/in/%E4%B9%8B%E5%AE%A3-%E5%BC%A0-bab5a6104/)
manager of the team
## Projects

## System Design
Design Group Chat

# Round 3: 10:00pm - 11:00pm

interviewer: [Bowen Cui](https://www.linkedin.com/in/bowencui2000/?originalSubdomain=cn)
manager of Zhixuan Zhang

Just projects
