package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {

	class Twitter {
		private Map<Integer, LinkedList<int[]>> userTweets;
		private Map<Integer, Set<Integer>> followers;
		private int timestamp;

		public Twitter() {
			userTweets = new HashMap<>();
			followers = new HashMap<>();
			timestamp = 0;
		}

		public void postTweet(int userId, int tweetId) {
			userTweets.putIfAbsent(userId, new LinkedList<>());
			userTweets.get(userId).addFirst(new int[] { tweetId, timestamp++ });
			followers.putIfAbsent(userId, new HashSet<>());
			followers.get(userId).add(userId);
		}

		public List<Integer> getNewsFeed(int userId) {
			List<Integer> newsFeed = new ArrayList<>();
			Set<Integer> following = followers.getOrDefault(userId, new HashSet<>());
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
			for (int followeeId : following) {
				LinkedList<int[]> tweets = userTweets.getOrDefault(followeeId, new LinkedList<>());
				for (int[] tweet : tweets) {
					pq.offer(tweet);
				}
			}
			int count = 0;
			while (!pq.isEmpty() && count < 10) {
				newsFeed.add(pq.poll()[0]);
				count++;
			}
			return newsFeed;
		}

		public void follow(int followerId, int followeeId) {
			if (followerId != followeeId) {
				followers.putIfAbsent(followerId, new HashSet<>());
				followers.get(followerId).add(followeeId);
			}
		}

		public void unfollow(int followerId, int followeeId) {
			if (followerId != followeeId) {
				Set<Integer> following = followers.getOrDefault(followerId, new HashSet<>());
				following.remove(followeeId);
			}
		}
	}

	public static void main(String[] args) {
		Twitter twitter = new DesignTwitter().new Twitter();
		twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
		twitter.getNewsFeed(1); // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
		twitter.follow(1, 2); // User 1 follows user 2.
		twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
		twitter.getNewsFeed(1); // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id
								// 6 should precede tweet id 5 because it is posted after tweet id 5.
		twitter.unfollow(1, 2); // User 1 unfollows user 2.
		twitter.getNewsFeed(1); // User 1's news feed should return a list with 1 tweet id -> [5], since user 1
								// is no longer following user 2.

	}

}
