class Solution {
    public class pair{
        int first;
        int second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    public boolean sudoku(char[][] board,int idx , ArrayList<pair> list, boolean[][] rows, boolean[][] cols, boolean[][][] mat){
        if(idx==list.size()){
            return true;
        }
        int r=list.get(idx).first;
        int c=list.get(idx).second;
        for(int num=1; num<=9; num++){
            if(!rows[r][num] && !cols[c][num] && !mat[r/3][c/3][num]){
                rows[r][num]=true;
                cols[c][num]=true;
                mat[r/3][c/3][num]=true;
                board[r][c]=(char)(num+'0');
                if(sudoku(board, idx+1, list, rows, cols, mat))
                    return true;
                rows[r][num]=false;
                cols[c][num]=false;
                mat[r/3][c/3][num]=false;
                board[r][c]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board){
        int n = board.length;
        boolean[][] rows = new boolean[10][10];
        boolean[][] cols = new boolean[10][10];
        boolean[][][] mat = new boolean[3][3][10];
        ArrayList<pair> list = new ArrayList<>();
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                char ch = board[r][c];
                if(ch=='.'){
                    list.add(new  pair(r, c));
                }
                else{
                    rows[r][ch-'0']=true;
                    cols[c][ch - '0']=true;
                    mat[r/3][c/3][ch-'0']=true;
                }
            }
        }
        sudoku(board, 0, list, rows, cols, mat);
    }
}











