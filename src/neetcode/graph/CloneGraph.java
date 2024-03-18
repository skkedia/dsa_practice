package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
	public int val;
	public List<Node> neighbors;
	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraph {

	public Node cloneGraph(Node node) {
		if(node == null) {
			return null;
		}

		Map<Node, Node> mp = new HashMap<>();
		mp.put(node, new Node(node.val, new ArrayList<>()));

		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(Node neigh : cur.neighbors) {
				if(!mp.containsKey(neigh)) {
					mp.put(neigh, new Node(neigh.val, new ArrayList<>()));
					q.add(neigh);
				}
				mp.get(cur).neighbors.add(mp.get(neigh));
			}
		}
		return mp.get(node);
	}
}
