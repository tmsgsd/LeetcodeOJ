
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) return 0;
		if (s.length() == 1) return 1;
		int N = 1;
		int index = 0;
        char[] arr = s.toCharArray();
        for (int current = 1; current < arr.length; current++) {
        	for (int i = current - 1; i >= index ; i--) {
        			if (arr[i] == arr[current]) {        				
        				N = Math.max(N, current-index);
        				index = i + 1;
        				//System.out.println("N = "+N);
        				break;
        			} else {
        				N = Math.max(N, current-i+1);
        			}
        		}        	
        	}
        
        
       return N; 
    }
}
