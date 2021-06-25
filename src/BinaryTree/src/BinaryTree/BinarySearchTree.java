package BinaryTree;


import Queue.Queue;


public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private int N;

    public int size(){
        return N;
    }

    //add an element (k,v) to the tree
    public void put(Key k, Value v){
        root = put(root, k, v);//root represents the tree

    }

    //add element (k,v) to the subtree n and return the new tree
    private Node put(Node<Key, Value> n, Key k, Value v){
        if(n==null){//if the tree is empty, return (k,v) as the root node
            N++;
            return new Node(k,v,null,null);
        }
        int cmp = k.compareTo(n.key);
        if(cmp>0){//keep going to the right
            n.right = put(n.right,k, v);//recursion
        }else if(cmp<0){//keep going to the left
            n.left = put(n.left,k,v);
        }else{
            n.value = v;
        }
        return n;
    }

    public Value get(Key k){
        return get(root, k);
    }

    private Value get(Node<Key, Value> n, Key k){
        if(n == null){
            return null;
        }
        int cmp = k.compareTo(n.key);
        if(cmp>0){
            return get(n.right,k);
        }else if(cmp<0){
            return get(n.left,k);
        }else{
            return n.value;
        }
    }

    public void delete(Key k){
        root = delete(root, k);
    }

    private Node delete(Node<Key, Value> n, Key k){//target Node n, n.key = k
        if(n==null){//if the tree is empty, directly return null
            return null;
        }
        int cmp = k.compareTo(n.key);//compare k to the key of current node
        if(cmp>0){//keep going to the right subtree by calling delete() function recursively
            n.right = delete(n.right, k);
        } else if(cmp<0){// keep going to the right subtree by calling delete() function recursively
            n.left = delete(n.left, k);
        }else{//when k = n.key, the target subtree is found
            /*if the target tree has no right subtree, return its left subtree so that the
            left subtree can relink with the parent tree of the deleted node.
            */
            N--;//****update N here!! Not in the end of the whole else statement. Otherwise the N-- may not
            // be executed because there is a return statement inside the if statements
            if(n.right == null){
                return n.left;
            }
            if(n.left == null){//if the target tree has no left subtree, return the right subtree.
                return n.right;
            }

            /*If the target node has both right and left subtrees,after the target node is deleted,
            we should put another node to replace it, otherwise the subtree of the deleted node will
            lose the connection with the parent tree. Using the min node in the right subtree to replace the
           the deleted node */

            //find the minNode in the right subtree
            Node minNode = n.right;
            while(minNode.left!=null){
                minNode = minNode.left;
                if(minNode.left.left == null){
                    minNode.left = null;//delete the minNode
                }
            }

            /*Before we use the minNode to replace the role of the target node, we should
            remove the minNode from its original position*/
           /* Node x = n.right;
            while(x.left!=null) {

                if (x.left.left == null) {
                    x = x.left;
                    *//*x.left.left = null means that x.left is the last node on
                    the left side of the right tree, and at this time x.left is the minNode*//*
                    x.left = null;//delete the minNode
                } else {
                    x = x.left;//keep going left to find the minNode
                }
            }*/
            /*now the minNode has been removed from its original place, and we should then
            place it in the position of the deleted target node n */

            minNode.left = n.left;//n is the target node, set n.left as the minNode.left
            minNode.right = n.right;//set n.right as the minNode.right
            n = minNode;//put minNode to the position of n
        }
        return n;
    }


    //find the min key of a tree
    public Key min(){
        return min(root).key;

    }
    //find the min key of a specific subtree
    public Node<Key, Value> min(Node n){
        if(n.left == null){
            return n;
        }else{
            return min(n.left);
        }

    }

    //find the max key of a tree
    public Key max(){
        return max(root).key;
    }
    //find the max key of a specific child tree
    public Node<Key,Value> max(Node n){
        if(n.right == null){
            return n;
        }else{
            return max(n.right);
        }

    }

    //tree traversal
    //1. preorder: root->left->right
    //get all keys of the whole tree
    public Queue<Key> PreOrder(){
        Queue<Key> keys = new Queue<Key>();
        PreOrder(root, keys);
        return keys;
    }
    //get keys of a specific subtree n
    private void PreOrder(Node<Key, Value> n, Queue<Key> keys){
        if(n==null){
            return;
        }
        //put the current key into the queue
        keys.enqueue(n.key);
        //traverse the left tree of the current nodes and put all keys into the queue
        if(n.left!=null){
            PreOrder(n.left,keys);
        }
        if(n.right!=null){
            PreOrder(n.right,keys);
        }
    }
    //2. InOrder: left->root->right
    public Queue<Key> InOrder(){
        Queue<Key> keys = new Queue<Key>();
        InOrder(root,keys);
        return keys;
    }

    public void InOrder(Node<Key,Value> n, Queue<Key> keys){
        if(n==null){
            return;
        }

        if(n.left!=null){
            InOrder(n.left,keys);
        }

        keys.enqueue(n.key);

        if(n.right!=null){
            InOrder(n.right, keys);
        }
    }
    //3.PostOrder:left->right->root
    public Queue<Key> PostOrder(){
        Queue<Key> keys = new Queue<Key>();
        PostOrder(root, keys);
        return keys;
    }

    public void PostOrder(Node<Key, Value> n, Queue<Key> keys){
        if(n==null){
            return;
        }
        if(n.left!=null){
            PostOrder(n.left,keys);
        }
        if(n.right!=null){
            PostOrder(n.right, keys);
        }
        keys.enqueue(n.key);
    }

    //level order traversal
    public Queue<Key> LevelOrder(){
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> nodes = new Queue<Node>();
        nodes.enqueue(root);//put root into nodes
        while(!nodes.isEmpty()){
            Node<Key,Value> n = nodes.dequeue();//1st: pop the root node
            keys.enqueue(n.key);//store key of the root in keys
            if(n.left!=null){
                nodes.enqueue(n.left);//store the left nodes of root
            }
            if(n.right!=null){
                nodes.enqueue(n.right);//store the right nodes of root
            }
            //after the 1st cycle, nodes is not empty. re-enter the while loop and begin to traverse the second layer of the tree.
            //when all nodes have been traversed, the queue nodes becomes empty
        }
        return keys;
    }

    //the max depth of tree
    public int maxDepth(){
        return maxDepth(root);
    }
    //the max depth of a specific subtree.
    public int maxDepth(Node n){
        int maxL = 0;
        int maxR = 0;
        int max = 0;
        if(n==null){
            return 0;
        }
        if(n.left!=null){
            maxL = maxDepth(n.left);
        }
        if (n.right != null){
            maxR = maxDepth(n.right);
        }

        //if maxL>maxR, return maxL+1;otherwise return maxR+1.
        max = maxL > maxR ? maxL+1:maxR+1;
        return max;
    }




}
