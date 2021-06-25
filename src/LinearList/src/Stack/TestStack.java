package Stack;

public class TestStack {
    public static void main(String[] args) throws Exception{
        Stack<String> s = new Stack<String>();
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");

        for(String str : s){
            System.out.println(str+" ");
       }

        String result = s.pop();
        System.out.println("Pop an element: "+result);
        System.out.println(s.size());
    }
}
