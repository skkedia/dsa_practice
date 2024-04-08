package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(Integer i : nums) {
            if(!hs.add(i)) {
                return true;
            }
        }
        return false;
    }

}
