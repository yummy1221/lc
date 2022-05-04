Monday Apr 25, 2022
7:00pm to 8:00pm PDT Time with (Gaoqi Zheng)[https://www.linkedin.com/in/gaoqi-zheng-3a012365/?originalSubdomain=cn]

## Round 1

### Self Introduction

### Basics
1. micro service, definition
2. RPC call, thrift framework components, thrift 连接池的高效复用
3. thrift framework vs Google protobuff
4. What is OS, what it provides up and down
5. JVS vs OS
6. Database types, development in the past several years
7. CPU utilization when will be high


### algorithm

1. give 4 type of coins: 1, 2, 5, 10
return => min number of coins for amount n

Interviewer want me to use 背包算法, but I don't remember, so changed to algo 2

```
// binary tree, height
// BFS

def bfs(root: TreeNode): Int = {
	if (root == null) return 0

	val bfsQueue = Queue[TreeNode](root)
	var height = 0
	while(bfsQueue.nonEmpty) {
		height += 1
		for (i <- 0 until bfsQueue.length) {
			val node = bfsQueue.dequeue()
			if (node.left != null) {
				bfsQueue += node.left
			}
			if (node.right != null) {
				bfsQueue += node.right
			}
		}
	}

	return height
}

// DFS
```
