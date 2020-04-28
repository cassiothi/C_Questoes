package cesar_replacingCharacter;

public class ReplacingCharacter {

	private static char[] replace(char rep []) {
		int i = 0;
		
		while( i < rep.length ){
			if (rep[i] == ' ') {
				//shift the elements by 2 positions
				for( int j = rep.length-1; j > i; j-- ) {
					rep[j] = rep[j-2]; 
				}
				//replace space by &32
				rep[i]   = '&';
				rep[i+1] = '3';
				rep[i+2] = '2';
				
				i = i + 3;
			}
			else {
				i = i + 1;
			}
		}
		return rep;
	}
	
	public static void main(String[] args) {
		//String to test
		String s = "User is not allowed      ";
		//transform String to array of char
		char[] replaceVector = s.toCharArray();
		//print new vector
		for(int i = 0; i < replaceVector.length; i++) {
			System.out.print(replace(replaceVector)[i]);
		}

	}

}
