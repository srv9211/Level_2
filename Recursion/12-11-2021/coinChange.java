import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i]=scn.nextInt();
        }
        int amount = scn.nextInt();
        
        System.out.println(infi_combinations1(coins, amount, 0, ""));
        // System.out.println(infi_combinations2(coins, amount, 0, ""));
        // System.out.println(sin_combinations1(coins, amount, 0, ""));
        // System.out.println(sin_combinations2(coins, amount, 0, ""));
        // System.out.println(infi_permutations1(coins, amount, ""));
    }
    
    //========================================COMBINATION
    
    public static int infi_combinations1(int[] coins, int amount, int idx, String psf){
        
        if(amount==0){
            System.out.println(psf);
            return 1;
        }
        int count=0;
        for(int i=idx; i<coins.length; i++){
            if(amount-coins[i]>=0)
                count += infi_combinations1(coins, amount-coins[i], i, psf+coins[i]+" ");
        }
        return count;
    }
    
    public static int infi_combinations2(int[] coins, int amount, int idx, String psf){
        
        if(amount==0){
            System.out.println(psf);
            return 1;
        }
        if(idx==coins.length)
            return 0;
        int count=0;
        if(amount-coins[idx]>=0)
            count += infi_combinations2(coins, amount-coins[idx], idx, psf+coins[idx]+" ");
        count += infi_combinations2(coins, amount, idx+1, psf);
        return count;
    }
    
    public static int sin_combinations1(int[] coins, int amount, int idx, String psf){
        
        if(amount==0){
            System.out.println(psf);
            return 1;
        }
        int count=0;
        for(int i=idx; i<coins.length; i++){
            if(amount-coins[i]>=0)
                count += sin_combinations1(coins, amount-coins[i], i+1, psf+coins[i]+" ");
        }
        return count;
    }
    
    public static int sin_combinations2(int[] coins, int amount, int idx, String psf){
        
        if(amount==0){
            System.out.println(psf);
            return 1;
        }
        if(idx==coins.length)
            return 0;
        int count=0;
        if(amount-coins[idx]>=0)
            count += sin_combinations2(coins, amount-coins[idx], idx+1, psf+coins[idx]+" ");
        count += sin_combinations2(coins, amount, idx+1, psf);
        return count;
    }
    
    //========================================PERMUTATIONS
    
    // public static int infi_permutations1(int[] coins, int amount, String psf){
        
    //     if(amount==0){
    //         System.out.println(psf);
    //         return 1;
    //     }
    //     int count=0;
    //     for(int i=0; i<coins.length; i++){
    //         if(amount-coins[i]>=0)
    //             count += infi_permutations1(coins, amount-coins[i], psf+coins[i]+" ");
    //     }
    //     return count;
    // }
    
    // public static int infi_combinations2(int[] coins, int amount, int idx, String psf){
        
    //     if(amount==0){
    //         System.out.println(psf);
    //         return 1;
    //     }
    //     if(idx==coins.length)
    //         return 0;
    //     int count=0;
    //     if(amount-coins[idx]>=0)
    //         count += infi_combinations2(coins, amount-coins[idx], idx, psf+coins[idx]+" ");
    //     count += infi_combinations2(coins, amount, idx+1, psf);
    //     return count;
    // }
    
    // public static int sin_combinations1(int[] coins, int amount, int idx, String psf){
        
    //     if(amount==0){
    //         System.out.println(psf);
    //         return 1;
    //     }
    //     int count=0;
    //     for(int i=idx; i<coins.length; i++){
    //         if(amount-coins[i]>=0)
    //             count += sin_combinations1(coins, amount-coins[i], i+1, psf+coins[i]+" ");
    //     }
    //     return count;
    // }
    
    // public static int sin_combinations2(int[] coins, int amount, int idx, String psf){
        
    //     if(amount==0){
    //         System.out.println(psf);
    //         return 1;
    //     }
    //     if(idx==coins.length)
    //         return 0;
    //     int count=0;
    //     if(amount-coins[idx]>=0)
    //         count += sin_combinations2(coins, amount-coins[idx], idx+1, psf+coins[idx]+" ");
    //     count += sin_combinations2(coins, amount, idx+1, psf);
    //     return count;
    // }
    
}







