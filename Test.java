import java.util.*;

//partners are Chris Chambers
public class Test {
    public static void main(String[] args) {

        Stack<Integer> postfixStack = new Stack<Integer>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a postfix expression");
        String postFix = scan.nextLine();
        //postFix.split(" ");

        char[] ch = postFix.toCharArray();
        for(char c: ch) {
            if(c == ' ')
                continue;
            if(Character.isDigit(c)) {
                postfixStack.push((int)(c - '0'));
            }
            else {
                int y = postfixStack.pop();
                int x = postfixStack.pop();

                switch(c) {
                    case '+':
                        postfixStack.push(x+y);
                        break;
                    case '-':
                        postfixStack.push(x-y);
                        break;
                    case '*':
                        postfixStack.push(x*y);
                        break;
                    case '/':
                        if(y == 0){
                            postfixStack.push(y);
                        }else {
                            postfixStack.push(x / y);
                        }
                        break;
                }

            }
        }
        boolean flag = false;
        int result = 0;
        try {
            result = postfixStack.pop();
        }catch (EmptyStackException e){

            flag = true;
        }

        System.out.println(postfixStack);


        if(!flag && postfixStack.empty()){
            System.out.println("(correct)");
            System.out.println("Result = " + result);
        }else{
            System.out.println("(malformed)");
        }

        LinkedList<Integer> waitingQ = new LinkedList<Integer>();
        int wtimesum = 0;
        int avgwaiting = 0;
        int totalcustomers = 0;

        for(int time = 0, teller = 0; time <= 480; time++){
            if(Math.random() > 0.416666667){
                waitingQ.push(time);
                totalcustomers++;
            }
            if(teller == 0 && !waitingQ.isEmpty()){
                wtimesum += time - waitingQ.removeLast();
                teller = 5;
            }else if(teller > 0){
                teller--;
            }
            avgwaiting += waitingQ.size();
        }

        avgwaiting /= 480;
        wtimesum /= totalcustomers;

        System.out.println("Total Customers: "+ totalcustomers);
        System.out.println("Average # of customers in the Queue: "+ avgwaiting);
        System.out.println("Average waiting time per customer: "+ wtimesum + " minutes");


    }
}


/*import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
	public static void main(String[] args) {
		
		Stack<Integer> postfixStack = new Stack<Integer>();
		Scanner scan = new Scanner(System.in);
		int x = 0, y = 0;
		
		System.out.println("Enter a postfix expression");
		String postFix = scan.nextLine();
		postFix.split(" ");
		
		char ch[] = postFix.toCharArray();
		for(char c: ch) {
			if(c < '9' && c > '0') {
				postfixStack.push((int)(c - '0'));
			} else {
				y = postfixStack.pop();
		        x = postfixStack.pop();
		        switch(c) {
		          case '+':
		        	  postfixStack.push(x+y);
		            break;
		          case '-':
		        	  postfixStack.push(x-y);
		            break;
		          case '*':
		        	  postfixStack.push(x*y);
		            break;
		          case '/':
		        	  postfixStack.push(x/y);
		            break;
			}
		}
		
	}
		System.out.println(postfixStack);
		System.out.println("\n");
		System.out.println("---------------------------------------------");
		System.out.println("------------------Problem 2------------------");
		System.out.println("---------------------------------------------");
		
		int num = (int)Math.random();
		Queue<String> Customers = new LinkedList<String>();  
		
		if(num < 0.42) {
			Customers.add("Customer 1");
		}
	}
}*/
	
