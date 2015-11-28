package com.tian.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.tian.treenode.TreeNode;

public class NodeTreeUtil {
	
	public static ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();

	public static ArrayList<TreeNode> getTreeNodes() {
		
		if(treeNodes == null){
			return new ArrayList<TreeNode>();
		}
		return treeNodes;
	}

	public static void setTreeNodes(TreeNode treeNode) {
		
		NodeTreeUtil.getTreeNodes().add(treeNode);
	}

	
	/**
	 * 读取文件内容，封装nodeList
	 * @param fileName
	 * @author:Tian_dd
	 * @blog: tian-dd.top
	 */
	public static ArrayList<TreeNode> readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {

			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();

			while ((tempString = reader.readLine()) != null) {
				String[] strings = tempString.split(",");
				TreeNode treeNode = new TreeNode();
				treeNode.setSelfId(Integer.parseInt(strings[0]));
				treeNode.setParentId(Integer.parseInt(strings[1]));
				treeNode.setChildId(Integer.parseInt(strings[2]));
				treeNode.setDepth(Integer.parseInt(strings[3]));
				treeNode.setExpand(Boolean.parseBoolean(strings[4]));
				treeNodes.add(treeNode);
			}
			
			reader.close();
			return treeNodes;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return null;
	}

	public static ArrayList<TreeNode> getNodeList() {

		ArrayList<TreeNode> treeNodes = readFileByLines(
				"/Users/tianduoduo/Documents/workspace/TreeNode/src/com/tian/resource/source.txt");

		return treeNodes;
	}
	
	public static ArrayList<TreeNode> initNodeTree(){
		return new ArrayList<TreeNode>();
	}

	/**
	 * 获取相同父节点的节点
	 * @param selfId
	 * @author:Tian_dd
	 * @blog: tian-dd.top
	 */
	public static ArrayList<TreeNode> getTreeNodesById(int selfId) {

		ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();

		ArrayList<TreeNode> totalNodeS = NodeTreeUtil.getNodeList();

		for (TreeNode treeNode : totalNodeS) {
			if (treeNode.getParentId() == selfId) {
				treeNodes.add(treeNode);
			}
		}

		return treeNodes;

	}

/**
 * 打印结构
 * @param treeNodes
 * @author:Tian_dd
 * @blog: tian-dd.top
 */
	public static void printListFormat(ArrayList<TreeNode> treeNodes){
		
		Collections.sort(treeNodes);
		
		for (TreeNode treeNode : treeNodes) {
			System.out.print(treeNode.getSelfId() + "==");
			System.out.print(treeNode.getParentId() + "==");
			System.out.print(treeNode.getChildId() + "==");
			System.out.print(treeNode.getDepth() + "==");
			System.out.println(treeNode.isExpand());
			
		}
		
	}
}
