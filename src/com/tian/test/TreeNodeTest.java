package com.tian.test;

import com.tian.treenode.TreeNode;
import com.tian.util.NodeTreeUtil;

public class TreeNodeTest {
	
public static void main(String[] args) throws Exception{
		
		new TreeNode(1, 0, 3, 0,true);
		
		System.out.println(NodeTreeUtil.getTreeNodes().size()) ;
		
		NodeTreeUtil.printListFormat(NodeTreeUtil.getTreeNodes());
		
	}

}
