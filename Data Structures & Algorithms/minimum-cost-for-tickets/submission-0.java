class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daysSet = Arrays.stream(days)
                         .boxed()
                         .collect(Collectors.toSet());
        int lastDay = days[days.length - 1];
        int[] state = new int[lastDay + 1]; 
        
        for (int day = 1; day <= lastDay; day++) {
            if (daysSet.contains(day)) {
                state[day] = 
                    Math.min(
                        state[day - 1] + costs[0],
                        Math.min(
                            state[Math.max(0, day - 7)] + costs[1],
                            state[Math.max(0, day - 30)] + costs[2]
                        )
                    );
            } else {
                state[day] = state[day - 1];
            }
        }
        return state[lastDay];
    }
}