/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

//with void return type
/*
class Solution {
    public boolean isAllSame(int[][] grid, int x, int y, int n) {
        int val = grid[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (grid[i][j] != val) return false;
            }
        }
        return true;
    }

    public void solve(int[][] grid, int x, int y, int n, Node curr) {
        if (isAllSame(grid, x, y, n)) {
            curr.isLeaf = true;
            curr.val = (grid[x][y] == 1);
            // Children remain null by default as per the Node constructor
        } else {
            curr.isLeaf = false;
            curr.val = true; // Typical default for internal nodes

            int half = n / 2;
            
            // 1. Initialize the children nodes
            curr.topLeft = new Node();
            curr.topRight = new Node();
            curr.bottomLeft = new Node();
            curr.bottomRight = new Node();

            // 2. Recursively fill the children
            solve(grid, x, y, half, curr.topLeft);
            solve(grid, x, y + half, half, curr.topRight);
            solve(grid, x + half, y, half, curr.bottomLeft);
            solve(grid, x + half, y + half, half, curr.bottomRight);
        }
    }

    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) return null;
        
        Node root = new Node();
        solve(grid, 0, 0, grid.length, root);
        return root;
    }
}
*/
class Solution {
    public boolean isAllSame(int[][] grid,int x, int y,int n){
        int val=grid[x][y];
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(grid[i][j]!=val){
                    return false;
                }
            }
        }
        return true;
    }
    public  Node solve(int[][] grid,int x,int y,int n){
        if(isAllSame(grid,x,y,n)){
            Node t=new Node(grid[x][y] == 1,true);
            return t;
        }
        else{
            Node root=new Node(true,false);

            root.topLeft=solve(grid,x,y,n/2);
            root.topRight=solve(grid,x,y+n/2,n/2);
            root.bottomLeft=solve(grid,x+n/2,y,n/2);
            root.bottomRight=solve(grid,x+n/2,y+n/2,n/2);

            return root;

        }
    }
    public Node construct(int[][] grid) {
        int n=grid.length;
        return solve(grid,0,0,n);
    }
}