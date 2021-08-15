package com.wxj.codebaselearn.mianshi;

import java.util.ArrayList;
import java.util.List;

public class findTreeNode {

    //找到目标结点的步数
    int step = 0;
    //找到满足条件的结点的步数
    int kstep = 0;

    List list = new ArrayList();

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

   public Object[] findTreeVal(TreeNode root, TreeNode target, int k){
       int targetStep = findTargetStep(root, target, 0);
       List listNode = findTargetTreeNode(root, kstep, targetStep, k);

       return listNode.toArray();

   }

    public int findTargetStep(TreeNode node,TreeNode target,int step){

        if(node == null){
            return  step;
        }

        if(node.val == target.val){
            return step;
        }else{
            step++;
            findTargetStep(node.left,target,step);
            findTargetStep(node.right,target,step);
        }

        return step;
    }

    public List findTargetTreeNode(TreeNode node,int kstep, int step,int k ){

        if(Math.abs(step- kstep) == k){
//            return node;
            list.add(node.val);
        }else {
            kstep++;
            findTargetTreeNode(node.left,kstep,step,k);
            findTargetTreeNode(node.right,kstep,step,k);
        }
        return list;
    }
}
