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
        int digit_sum = 0;
        int n = number;
        while (number > 0){
            int last_digit = n % 10;
            n /= 10;
            digit_sum += factorials[last_digit];
            //For smaller numbers, the 9!s will quickly outpace the number
            //itself, so this check can make things faster by ending checks
            //early.
            if (digit_sum > number) return false;
        }
        return digit_sum == number;
    }
}
