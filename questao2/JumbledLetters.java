package cesar_jumbledLetters;

public class JumbledLetters {
	private static boolean checkPermutation(String word, String permutation ) {
		//if firsts characteres are equal, check the others, if not, return false 
		if (word.charAt(0) == permutation.charAt(0)) {
			//if word is less than 3 character return true
			if( word.length() <= 3 ) {
				return true;
			}
			else {
				int count_mismatch = 0;
				//check the number of mismatching characters
				for(int i = 1; i < word.length(); i++) {
					if(word.charAt(i) != permutation.charAt(i)) {
						count_mismatch = count_mismatch + 1;
					}
				}
				//if number of character that changed place is up to 2/3 of length of word, return true
				if (count_mismatch <= (word.length()/3)*2  ) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		//test set to test the function
		System.out.println("you, yuo -> " + checkPermutation("you", "yuo") );
		System.out.println("probably, porbalby -> " + checkPermutation("probably", "porbalby") );
		System.out.println("despite, desptie -> " + checkPermutation("despite", "desptie") );
		System.out.println("moon, nmoo -> " + checkPermutation("moon", "nmoo") );
		System.out.println("misspellings, mpeissngslli -> " + checkPermutation("misspellings", "mpeissngslli") );

	}

}
