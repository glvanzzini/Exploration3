/*
* Names: Giampiero Vanzzini & Jacob Murillo
* Class: CSC 342
* Program: Johnson-Trotter Permutation
*/

public class JT {
    private static boolean print = false;

    public static void main(String[] args) {
        long startTime = System.nanoTime(); //this gets starting time
        int size = Integer.parseInt(args[0]); //gets first command line argument
        print = Boolean.parseBoolean(args[1]); //gets boolean command line arguement
        initializeVars(size); //initializes arrays needed and start permutations
        System.out.println();
        System.out.println("Execution finished. Total time: " + (System.nanoTime() - startTime)); //print execution time
    }

    // this method will create the arrays necessary
    public static void initializeVars(int n) {
        int[] perm1   = new int[n];
        int[] invPerm2  = new int[n];
        int[] direction = new int[n]; // -1 is left arrow, and 1 is right arrow
        for (int i = 0; i < n; i++) {
            direction[i] = -1; // set all arrows to the left
            perm1[i]  = i; // number the arrays from 0 to n
            invPerm2[i] = i;
        }
        perm(0, perm1, invPerm2, direction); //start permutations
    }

    // this will call the recursive perm method to perform the
    //   Johnson-Trotter permutation
    public static void perm(int n, int[] p, int[] pi, int[] dir) {

        // base case - print out permutation
        if (n >= p.length) {
            for (int i = 0; i < p.length; i++) {
                if (print)
                    System.out.print(p[i] + " "); //this prints out the array after it has been permutated
            }
            if(print)
                System.out.println(); //carriage return
            return;
        }

        // recursive call
        perm(n+1, p, pi, dir);

        for (int i = 0; i <= n-1; i++) {//this for loop does the actual permutation swapping.

            // swap here
            int z = p[pi[n] + dir[n]];
            p[pi[n]] = z;
            p[pi[n] + dir[n]] = n;
            pi[z] = pi[n];
            pi[n] = pi[n] + dir[n];

            // call perm again
            perm(n+1, p, pi, dir);
        }
        dir[n] = -dir[n]; //reverse direction here
    }
}
