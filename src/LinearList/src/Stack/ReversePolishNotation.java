package Stack;

public class ReversePolishNotation {
    public static void main(String[] args){
        //3*（17-15）+18/6
        String[] notation = {"3", "17", "15", "-", "*","18", "6","/","+"};
        int result = Calculate(notation);
        System.out.println(result);
    }

    public static int Calculate(String[] notation){
          Stack<Integer> operands = new Stack<Integer>();
          Integer o1;
          Integer o2;
          Integer result;

          for(int i = 0; i<notation.length; i++){
              String curr = notation[i];
               switch(curr){
                   case "+":
                       o1 = operands.pop();
                       o2 = operands.pop();
                       result = o2 + o1;
                       operands.push(result);
                       break;

                   case "-":
                       o1 = operands.pop();
                       o2 = operands.pop();
                       result = o2 - o1;
                       operands.push(result);
                       break;

                   case "*":
                       o1 = operands.pop();
                       o2 = operands.pop();
                       result = o2*o1;
                       operands.push(result);
                       break;

                   case "/":
                       o1 = operands.pop();
                       o2 = operands.pop();
                       result = o2/o1;
                       operands.push(result);
                       break;

                   default:
                       operands.push(Integer.parseInt(curr));
                       break;

               }

          }
          result = operands.pop();//the last element in the stack is the calculated result
          return result;
    }
}
