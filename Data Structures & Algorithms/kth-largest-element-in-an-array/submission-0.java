class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int n: nums) {
            minHeap.offer(n);
            while (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
