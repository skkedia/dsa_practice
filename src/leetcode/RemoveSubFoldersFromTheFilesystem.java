package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveSubFoldersFromTheFilesystem {

	public List<String> removeSubfolders(String[] folder) {
		Set<String> folders = new HashSet<>();
		for (String f : folder) {
			folders.add(f);
		}
		for (String f : folder) {
			boolean isSubFolder = true;
			String temp = f;
			while (isSubFolder) {
				int idx = temp.lastIndexOf("/");
				if (idx < 1) {
					break;
				}
				temp = f.substring(0, idx);
				if (folders.contains(temp)) {
					folders.remove(f);
					break;
				}
			}
		}
		List<String> ans = new ArrayList<>(folders);
		return ans;

	}

	public static void main(String[] args) {
		System.out.println(new RemoveSubFoldersFromTheFilesystem()
				.removeSubfolders(new String[] { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" }));
		System.out.println(
				new RemoveSubFoldersFromTheFilesystem().removeSubfolders(new String[] { "/a", "/a/b/c", "/a/b/d" }));
		System.out.println(new RemoveSubFoldersFromTheFilesystem()
				.removeSubfolders(new String[] { "/a/b/c", "/a/b/ca", "/a/b/d" }));
	}

}
