package main

import (
	"log"
	"sort"
)

func main() {
	array1 := [][]int{{1, 1}, {4, 5}, {3, 8}}
	array2 := [][]int{{3, 1}, {1, 5}}
	log.Print(mergeSimilarItems(array1, array2))
}
func mergeSimilarItems(item1, item2 [][]int) [][]int {
	mp := map[int]int{}
	for _, a := range item1 {
		mp[a[0]] += a[1]
	}
	for _, a := range item2 {
		mp[a[0]] += a[1]
	}
	var ans [][]int
	for a, b := range mp {
		ans = append(ans, []int{a, b})
	}
	sort.Slice(ans, func(i, j int) bool {
		return ans[i][0] < ans[j][0]
	})
	return ans
}
