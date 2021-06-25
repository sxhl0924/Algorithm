package SequenceList;

public class TestSequenceList {
    public static void main(String [] args){
        //create a SequenceList object
        SequenceList<String> sl = new SequenceList<String>(2);
        //test add
        sl.add("apple");
        sl.add("pear");
        sl.add("banana");
        sl.add("watermelon");

        System.out.println(sl.length());

        /*//test get
        String res = sl.get(1);
        System.out.println("The element in index i: "+ res);

        //test insert
        sl.insert(1, "berry");

        //test remove
        String del = sl.remove(3);
        System.out.println("The removed element: "+ del);

        //test indexOf
        int index = sl.indexOf("berry");
        System.out.println("The index of the searching element: "+ index);

        //test clear
        sl.clear();
        System.out.println("The number of element: "+ sl.length());
*/
        for(String s : sl){
            System.out.println(s);
        }
    }
}
