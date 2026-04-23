class Solution {
    private boolean dfs(Map<Integer, List<Integer>> reqMap, int course, Set<Integer> visiting) {
        if (visiting.contains(course)) 
            return false;

        if (reqMap.get(course).isEmpty()) 
            return true;

        visiting.add(course);
        for (int req : reqMap.get(course)) {
            boolean feasible = dfs(reqMap, req, visiting);
            if (!feasible) return false;
        }
        visiting.remove(course);

        reqMap.put(course, List.of());
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> reqMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            reqMap.put(i, new ArrayList<>());
        }

        for (int[] preReq : prerequisites) {
            reqMap.get(preReq[0]).add(preReq[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(reqMap, i, new HashSet<>())) return false;
        }

        return true;
    }
}
