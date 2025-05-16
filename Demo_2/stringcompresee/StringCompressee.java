package stringcompressee;

import java.util.ArrayList;

public class Animal {

	public class Chien extends StringCompressee{
		public compression2(){

		}
	}
	
	public String sc;

	public StringCompressee(String temp) {
		
		this.sc = compressemoilastring(temp);
		
	}

	public void printStringCompressee() {
		System.out.println(this.sc);
	}
	
	
	public int tailleOriginale() {
		
		String originale = decompresser();
		
		return originale.length()*16;
	}
	
	public int tailleCompressee() {
		return 16*this.sc.length();
	}
	
	
	public String decompresser() {
		String returnValue = "";
		
		String[] temp = this.sc.split(", ");
		
		for (int i = 0 ; i< temp.length ; i++) {
			String[] temp2 = temp[i].split("x ");
			
			int rep = Integer.parseInt(temp2[0]);
			
			for (int j = 0 ; j<rep ; j++) {
				returnValue += temp2[1];
			}
			
		}
		
		
		return returnValue;
		
	}

	private String compressemoilastring(String temp) {
		
		
		
		String returnValue = "";
		
		ArrayList<Character> mychars = new ArrayList<Character>();
		ArrayList<Integer> myreps = new ArrayList<Integer>();
		
		int listlength = 0;
		
		if (temp.length() == 0)
		{
			return "";
		}
		else
		{
			mychars.add(temp.charAt(0));
			myreps.add(1);
			listlength++;
		}
		
		for(int i = 1 ; i < temp.length() ; i++)
		{
			if (temp.charAt(i) == mychars.get(listlength -1)) {
				int j = myreps.get(listlength -1);
				myreps.remove(listlength -1);
				myreps.add(j+1);
			}
			else {
				mychars.add(temp.charAt(i));
				myreps.add(1);
				listlength++;
			}
			
			
		}
		
		
		returnValue += myreps.get(0) + "x " + mychars.get(0);
		
		for(int i=1 ; i< listlength ; i++)
		{
			returnValue += ", " + myreps.get(i) + "x " + mychars.get(i);
		}
		
		
		return returnValue;
		
	}

}
