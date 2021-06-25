package Stack;

public class BracketsMatch {
    public static void main(String[] args){
        String str = "adds(da)s(ba(a))(13df)";
        boolean match = isMatch(str);
        if(match){
            System.out.println("The brackets in " + str + " is matched.");
        }else{
            System.out.println("The brackets in " + str + " is not matched.");
        }
    }

    public static boolean isMatch(String str){
        Stack<String> left = new Stack();//use left to store left brackets
        for(int i = 0; i < str.length(); i++){//traverse the string to find "("
            String curr = str.charAt(i)+"";//charAt(index) can access the char elements of a string;
                                           // + a blank string "" to a Char will convert it to String
            if(curr.equals("(")){//store "(" in left
                left.push(curr);
            }else if(curr.equals(")")){
                String l = left.pop();//pop a "(" in the left when find a ")"
                if(l == null){//no "(" to match ")"
                    return false;
                }
            }
        }
        //The stack is empty means every ")" has found a matched "(".
        if(left.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
