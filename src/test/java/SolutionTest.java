package Solution20.java;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
public class SolutionTest {
	//由于源程序没有写当输入的数据不是符合标准的树时的错误情况，所以测试内容仅包含输入健康的树时的情况
		@Test
	    public void testFindMinHeightTrees() {
			Solution solution = new Solution();

	        // Test Case 1 返回一个节点，树： {{1, 0}, {1, 2}, {1, 3}}
	        int n1 = 4;
	        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
	        List<Integer> result1 = solution.findMinHeightTrees(n1, edges1);
	        List<Integer> expected1 = Arrays.asList(1);
	        assertEquals(expected1, result1);

	        // Test Case 2  返回两个节点，树：{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}
	        int n2 = 6;
	        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
	        List<Integer> result2 = solution.findMinHeightTrees(n2, edges2);
	        List<Integer> expected2 = Arrays.asList(3, 4);
	        assertEquals(expected2, result2);

	       // Test Case 3: 仅有一个节点，只有节点0
	        int n3 = 1;
	        int[][] edges3 = {}; 
	        List<Integer> result3 = solution.findMinHeightTrees(n3, edges3);
	        List<Integer> expected3 = Collections.singletonList(0); 
	        assertEquals(expected3, result3);
	    }


		@Test
	    public void testFindLongestNode() {
			Solution solution = new Solution();

	        // Test Case 1 有岔路，且两条路距离相等 树：{{0，1}，{1，2}，{1，3}}
	        int n1 = 4;
	        List<Integer>[] adj1 = new List[n1];
	        for (int i = 0; i < n1; i++) {
	            adj1[i] = new ArrayList<Integer>();
	        }
	        adj1[0].add(1);
	        adj1[1].add(0);
	        adj1[1].add(2);
	        adj1[2].add(1);
	        adj1[1].add(3);
	        adj1[3].add(1);

	        int[] parent1 = new int[n1];
	        Arrays.fill(parent1, -1);

	        int result1 = solution.findLongestNode(0, parent1, adj1);
	        assertEquals(3, result1);

	     // Test Case 2 有岔路，但两条路不等  树：{{0，1}，{1，2}，{1，3}，{2，4}}
	        int n = 5;
	        List<Integer>[] adj = new List[n];
	        for (int i = 0; i < n; i++) {
	            adj[i] = new ArrayList<Integer>();
	        }
	        adj[0].add(1);
	        adj[1].add(0);
	        adj[1].add(2);
	        adj[1].add(3);
	        adj[2].add(1);
	        adj[2].add(4);
	        adj[3].add(1);
	        adj[4].add(2);

	        int[] parent = new int[n];
	        Arrays.fill(parent, -1);

	        int result = solution.findLongestNode(0, parent, adj);
	        assertEquals(4, result);
	        
	        // Test Case 3 一条直线 树：{{0，1}，{1，2}，{2，3}，{3，4}}
	        int n2 = 5;
	        List<Integer>[] adj2 = new List[n2];
	        for (int i = 0; i < n2; i++) {
	            adj2[i] = new ArrayList<Integer>();
	        }
	        adj2[0].add(1);
	        adj2[1].add(0);
	        adj2[1].add(2);
	        adj2[2].add(1);
	        adj2[2].add(3);
	        adj2[3].add(2);
	        adj2[3].add(4);
	        adj2[4].add(3);

	        int[] parent2 = new int[n2];
	        Arrays.fill(parent2, -1);

	        int result2 = solution.findLongestNode(0, parent2, adj2);
	        assertEquals(4, result2);

	    }
}