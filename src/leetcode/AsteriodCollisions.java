package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class AsteriodCollisions {

	public int[] asteroidCollision(int[] asteriods) {
		Stack<Integer> stk = new Stack<>();
		for (Integer asteriod : asteriods) {
			if (asteriod > 0) {
				stk.push(asteriod);
			} else {
				while (!stk.empty() && stk.peek() > 0 && stk.peek() < -asteriod) {
					stk.pop();
				}
				if (stk.isEmpty() || stk.peek() < 0)
					stk.push(asteriod);
				if (stk.peek() == -asteriod)
					stk.pop();
			}
		}
		int[] ans = new int[stk.size()];
		int i = stk.size() - 1;
		while (!stk.empty()) {
			ans[i--] = stk.pop();
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new AsteriodCollisions().asteroidCollision(new int[] { 10, 2, -5 })));
	}

}

//Q1.There are
//n different
//events.You are
//given an
//array of pairs[duration_i,lastDay_i].
//The ith
//event will
//need continuos"duration_i"
//days to
//complete once
//started and
//must be
//finished before"lastday_i"
//
//You will
//start on the 1
//st day
//and you
//cannot attend
//two or
//more events
//simultaneously.
//
//		Return the
//maximum number
//of event
//that you
//can attend.
//
//Example:
//
//Input:events=[[100,200],[200,1300],[1000,1250],[2000,3200]]Output:3
//
//First,
//attend the 1st event, it requires 100
//days so
//you will
//finish it
//on the 100
//th day, and
//ready to
//attent the
//next event
//on the 101st day.Second,
//attend the 3rd event, it requires 1000
//days so
//you will
//finish it
//on the 1100
//th day, and
//ready to
//attend the
//next event
//on the 1101st day.Third,
//attend the 2nd event, it requires 200
//days so
//you will
//finish it
//on the 1300th day.
//
//Input:events=[[100,200],[200,1300],[1000,1250],[2000,3200]]Output:3

///**    
// *      TC - nlogn + n 
// *      SC - logn + C
// *      d = 0
// *      100, 200   d = 100, no = 1
// *      1000, 1250 d = 1100, no = 2
// *      200, 1300  d = 1300, no = 3
// *      2000, 3200 d = 1300, no = 3
// *      500, 4700  d = 1800, no = 4
// * 
// * 
// *      [[100,200],[500,1300],[1100,1250],[2000,3000]]
// *      d = 0
// *      100, 200    d = 100 no = 1  pq = 100
// *      1100, 1250  d = 1200 no = 2 pq = 1100, 100
// *      500, 1300   d = 1200 no = 2 pq = 
// *      2000, 3000  d = 3200 no = 2 
// *      
// *      100, 200    d = 100 no = 1
// *      500, 1300   d = 
// *      1100, 1250  d = 1200 no = 2
// *      2000, 3000  d = 3200 no = 2
// * 
// *      
// *      
// *      pq = 
// *      
// *      int max = 3000;
// *      dp[0][] = 
// * 
// * 
// * 
// * 
// * 
// * 
// * 
// * 
// * 
// * 
// * 
// * 
// * 
// * 
// * 
// * [[100,200],[500,1300],[1100,1250],[2000,3000]]
// * /