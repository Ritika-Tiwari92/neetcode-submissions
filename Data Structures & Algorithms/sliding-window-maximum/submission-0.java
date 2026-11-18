class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque =   new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i < nums.length ; i++){
            int currentWinStart = i-k+1;
            if(!deque.isEmpty() && deque.peekFirst() < currentWinStart){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= k-1){
                list.add(nums[deque.peekFirst()]);
            }
        }
        int[] arr = new int[list.size()];

        for(int i=0 ; i<list.size() ; i++ ){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
