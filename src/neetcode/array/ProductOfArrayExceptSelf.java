package array;

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int[] prefix = new int[nums.length];
		prefix[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			prefix[i] = prefix[i - 1] * nums[i];
		}

		int[] postfix = new int[nums.length];
		postfix[nums.length - 1] = nums[nums.length - 1];
		for(int i = nums.length - 1; i > 0; i--) {
			postfix[i - 1] = nums[i - 1] * postfix[i];
		}

		for(int i = 0; i < nums.length; i++) {
			int pre = 1;
			int post = 1;
			if(i - 1 >= 0) {
				pre = prefix[i - 1];
			}
			if(i + 1 < nums.length) {
				post = postfix[i + 1];
			}
			nums[i] = pre * post;
		}
		return nums;
	}

	public int[] productExceptSelfV2(int[] nums) {
		int[] result = new int[nums.length];
		int prefix = 1;
		for(int i = 0; i < nums.length; i++) {
			result[i] = prefix;
			prefix = prefix * nums[i];
		}

		int postfix = 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			result[i] *= postfix;
			postfix *= nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		new ProductOfArrayExceptSelf().productExceptSelf(new int[] {1,2,3,4});
		new ProductOfArrayExceptSelf().productExceptSelfV2(new int[] {-1,1,0,-3,3});
	}

}
