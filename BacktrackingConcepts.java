import java.util.*;

public class BacktrackingConcepts {

    public static void main(String[] args) {

        // ==============================
        // 1. PERMUTATIONS
        // ==============================
        System.out.println("========== PERMUTATIONS ==========");
        int[] nums = {1, 2, 3};
        permutation(nums, new boolean[nums.length], new ArrayList<>());

        // ==============================
        // 2. SUBSETS
        // ==============================
        System.out.println("\n========== SUBSETS ==========");
        subset(nums, 0, new ArrayList<>());

        // ==============================
        // 3. COMBINATIONS (Choose 2)
        // ==============================
        System.out.println("\n========== COMBINATIONS ==========");
        combination(4, 2, 1, new ArrayList<>());

        // ==============================
        // 4. COMBINATION SUM
        // ==============================
        System.out.println("\n========== COMBINATION SUM ==========");
        int[] arr = {2,3,6,7};
        combinationSum(arr,7,0,new ArrayList<>());

        // ==============================
        // 5. N QUEENS
        // ==============================
        System.out.println("\n========== N QUEENS ==========");
        int n = 4;
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++)
            Arrays.fill(board[i], '.');

        solveQueens(board,0);

    }

    //=========================================================
    // PERMUTATION
    //=========================================================

    static void permutation(int[] nums, boolean[] used, List<Integer> current){

        if(current.size()==nums.length){
            System.out.println(current);
            return;
        }

        for(int i=0;i<nums.length;i++){

            if(used[i])
                continue;

            // Choose
            used[i]=true;
            current.add(nums[i]);

            // Explore
            permutation(nums,used,current);

            // Undo
            current.remove(current.size()-1);
            used[i]=false;
        }
    }

    //=========================================================
    // SUBSET
    //=========================================================

    static void subset(int[] nums,int index,List<Integer> current){

        System.out.println(current);

        for(int i=index;i<nums.length;i++){

            // Choose
            current.add(nums[i]);

            // Explore
            subset(nums,i+1,current);

            // Undo
            current.remove(current.size()-1);
        }

    }

    //=========================================================
    // COMBINATION
    //=========================================================

    static void combination(int n,int k,int start,List<Integer> current){

        if(current.size()==k){
            System.out.println(current);
            return;
        }

        for(int i=start;i<=n;i++){

            current.add(i);

            combination(n,k,i+1,current);

            current.remove(current.size()-1);
        }
    }

    //=========================================================
    // COMBINATION SUM
    //=========================================================

    static void combinationSum(int[] arr,int target,int start,List<Integer> current){

        if(target==0){
            System.out.println(current);
            return;
        }

        if(target<0)
            return;

        for(int i=start;i<arr.length;i++){

            current.add(arr[i]);

            combinationSum(arr,target-arr[i],i,current);

            current.remove(current.size()-1);
        }

    }

    //=========================================================
    // N QUEENS
    //=========================================================

    static void solveQueens(char[][] board,int row){

        if(row==board.length){

            for(char[] r:board)
                System.out.println(Arrays.toString(r));

            System.out.println();
            return;
        }

        for(int col=0;col<board.length;col++){

            if(isSafe(board,row,col)){

                // Choose
                board[row][col]='Q';

                // Explore
                solveQueens(board,row+1);

                // Undo
                board[row][col]='.';
            }

        }

    }

    static boolean isSafe(char[][] board,int row,int col){

        // Column
        for(int i=0;i<row;i++)
            if(board[i][col]=='Q')
                return false;

        // Left Diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
            if(board[i][j]=='Q')
                return false;

        // Right Diagonal
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++)
            if(board[i][j]=='Q')
                return false;

        return true;
    }

}