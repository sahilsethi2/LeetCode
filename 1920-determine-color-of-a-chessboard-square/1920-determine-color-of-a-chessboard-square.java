class Solution {
    public boolean squareIsWhite(String coordinates) {
        char col = coordinates.charAt(0);
        int row = coordinates.charAt(1) - '0';
        int colIndex = col - 'a' + 1;
        return (colIndex + row) % 2 == 1;
    }
}