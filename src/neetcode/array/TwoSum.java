package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		int[] arr = new int[2];
		Map<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(hm.get(target - nums[i]) != null) {
				return new int[] {hm.get(target - nums[i]), i};
			}
			hm.put(nums[i], i);
		}
		return arr;
        
    }

}
