class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int ops = 0, cnt = 0;

        // Left-to-right pass
        for (int i = 0; i < n; i++) {
            answer[i] += ops;
            cnt += (boxes.charAt(i) == '1') ? 1 : 0;  // Agar ball hai to count badhao
            ops += cnt;  // Operations mein ab tak ki balls ka contribution add karo
        }

        ops = 0; cnt = 0;

        // Right-to-left pass
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += ops;
            cnt += (boxes.charAt(i) == '1') ? 1 : 0;  // Agar ball hai to count badhao
            ops += cnt;  // Operations mein ab tak ki balls ka contribution add karo
        }

        return answer;
    }
}
