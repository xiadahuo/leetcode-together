class Solution {
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int x, int y, String word, int index){
        if(board[x][y] != word.charAt(index)) return false;
        if(index == word.length()-1) return true;
        board[x][y] = '#';
        for(int i = 0; i < 4; i++){
            int a = dx[i] + x;
            int b = dy[i] + y;
            if(a >= 0 && a < board.length && b >= 0 && b < board[0].length){
                if (dfs(board, a, b, word, index+1)){
                    return true;
                }
            }
        }
        board[x][y] = word.charAt(index);
        return false;
    }
}