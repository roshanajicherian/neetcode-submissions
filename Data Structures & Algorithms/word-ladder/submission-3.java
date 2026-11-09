class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String currentNode = queue.poll();
                if (currentNode.equals(endWord))
                    return level;
                char[] charArray = currentNode.toCharArray();
                for (int i = 0; i < currentNode.length(); i++) {
                    char originalChar = charArray[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (originalChar == j)
                            continue;
                        charArray[i] = j;
                        String newWord = new String(charArray);
                        if (words.contains(newWord)) {
                            queue.offer(newWord);
                            words.remove(newWord);
                        }
                    }
                    charArray[i] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
