package cesar_checkTypos;

public class CheckTypos {
	
	private static boolean checktypos(String s1, String s2) {
		int mismatch_count = 0;
		//check if the strings have the same length
		if(s1.length() == s2.length()) {
			//count the number of mismatching elements
			for(int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) != s2.charAt(i)) {
					mismatch_count = mismatch_count + 1;
				}
			}
			// if the strings are 1 or zero typos away -> return true;
			if(mismatch_count <= 1) {
				return true;
			}
			else {
				return false;
			}
		}
		//string lengths are different
		else {
			//if the length difference is greater than 1 -> return false
			if(Math.abs( s1.length() - s2.length() ) > 1 ) {
				return false;
			}
			else {
				// if the length difference is equal 1
				//count the number of mismatching characters
				//Math.min(s1.length(), s2.length()) picks the lowest value between string lengths
				int i = 0;
				int j = 0;
				while(i < s1.length() && j < s2.length()) {
					if(s1.charAt(i) != s2.charAt(j)) {
						mismatch_count = mismatch_count + 1;
						if(s1.length() > s2.length()) {
							i++;
						}
						else{
							j++;
						}
					}
					else {
						i++;
						j++;
					}
				}
				//if the number of mismatching characters is up to 1 -> return true
				if (mismatch_count <= 1)
					return true;
				else
					return false;
			}
		}
	}
	public static void main(String[] args) {
		//Test set
		System.out.println("pale, ple -> " + checktypos("pale", "ple") );
		System.out.println("pales, pale -> " + checktypos("pales", "pale") );
		System.out.println("pale, bale -> " + checktypos("pale", "bale") );
		System.out.println("pale, bake -> " + checktypos("pale", "bake") );

	}

}
