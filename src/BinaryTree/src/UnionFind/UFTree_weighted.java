package UnionFind;

public class UFTree_weighted {
    private int[] eleAndGroup;//index:element = the stored element: parent node of the stored element
    private int[] eleNum;//index: element = root node: number of the element in the tree
    private int count;

    UFTree_weighted(int N){
        this.count = N;

        //initialize eleAndGroup
        eleAndGroup = new int[N];//****must new a int[] first
        //in default, each element is stored in an individual tree
        for(int i=0;i<eleAndGroup.length;i++){
            eleAndGroup[i]=i;
        }

        //initialize eleNum
        eleNum = new int[N];//*****must new a int[] first
        //in default, only 1 element in each tree
        for(int i=0;i<eleNum.length;i++){
            eleNum[i] = 1;
        }

    }

    //find the root node of p
    public int find(int p){
        //find the parent node of p
        //int pNode = eleAndGroup[p];
        while(true){
            if(eleAndGroup[p]==p){//p parent node = p, p is the root
                return p;
            }
            p = eleAndGroup[p];//continue to find the parent node
        }
    }

    //check if p and q are in the same tree
    public boolean connected(int p, int q){
        //if the root node of p and q are the same, they are in the same tree
        return find(p)==find(q);

    }

    //unite p and q in one tree
    public void union(int p, int q){
        //check if p and q are in the same tree now
        int pRoot = find(p);
        int qRoot = find(q);
        //if yes, don't need to unite
        if(pRoot==qRoot){
            return;
        }

        //if no,compare the eleNum of pRoot tree and qRoot tree,
        // and add the smaller tree to the larger one
        if(eleNum[pRoot]<eleNum[qRoot]){//number of elements in qRoot tree is larger
            eleAndGroup[pRoot]=qRoot;//eleAndGroup[pRoot] is the root node of pRoot r=tree
            //update the eleNum of the larger tree
            eleNum[qRoot] = eleNum[qRoot] + eleNum[pRoot];
        }else{
            eleAndGroup[qRoot]=pRoot;
            eleNum[pRoot]=eleNum[pRoot]+eleNum[qRoot];
        }
        count--;

    }

    public int count(){
        return count;
    }

}
