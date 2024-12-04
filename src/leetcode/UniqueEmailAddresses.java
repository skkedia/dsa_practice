package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

	public int numUniqueEmails(String[] emails) {
		int ans = 0;
		Set<String> hs = new HashSet<>();
		for (String email : emails) {
			if (!hs.contains(email)) {
				String[] at = email.split("@");
				at[0] = at[0].substring(0, at[0].indexOf('+'));
				at[0] = at[0].replace(".", "");
				if (hs.add(new StringBuilder().append(at[0]).append("@").append(at[1]).toString())) {
					ans++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new UniqueEmailAddresses()
				.numUniqueEmails(new String[] { "test.email+alex@leetcode.com", "test.email.leet+alex@code.com" }));
	}

}
