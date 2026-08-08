/*
PROBLEM: Find Center of Star Graph

A star graph has one center node connected to all other nodes.
Given edges of the graph, return the center node.

Key Idea:
The center node will be common in the first two edges.
*/

class Solution {
    public int findCenter(int[][] edges) {

        int a = edges[0][0];
        int b = edges[0][1];

        int c = edges[1][0];
        int d = edges[1][1];

        if (a == c || a == d) return a;
        else return b;
    }
}
