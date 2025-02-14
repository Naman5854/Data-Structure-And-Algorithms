 // to find whether a number is happy number or not
        public static boolean happyNumber(int num){
          int f=sum_square(num);
          int s=sum_square(num);
          do {
              f=sum_square(sum_square(f));
              s=sum_square(s);
          }while(f!=s);
          return s==1;
        }
        public static int sum_square(int n){
           int a=0;
           while(n>0){
               int rem=n%10;
               a=a+(rem*rem);
               n=n/10;
           }
           return a;
        }
public static void main(String[] args) {
  System.out.println(happyNumber(19));
    }
/* Output :- true
Conclusion for Happy Number Program:-
This program efficiently determines whether a given number is a Happy Number using Floyd’s Cycle Detection Algorithm. It repeatedly calculates the sum of squares of digits until it either:

Reaches 1, confirming that the number is a Happy Number.
Forms a cycle, proving that the number is not a Happy Number.
Key Features:
# Uses slow and fast pointers to detect cycles efficiently.
# Runs in O(log n) time complexity due to repeated digit sum calculations.
# Works for both happy and non-happy numbers without infinite loops.

This approach ensures optimal performance while keeping the code simple and readable. 
*/
