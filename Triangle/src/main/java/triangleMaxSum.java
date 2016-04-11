import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.Arrays.stream;

public class triangleMaxSum {

    private static int[][] arrlist;

    public static void main(String[] args) throws Exception {
        int[][] data = Files.lines(Paths.get("D:\\trianglea.txt"))
                .map(s -> stream(s.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);

        arrlist = data;
        System.out.println("max-" + func(0, 0));
    }

    private static int func(int x, int y) {
        //stop status
        if (x >= arrlist.length)
            return 0;
        int self = arrlist[x][y];
        if (isPrime(self))
            return 0;
        else
            return self + Math.max(func(x + 1, y), func(x + 1, y + 1));
    }

    public static boolean isPrime(int num) {
        if (num==1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
