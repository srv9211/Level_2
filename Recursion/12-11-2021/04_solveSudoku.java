class Solution {
    public boolean canIplace(char[][] board, int numb, int r, int c){
        for(int i=0; i<board.length; i++){
            if(board[i][c]-'0'==numb)
                return false;
        }
        for(int i=0; i<board.length; i++){
            if(board[r][i]-'0'==numb)
                return false;
        } 
        int r1 = (r/3)*3;
        int c1 = (c/3)*3;
        for(int i=r1; i<r1+3; i++){
            for(int j=c1; j<c1+3; j++){
                if(board[i][j]-'0'==numb)
                    return false;
            }
        }
        return true;
    }
    
    public boolean sudoku(char[][] board, int idx, ArrayList<ArrayList<Integer>> list){
        if(idx==list.size()){
            return true;
        }
        int r=list.get(idx).get(0);
        int c=list.get(idx).get(1);
        for(int num=1; num<=9; num++){
            if(canIplace(board, num, r, c)){
                board[r][c]=(char)(num+'0');
                if(sudoku(board, idx+1, list))
                    return true;
                board[r][c]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='.'){
                    ArrayList<Integer> addAl = new ArrayList<>();
                    addAl.add(i);
                    addAl.add(j);
                    list.add(addAl);
                }
            }
        }
        sudoku(board, 0, list);
    }
}




