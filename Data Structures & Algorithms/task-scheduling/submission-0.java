class Solution {
    public static class CoolDownData {
        char c;
        int availableTime;

        public CoolDownData(char c, int availableTime) {
            this.c = c;
            this.availableTime = availableTime;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int currentTime = 0;
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        PriorityQueue<Character> pq =
            new PriorityQueue<>((c1, c2) -> Integer.compare(freq[c2 - 'A'], freq[c1 - 'A']));
        Queue<CoolDownData> coolDownQueue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.offer((char) (i + 'A'));
        }
        while (!pq.isEmpty() || !coolDownQueue.isEmpty()) {
            currentTime++;
            while (!coolDownQueue.isEmpty() && currentTime >= coolDownQueue.peek().availableTime) {
                pq.offer(coolDownQueue.poll().c);
            }
            if (!pq.isEmpty()) {
                Character c = pq.poll();
                freq[c - 'A']--;
                if (freq[c - 'A'] > 0) {
                    CoolDownData cd = new CoolDownData(c, currentTime + n + 1);
                    coolDownQueue.offer(cd);
                }
            }
        }
        return currentTime;
    }
}
