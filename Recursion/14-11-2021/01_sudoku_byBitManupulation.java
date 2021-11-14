class Solution {
    public class pair{
        int first;
        int second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    public boolean sudoku(char[][] board,int idx , ArrayList<pair> list, int[] rows, int[] cols, int[][] mat){
        if(idx==list.size()){
            return true;
        }
        int r=list.get(idx).first;
        int c=list.get(idx).second;
        for(int num=1; num<=9; num++){
            int mask = 1<<num;
            if( ((rows[r]&mask)==0) && ((cols[c]&mask)==0) && ((mat[r/3][c/3]&mask)==0)){
                rows[r] ^= mask;
                cols[c] ^= mask;
                mat[r/3][c/3] ^= mask;
                board[r][c]=(char)(num+'0');
                if(sudoku(board, idx+1, list, rows, cols, mat))
                    return true;
                rows[r] ^= mask;
                cols[c] ^= mask;
                mat[r/3][c/3] ^= mask;
                board[r][c]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board){
        int n = board.length;
        int[] rows = new int[10];
        int[] cols = new int[10];
        int[][] mat = new int[3][3];
        ArrayList<pair> list = new ArrayList<>();
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                char ch = board[r][c];
                if(ch=='.'){
                    list.add(new  pair(r, c));
                }
                else{
                    int mask=(1<<(ch-'0'));
                    rows[r] ^= mask;
                    cols[c] ^= mask;
                    mat[r/3][c/3] ^= mask;
                }
            }
        }
        sudoku(board, 0, list, rows, cols, mat);
    }
}











