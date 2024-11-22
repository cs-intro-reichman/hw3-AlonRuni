/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(isAnagram("Hello World!","hello world")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String strA = preProcess(str1);
		String strB = preProcess(str2);
	
		if (strA.length() != strB.length()) return false;
		
		for (int i = 0; i < strA.length(); i++) {
			int countA = 0;
			int countB = 0;
			for (int j = 0; j < strA.length(); j++) {
				if (strA.charAt(i) == strA.charAt(j)) {
					countA++;
				}
			}
			for (int j = 0; j < strB.length(); j++) {
				if (strA.charAt(i) == strB.charAt(j)) {
					countB++;
				}
			}

			if (countA != countB) {
				return false;
			}

			for (int j = 0; j < strB.length(); j++) {
                if (strB.charAt(j) == strA.charAt(i)) {
                    strB = strB.substring(0, j) + ' ' + strB.substring(j + 1);
                    break; 
                }
            }

		}
		
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String result = "";
		str = str.toLowerCase();
		String letters = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < str.length(); i++) {
			if (letters.indexOf(str.charAt(i)) != -1) {
				result = result + str.charAt(i);
			}
		}
		
		return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randomString = "";
		int limit = str.length();
		String remaining = str;
		
		for (int i = 0; i < limit; i++) {
			int randomNum = (int) (Math.random() * remaining.length());
			randomString += remaining.charAt(randomNum);
			remaining = remaining.substring(0, randomNum) +
						remaining.substring(randomNum + 1);
		}

		return randomString;
	}
}
