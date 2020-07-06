// [4 May] Number Complement

class Solution {
    public int findComplement(int num) {
        
        StringBuilder no = new StringBuilder(Integer.toString(num, 2));
		for(int i = 0; i < no.length(); i++){
		    if(no.charAt(i) == '1') {
		        no.setCharAt(i, '0');
		    } else {
		        no.setCharAt(i, '1');
		    }
		}
		
		return Integer.parseInt(no.toString(), 2);
    }
}