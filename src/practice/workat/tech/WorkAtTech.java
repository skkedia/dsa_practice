package practice.workat.tech;

public class WorkAtTech {
	
	public static int compareVersion(String version1, String version2) {
	       String s1 = "";
	       String s2 = "";
	       int i = 0;
	       int j = 0;
	       int n = version1.length();
	       int m = version2.length();
	       
	       
	       while(i < n || j < m) {
	    	   
	    	   while(i < n && version1.charAt(i) == '0') {
	    		   i++;
	    	   }
	    	   
	    	   while(i < n && version1.charAt(i) != '.') {
	    		   s1 += version1.charAt(i);
	    		   i++;
	    	   }
	    	   
	    	   while(j < m && version2.charAt(j) == '0') {
	    		   j++;
	    	   }
	    	   
	    	   while(j < m && version2.charAt(j) != '.') {
	    		   s2 += version2.charAt(j);
	    		   j++;
	    	   }
	    	   
	    	   if(s1.length() > s2.length()) {
	    		   return 1;
	    	   } else if (s2.length() < s1.length()){
	    		   return -1;
	    	   }
	    	   
	    	   for(int k = 0; k < s1.length(); k++) {
	    		   if(s1.charAt(k) > s2.charAt(k)) {
	    			   return 1;
	    		   } else if (s2.charAt(k) < s2.charAt(k)) {
	    			   return -1;
	    		   }
	    	   }
	    	   s1 = "";
	    	   s2 = "";
	    	   i++;
	    	   j++;
	    	   
	       }
	       return 0;
	   }

	public static void main(String[] args) {
		
		System.out.println(compareVersion("1.1.0", "1.2.0"));
		
	}

}
