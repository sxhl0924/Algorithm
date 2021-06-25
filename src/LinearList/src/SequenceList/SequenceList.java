package SequenceList;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{
    private T[] Eles;
    private int N; //the number of elements in current list

    //Constructor
    SequenceList(int capacity){
        Eles = (T[])new Object[capacity];
        N=0;
    }

    //clear the list
    public void clear(){
        N=0;
    }
    //check whether the list is empty
    public boolean isEmpty(){
        return N==0;
    }
    //get the length of list
    public int length(){
        return N;
    }
    //get the ith element of list
    public T get(int i){
        if(i<0||i>=N){
            throw new RuntimeException("The element does not exist!");
        }
        return Eles[i];
    }
    //insert an element in the ith position
    public void insert(int i, T t){
        if(i<0||i>=N){
            throw new RuntimeException("Invalid insertion index!");
        }
        if(N==Eles.length){
            resize(Eles.length*2);
        }
        //leave the ith position blank, and move every element backward from the index i+1
        for(int j=N-1; j>i;j--){
            Eles[j+1] = Eles[j];
        }
        //place the target element t in Eles[i]
        Eles[i] = t;
        //update the current number of elements in the list
        N++;
    }
    //add a new element to the list
    public void add(T t){
        if(N==Eles.length){
           resize(Eles.length*2);
        }
        Eles[N++]=t;

    }
    //remove and return the ith element
    public T remove(int i){
        //store the element Eles[i] in temp
        T temp = Eles[i];
        //move every element forward since the index i+1
        for(int j=i;j<N;j++){
            Eles[j]=Eles[j+1];
        }
        N--;
        //resize Eles if N<Eles.length/4
        if(N>0 && N<=Eles.length/4){
            resize(Eles.length/2);
        }
        return temp;

    }
    //return the index of an element
    public int indexOf(T t){
        if(t==null){
            throw new RuntimeException("The element is invalid!");
        }
        for(int i =0; i<N;i++){
            if(Eles[i].equals(t)){
                return i;
            }
        }
        return -1;//t does not exist
    }

    //print elements of the current list
    public void showEles(){
        for(int i =0; i<N; i++){
            System.out.print(Eles[i]+" ");
        }
    }

    // define an inner class SIterator to implement Iterator interface
    @Override
    public Iterator iterator(){
        return new SIterator();
    }
    private class SIterator implements Iterator{
        private int cur;
        public SIterator(){
            this.cur=0;
        }
        @Override
        public boolean hasNext(){
            return cur<N;
        }
        @Override
        public T next(){
            return Eles[cur++];
        }
    }

    //resize the list
    private void resize(int newSize){
        T[] temp = Eles;//store the old list
        Eles= (T[]) new Object[newSize];//create a new list
        //copy the old list to the new lsit
        for(int i=0;i<N;i++){
            Eles[i] = temp[i];
        }

    }
    //
    public int capacity(){
        return Eles.length;
    }

}
