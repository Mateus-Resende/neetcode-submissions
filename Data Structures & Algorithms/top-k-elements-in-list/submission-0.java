class Solution {
    class Element {
        int val;
        int frequency;

        public Element(int val, int frequency) {
            this.val = val;
            this.frequency = frequency;
        }

        public int getFrequency() {
            return this.frequency;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Element> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.compute(num, (key, v) -> new Element(key, (v == null) ? 1 : v.frequency + 1));
        }

        PriorityQueue<Element> maxHeap =
            new PriorityQueue<>(k, (e1, e2) -> e1.frequency - e2.frequency);

        for (Element value : freqMap.values()) {
            maxHeap.add(value);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll().val;
        }

        return ans;
    }
}
