/**
 * Created by Giampiero on 10/16/2016.
 */
public class JT {
    private static boolean print = false;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int size = Integer.parseInt(args[0]);
        print = Boolean.parseBoolean(args[1]);
        initializeVars(size);
        System.out.println();
        System.out.println("Execution finished. Total time: " + (System.nanoTime() - startTime));
    }

    public static void initializeVars(int n) {
        int[] perm1   = new int[n];
        int[] invPerm2  = new int[n];
        int[] direction = new int[n];
        for (int i = 0; i < n; i++) {
            direction[i] = -1;
            perm1[i]  = i;
            invPerm2[i] = i;
        }
        perm(0, perm1, invPerm2, direction);

    }

    public static void perm(int n, int[] p, int[] pi, int[] dir) {

        // base case - print out permutation
        if (n >= p.length) {
            for (int i = 0; i < p.length; i++)
                if(print)
                System.out.print(p[i] + " ");
            return;
        }

        perm(n+1, p, pi, dir);
        for (int i = 0; i <= n-1; i++) {
            // swap
            if(print)
                System.out.println();
            int z = p[pi[n] + dir[n]];
            p[pi[n]] = z;
            p[pi[n] + dir[n]] = n;
            pi[z] = pi[n];
            pi[n] = pi[n] + dir[n];

            perm(n+1, p, pi, dir);
        }
        dir[n] = -dir[n];
    }



}
