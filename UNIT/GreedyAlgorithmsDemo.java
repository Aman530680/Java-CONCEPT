import java.util.*;

public class GreedyAlgorithmsDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("          GREEDY ALGORITHMS DEMONSTRATION         ");
        System.out.println("==================================================\n");

        runActivitySelection();
        runFractionalKnapsack();
        runJobSequencing();
        runHuffmanCoding();
        runPrimsAlgorithm();
        runKruskalsAlgorithm();
        runDijkstrasAlgorithm();
        runCoinChange();
    }

    // =========================================================================
    // 1. ACTIVITY SELECTION
    // =========================================================================
    static class Activity {
        int id, start, finish;
        Activity(int id, int start, int finish) {
            this.id = id;
            this.start = start;
            this.finish = finish;
        }
    }

    public static void runActivitySelection() {
        System.out.println("--- 1. Activity Selection ---");
        Activity[] activities = {
            new Activity(1, 1, 4),
            new Activity(2, 3, 5),
            new Activity(3, 0, 6),
            new Activity(4, 5, 7),
            new Activity(5, 3, 9),
            new Activity(6, 5, 9),
            new Activity(7, 6, 10),
            new Activity(8, 8, 11),
            new Activity(9, 8, 12),
            new Activity(10, 2, 14),
            new Activity(11, 12, 16)
        };

        // Sort activities by their finish time
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        List<Activity> selected = new ArrayList<>();
        // Select the first activity
        selected.add(activities[0]);
        int lastFinishTime = activities[0].finish;

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastFinishTime) {
                selected.add(activities[i]);
                lastFinishTime = activities[i].finish;
            }
        }

        System.out.print("Selected Activities (IDs): ");
        for (Activity a : selected) System.out.print("A" + a.id + " ");
        System.out.println("\nTotal Activities Selected: " + selected.size() + "\n");
    }

    // =========================================================================
    // 2. FRACTIONAL KNAPSACK
    // =========================================================================
    static class Item {
        int weight, value;
        double ratio;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }

    public static void runFractionalKnapsack() {
        System.out.println("--- 2. Fractional Knapsack ---");
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };
        int capacity = 50;

        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                int remaining = capacity - currentWeight;
                totalValue += item.ratio * remaining;
                break; // Knapsack full
            }
        }

        System.out.println("Knapsack Capacity: " + capacity);
        System.out.println("Maximum Value Obtained: " + totalValue + "\n");
    }

    // =========================================================================
    // 3. JOB SEQUENCING
    // =========================================================================
    static class Job {
        char id;
        int deadline, profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void runJobSequencing() {
        System.out.println("--- 3. Job Sequencing ---");
        Job[] jobs = {
            new Job('A', 2, 100),
            new Job('B', 1, 19),
            new Job('C', 2, 27),
            new Job('D', 1, 25),
            new Job('E', 3, 15)
        };

        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job j : jobs) maxDeadline = Math.max(maxDeadline, j.deadline);

        char[] schedule = new char[maxDeadline];
        boolean[] slots = new boolean[maxDeadline];
        int totalProfit = 0;

        for (Job job : jobs) {
            // Find a free slot from deadline-1 backwards
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    schedule[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.print("Scheduled Order: ");
        for (char id : schedule) {
            if (id != '\0') System.out.print(id + " ");
        }
        System.out.println("\nTotal Profit: " + totalProfit + "\n");
    }

    // =========================================================================
    // 4. HUFFMAN CODING
    // =========================================================================
    static class HuffmanNode {
        int frequency;
        char c;
        HuffmanNode left, right;

        HuffmanNode(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }

        HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
            this.c = '-';
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }

    public static void runHuffmanCoding() {
        System.out.println("--- 4. Huffman Coding ---");
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.frequency));

        for (int i = 0; i < charArray.length; i++) {
            pq.add(new HuffmanNode(charArray[i], charfreq[i]));
        }

        while (pq.size() > 1) {
            HuffmanNode x = pq.poll();
            HuffmanNode y = pq.poll();
            HuffmanNode sum = new HuffmanNode(x.frequency + y.frequency, x, y);
            pq.add(sum);
        }

        HuffmanNode root = pq.peek();
        System.out.println("Huffman Codes:");
        printHuffmanCodes(root, "");
        System.out.println();
    }

    private static void printHuffmanCodes(HuffmanNode root, String code) {
        if (root == null) return;

        if (root.left == null && root.right == null && root.c != '-') {
            System.out.println("  " + root.c + " : " + code);
            return;
        }
        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }

    // =========================================================================
    // 5. PRIM'S ALGORITHM (MST)
    // =========================================================================
    public static void runPrimsAlgorithm() {
        System.out.println("--- 5. Prim's Algorithm (MST) ---");
        int numVertices = 5;
        int[][] graph = {
            { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 }
        };

        int[] parent = new int[numVertices];
        int[] key = new int[numVertices];
        boolean[] mstSet = new boolean[numVertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minKey(key, mstSet, numVertices);
            mstSet[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        int totalWeight = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < numVertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t  " + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }
        System.out.println("Total Weight of MST: " + totalWeight + "\n");
    }

    private static int minKey(int[] key, boolean[] mstSet, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // =========================================================================
    // 6. KRUSKAL'S ALGORITHM (MST)
    // =========================================================================
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
                else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
                else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static void runKruskalsAlgorithm() {
        System.out.println("--- 6. Kruskal's Algorithm (MST) ---");
        int V = 4;
        List<Edge> edges = new ArrayList<>();

        // Helper closure to create edges easily
        int[][] edgeData = {
            {0, 1, 10}, {0, 2, 6}, {0, 3, 5},
            {1, 3, 15}, {2, 3, 4}
        };

        for (int[] e : edgeData) {
            Edge edge = new Edge();
            edge.src = e[0];
            edge.dest = e[1];
            edge.weight = e[2];
            edges.add(edge);
        }

        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(V);
        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            int rootSrc = ds.find(edge.src);
            int rootDest = ds.find(edge.dest);

            // If including this edge doesn't cause a cycle
            if (rootSrc != rootDest) {
                mst.add(edge);
                totalWeight += edge.weight;
                ds.union(rootSrc, rootDest);
            }
        }

        System.out.println("Edge \tWeight");
        for (Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + "\t  " + e.weight);
        }
        System.out.println("Total Weight of MST: " + totalWeight + "\n");
    }

    // =========================================================================
    // 7. DIJKSTRA'S ALGORITHM
    // =========================================================================
    public static void runDijkstrasAlgorithm() {
        System.out.println("--- 7. Dijkstra's Algorithm ---");
        int V = 9;
        int[][] graph = {
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };

        int src = 0;
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet, V);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Vertex \t Distance from Source (" + src + ")");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
        System.out.println();
    }

    private static int minDistance(int[] dist, boolean[] sptSet, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // =========================================================================
    // 8. COIN CHANGE (Greedy)
    // =========================================================================
    public static void runCoinChange() {
        System.out.println("--- 8. Coin Change (Greedy) ---");
        // Canonical coin denominations where greedy yields the optimal solution
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int amount = 93;

        List<Integer> result = new ArrayList<>();

        // Loop backwards starting from the largest denomination
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                result.add(coins[i]);
            }
        }

        System.out.println("Coins used to make change:");
        for (int coin : result) {
            System.out.print(coin + " ");
        }
        System.out.println("\nTotal Coins Needed: " + result.size());
        System.out.println("==================================================");
    }
}