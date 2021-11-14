class Solution {
    public class pair{
        int first;
        int second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    public boolean canIplace(char[][] board, int numb, int r, int c){
      // check in row
        for(int i=0; i<board.length; i++){
            if(board[i][c]-'0'==numb)
                return false;
        }
      // check in col
        for(int i=0; i<board.length; i++){
            if(board[r][i]-'0'==numb)
                return false;
        } 
      // for check in small 3*3 matrix
      
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
    
    public boolean sudoku(char[][] board, int idx, ArrayList<pair> list){
        if(idx==list.size()){
            return true;
        }
        int r=list.get(idx).first;
        int c=list.get(idx).second;
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
//     public void solveSudoku(char[][] board){
//         int n = board.length;
//         ArrayList<pair> list = new ArrayList<>();
//         for(int r=0; r<n; r++){
//             for(int c=0; c<n; c++){
//                 if(board[r][c]=='.'){
//                     list.add(new pair(r, c));
//                 }     
//             }
//         }
//         sudoku(board, 0, list);
//     }
  
    public void solveSudoku(char[][] board){
        int n = board.length;
        ArrayList<pair> list = new ArrayList<>();
        for(int i=0; i<n*n; i++){
            int r = i/n;
            int c = i%n;
            if(board[r][c]=='.'){
                list.add(new pair(r, c));
            }     
        }
        sudoku(board, 0, list);
    }
}











