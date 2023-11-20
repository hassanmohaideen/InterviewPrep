package graphs;

public class Dijkstras {

    static int[][] adjMatrix = new int[][] {
        { 0, 10, 1, 5 },
        { 1, 0, 1, 1 },
        { 2, 9, 0, 2 },
        { 5, 4, 3, 0 }
    };

    public static void call(int source) {
        boolean[] seen = new boolean[4];
        int[] dist = new int[4];

        for (int i=0; i<dist.length; i++) {
            if (i != source) {
                dist[i] = Integer.MAX_VALUE;
            } else {
                dist[i] = 0;
            }
        }

        int minIndex = getMinIndex(dist, seen);
        while (minIndex != -1) {
            for (int i=0; i<adjMatrix[minIndex].length; i++) {
                if (i != minIndex) {
                    dist[i] = Math.min(dist[i], dist[minIndex] + adjMatrix[minIndex][i]);
                }
            }
            seen[minIndex] = true;
            minIndex = getMinIndex(dist, seen);
        }
        for (int i=0; i<dist.length; i++) {
            System.out.println(dist[i]);
        }
    }

    private static int getMinIndex(int[] dist, boolean[] seen) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i=0; i<dist.length; i++) {
            if (dist[i] < min && !seen[i]) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
