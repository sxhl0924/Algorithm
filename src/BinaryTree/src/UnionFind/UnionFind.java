package UnionFind;
/*1. each element uniquely corresponds to a node
2. elements in the same group belong to the same tree
3. elements in one tree (group) have none connection with elements in another tree (group)
4. in the same tree, there is no requirement or restriction for elements in parent nodes and child nodes

* */

public class UnionFind {
    private int[] eleAndGroup;//index: store the element; element: group ID (parent node) of the stored element
    private int count;//store the number of groups

    public UnionFind(int N){
        //in the initial condition, each element is stored in a separate group.
        //so the default number of group is N
        this.count = N;

        //initialize the group
        eleAndGroup = new int[N];
        //the index of eleAndGroup is the actually stored element, and the element corresponding
        //to the index is the group ID (parent node) of the index.
        for(int i=0; i<N;i++){//i = the stored element; eleAndGroup[i]= ID of the group i belongs to
            eleAndGroup[i]=i;
        }
    }

    public int count(){
        return count;
    }//the number of group

    //check if p and q are in the same group
    public boolean connected(int p, int q){
        return find(p)==find(q);//the group ID or root node of two elements is the same
    }

    //find the group ID or the root node of an element
    public int find(int p){
        return eleAndGroup[p];
    }

    public void union(int p, int q){
        //if p and q are in the same group now, do not need to unite
        if(connected(p, q)){
            return;
        }
        //if p and q are in different group now, set the group ID of all elements
        // which share the group ID with p as q.

        //find the root node of element p
        int pGroup = find(p);
        //find the root node of element q
        int qGroup = find(q);
        for(int i = 0;i<eleAndGroup.length;i++){
            if(eleAndGroup[i]==pGroup){
                eleAndGroup[i]=qGroup;
            }
        }
        //update the number of group
        count--;

    }

}
