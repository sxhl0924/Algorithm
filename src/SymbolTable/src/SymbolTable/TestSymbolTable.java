package SymbolTable;

public class TestSymbolTable {
    public static void main(String[] args) {
        /*SymbolTable <Integer, String> st = new SymbolTable<>();
        st.put(1, "a");
        st.put(2, "b");
        st.put(3, "c");
        st.put(4, "d");
        st.put(5, "e");

        System.out.println("Size of st: " + st.size());
        st.delete(5);
        System.out.println("Size of st: " + st.size());
        System.out.println("Value at key = 5: " + st.get(5));
        System.out.println("Value at key = 4: " + st.get(4));
        st.put(4,"D");
        System.out.println("Value at key = 4: " + st.get(4));*/


        OrderedSymbolTable<Integer, String> st = new OrderedSymbolTable<Integer, String>();
        st.put(1,"a");
        st.put(5,"e");
        st.put(3,"c");
        st.put(4,"d");
        st.put(2,"b");

        System.out.println("Size of st: "+st.size());
        st.delete(5);
        System.out.println("Size of st: "+st.size());
        System.out.println("Value at key = 5: "+st.get(5));
        System.out.println("Value at key = 4: "+st.get(4));
        st.delete(4);
        st.put(4,"D");
        System.out.println("Value at key = 4: "+st.get(4));
    }
}
