/*Portion of small program written by Andrew H. Pometta for project euler
  question number 34.  For details, see README.
*/

//Small class containing the factorial of each digit - we save a lot of time
//by only calculating each one once
public class Factorials {
    private int[] factorials;
    public Factorials () {
        factorials = new int[10];
        factorials[0] = 1;
        for (int i = 1; i < 10; ++i) factorials[i] = factorials[i - 1] * i;
    }

    /*For an N digit number X with digits X(1), X(2), ... X(N), return true if
      X(1)! + X(2)! + ... + X(N)! = X
    */
    public boolean digit_check (int number) {
        //I used to to modulo to split the number, but tostring is way faster
        String digits = Integer.toString(number);
        int sum = 0;
        for (int i = 0; i < digits.length(); ++i){
            int digit = (int)(digits.charAt(i) - '0');
            sum += factorials[digit];
            //this check can reduce time for smaller numbers with a lot of 9's
            if (sum > number) return false;
        }
        return sum == number;
    }
}
