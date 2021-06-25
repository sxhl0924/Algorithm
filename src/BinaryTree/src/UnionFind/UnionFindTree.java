package UnionFind;

public class UnionFindTree {
    private int[] eleAndGroup; //index: the stored element; element: parent node of the stored element
    private int count;//the number of group/tree

    public UnionFindTree(int N){
        this.count = N;

        //initialize the eleAndGroup array.
        // In default, each element is stored in an individual group
        //element:i, parent node: eleAndGroup[i]
        eleAndGroup = new int[N];
        for(int i = 0; i<N;i++){
            eleAndGroup[i]=i;//
        }
    }

    //get the number of groups
    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p)==find(q);
    }

    public int find(int p){
        while(true){
            //check whether the parent node eleAndGroup[p] of p is itself.
            // if yes, node p is the root node
            if(p==eleAndGroup[p]){
                return p;
            }
            //if not, call find() method recursively to
            // find the parent node until the root node is found
            p = eleAndGroup[p];
        }

    }

    //unite p and q in one group
    public void union(int p, int q){
        //find the root node of p
        int pRoot = find(p);
        //find the root node of q
        int qRoot = find(q);

        //if p and q are in the same group (tree) now, do not need to unite
        if(pRoot == qRoot){
            return;
        }
        //if p and q are not in the same group, set the root node of p as the root node of q
        eleAndGroup[pRoot]=qRoot;
        //update the number of groups
        count--;
    }


}
