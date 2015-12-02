/*This small Java program, written by Andrew H. Pometta, is made to solve
  project euler question number 34: digit factorials.  For more information
  on the mathematical reasoning and problem description, see the README.
*/

public class DigitFactorials {
    //See the README for why our max is known to be 2,540,160 and our min is 10
    final static int MAX = 2540160;

    public static void main(String[] args) {
        Factorials facts = new Factorials();
        int sum = 0;
        for (int i = 10; i < MAX; ++i){
            if (facts.digit_check(i)) sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
