import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    Scanner scn =new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] box = new boolean[n][n];
    int totalQ = n;
    
    // System.out.println(twodQueen_permutation1(box, totalQ, 0, ""));
    System.out.println(twodQueen_combination1(box, totalQ, 0, "", 0));
    
  }
  
  public static boolean isQueenSafe(boolean[][] box, int r, int c){
      int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,1}, {1,1}, {1,-1}, {-1,-1}};
      for(int i=0; i<dir.length; i++){
          for(int j=1; j<box.length; j++){
                int r1 = j*dir[i][0];
                int c1 = j*dir[i][1];
                r1+=r;
                c1+=c;
                if(r1>=0 && r1<box.length && c1>=0 && c1<box.length && box[r1][c1])
                    return false;
          }
      }
      return true;
  }

  public static int twodQueen_permutation1(boolean[][] box, int totalQ, int qpsf, String asf){
    // write your code here
    int n = box.length;
    if(qpsf==totalQ){
        System.out.println(asf);
        return 1;
    }
    int count=0;
    for(int i=0; i<n*n; i++){
        int r = i/n;
        int c = i%n;
        if(!box[r][c]){
            box[r][c]=!box[r][c];
            count += twodQueen_permutation1(box, totalQ, qpsf+1, asf+ "("+r+" ,"+c+") ");
            box[r][c]=!box[r][c];
        }
    }
    return count;
  }
  
  public static int twodQueen_combination1(boolean[][] box, int totalQ, int qpsf, String asf, int idx){
    // write your code here
    int n = box.length;
    if(qpsf==totalQ){
        System.out.println(asf);
        return 1;
    }
    int count=0;
    for(int i=idx; i<n*n; i++){
        int r = i/n;
        int c = i%n;
        if(!box[r][c] && isQueenSafe(box, r, c)){
            box[r][c]=!box[r][c];
            count += twodQueen_combination1(box, totalQ, qpsf+1, asf+ "("+r+" ,"+c+") ", i+1);
            box[r][c]=!box[r][c];
        }
    }
    return count;
  }
}











