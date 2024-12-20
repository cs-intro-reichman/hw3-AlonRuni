// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String[] args) {
	    // Tests some of the operations
	//	System.out.println(plus(2,3));   // 2 + 3
	//	System.out.println(plus(2,-3));   // 2 + (-3)
	//	System.out.println(plus(-2,-3));   // (-2) + (-3)
	//	System.out.println(minus(7,2));  // 7 - 2
	//	System.out.println(minus(2,7));  // 2 - 7
	//	System.out.println(minus(7,-2));  // 7 - (-2)
	//	System.out.println(minus(-2,-7));  // (-2) - (-7)
	//	System.out.println(times(-1,-1));  // -1 * (-1)
	//	System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
	//	System.out.println(pow(5,3));      // 5^3
	//	System.out.println(pow(3,5));      // 3^5
	//	System.out.println(div(-12,3));   // 12 / 3    
	//	System.out.println(div(5,-5));    // 5 / 5  
   	//	System.out.println(div(10,2));   // 10 / 2
   	//	System.out.println(mod(25,7));   // 25 % 7
   	//	System.out.println(mod(120,6));  // 120 % 6    
	//	System.out.println(sqrt(1));
   	//	System.out.println(sqrt(36));
	//	System.out.println(sqrt(263169));
   	//	System.out.println(sqrt(76123));

	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result = x1;
		if (x2 > 0) {
			while (x2 > 0) {
				result++;
				x2--;
			}
		} else {
			while (x2 < 0) {
				result--;
				x2++;
			}
		}
		return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int result = x1;
		if (x2 >= 0) {
			while (x2 > 0) {
				result--;
				x2--;
			}
		} else {
			while (x2 < 0) {
				result++;
				x2++;
			}
		}
		return result;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        int result = 0;

		if (x2 >= 0) {
			for (int i = 0; i < x2; i++) {
				result = plus(result, x1);
			}
		} else {
			for (int i = 0; i > x2; i--) {
				result = minus(result, x1);
			}
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) return 1;
		int result = x;
			for (int i = 0; i < n - 1; i++) {
				result = times(result, x);
			}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
        int countSteps = 0;
		int x1Ver = x1;
		int x2Ver = x2;
		int sum = 0;
		

		if (x1 < 0) x1Ver = times(x1, -1);
		if (x2 < 0) x2Ver = times(x2, -1);
		
		while (plus(sum, x2Ver) <= x1Ver) {
			sum = plus(sum, x2Ver);
			countSteps++;
		}
		if ((x1 > 0) && (x2 < 0) || (x1 < 0) && (x2 > 0)) return times(countSteps, -1);
		return countSteps;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int quotient = div(x1, x2);
		int product = times(quotient, x2);
		return minus(x1, product);
	}
	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x < 0) return 0;
		if (x == 1) return 1;
        int num = 1;
		for (int i = 0; i < div(x, 2); i++) {
			if (times(num, num) > x) {
				return minus(num, 1);
			}
			num++;
		}
		return 0;
	}	  	  
}