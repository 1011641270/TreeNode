package com.tian.treenode;

import java.util.ArrayList;
import com.tian.util.NodeTreeUtil;

public class TreeNode implements Comparable<TreeNode> {

	private int selfId;
	private int parentId;
	private int childId;
	private int depth = 0; // 默认深度为0
	private boolean expand = true;

	public TreeNode() {
		super();
	}

	public TreeNode(int selfId, int parentId, int childId, int depth, boolean expand) {

		this.selfId = selfId;
		this.parentId = parentId;
		this.childId = childId;
		this.depth = depth;

		if (expand) {

			ArrayList<TreeNode> nodeS = null;
			nodeS = NodeTreeUtil.getTreeNodesById(selfId); // 根据ID获取节点

			for (TreeNode treeNode : nodeS) {

				if (this.childId == -1) {
					NodeTreeUtil.setTreeNodes(new TreeNode(treeNode.getSelfId(), treeNode.getParentId(),
							treeNode.getChildId(), depth + 1, false));
				} else {
					NodeTreeUtil.setTreeNodes(new TreeNode(treeNode.getSelfId(), treeNode.getParentId(),
							treeNode.getChildId(), depth + 1, true));
				}

			}

		}

	}

	public int getSelfId() {
		return selfId;
	}

	public void setSelfId(int selfId) {
		this.selfId = selfId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public boolean isExpand() {
		return expand;
	}

	public void setExpand(boolean expand) {
		this.expand = expand;
	}

	@Override
	public int compareTo(TreeNode o) {

		if (this.depth > o.getDepth()) {
			return (this.selfId - o.getSelfId());
		}
		if (this.depth < o.getDepth()) {
			return (this.depth - o.getDepth());
		}

		return 0;
	}

}
