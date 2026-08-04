class Solution {
    public int lastStoneWeight(int[] stones) {
                Queue<Integer> queue = new java.util.PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones){
            queue.add(stone);
        }
        while(queue.size()>=2){
            int stone1 = queue.poll();
            int stone2 = queue.poll();
            if (stone1!=stone2){
                queue.offer(stone1-stone2);
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
