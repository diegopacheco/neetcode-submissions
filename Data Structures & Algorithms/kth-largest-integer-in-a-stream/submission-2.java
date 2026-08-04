 class KthLargest{

    private MinHeap minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new MinHeap(nums);

            while (this.minHeap.size > k){
                this.minHeap.pop();
            }
    }

    public int add(int val) {
            minHeap.add(val);
            if (minHeap.size > k){
                minHeap.pop();
            }
            return minHeap.heap[0];
        }
    }

    static class MinHeap {
        private int[] heap;
        private int size;

        public MinHeap(int[] array) {
            this.size = array.length;
            this.heap = array;
            buildMinHeap();
        }

        private void buildMinHeap() {
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }

        private void heapify(int i) {
            int smallest = i; // Initialize smallest as root
            int leftChildIdx = 2 * i + 1; // left = 2*i + 1
            int rightChildIdx = 2 * i + 2; // right = 2*i + 2

            // If left child is smaller than root
            if (leftChildIdx < size && heap[leftChildIdx] < heap[smallest])
                smallest = leftChildIdx;

            // If right child is smaller than smallest so far
            if (rightChildIdx < size && heap[rightChildIdx] < heap[smallest])
                smallest = rightChildIdx;

            // If smallest is not root
            if (smallest != i) {
                swap(i, smallest);

                // Recursively heapify the affected sub-tree
                heapify(smallest);
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void printHeap() {
            for (int i = 0; i < size / 2; i++) {
                System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
                        heap[2 * i + 1] + " RIGHT CHILD :" + heap[2 * i + 2]);
                System.out.println();
            }
        }

        public boolean isEmpty(){
            return size==0;
        }

        public int pop(){
            if (isEmpty()) return -1;

            int popped = heap[0];
            heap[0] = heap[size-1];
            size--;
            heapify(0);
            return popped;
        }

        public void add(int val){
            if (size == 0) {
                heap = new int[10];
            } else if (size == heap.length) {
                heap = Arrays.copyOf(heap, size * 2);
            }
            heap[size] = val;
            size++;
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }

    }
