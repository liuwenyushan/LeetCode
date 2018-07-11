package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

 class TreeNode{//定义树结构
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val=x;
	}
}
public class Program {
	public static int lengthOfLongestSubstring(String s) {//最长不重复子串
        char []charArray=s.toCharArray();
        ArrayList<Character> temp=new ArrayList<Character>();
        int num=0;
        for(int i=0;i<charArray.length;i++){
            if(!temp.contains(charArray[i])){
                temp.add(charArray[i]);
                num++;
            } 
        } 
        return num;
    }
	public static int largestPalindrome(int n) {
        int maxNum=(int) (Math.pow(10,n)-1);
        int low=maxNum/10;
        for(int i=maxNum;i>low;i--){
        	long tem=createPalindrome(i);
        	for(long j=maxNum;j>low;j--){
        		if(tem/j>maxNum){
        			break;
        		}
        		if(tem%j==0){
        			return (int) (tem/1337);
        		}
        	}
        }

        return -1;
    }
	public static boolean isPalindrome(long n){//判断是否回文数
        long temp=0;
        long iNum=0;
        long num=n;
        while(num!=0){
            temp=num%10;
            iNum=iNum*10+temp;
            num=num/10;
        }
        if(iNum==n){
            return true;
        }
        else {
            return false;
        }
    }
	public static long createPalindrome(int n){//生成回文数
		long num=n;
		int temp;
		while(n!=0){
			temp=n%10;
			num=num*10+temp;
			n=n/10;
		}
		return num;
	}
	public static boolean isValid(String s) {//Valid Parentheses 
	        char[] sChar=s.toCharArray();
	        int sLength=sChar.length;
	        if(sLength%2==1)return false;
	        if(s.isEmpty())return true;
	        Stack<Character> sk = new Stack<Character>();
	        for(int i=0;i<s.length();i++){
	        	if(sk.isEmpty()){
	        		sk.push(sChar[i]);
	        		continue;
	        	}
	        	System.out.println("peek"+sk.peek()+"in"+sChar[i]);
	        	if(!match(sk.peek(),sChar[i])){
	        		sk.push(sChar[i]);
	        		continue;
	        	}
	        	if(match(sk.peek(),sChar[i])){
	        		sk.pop();
	        		continue;
	        	}
	        }
	        System.out.println(sk.toString());
	        if(sk.isEmpty()){
	        	return true;
	        }
	        return false;
	    }
	public static boolean match(char c1,char c2){//括号字符匹配

		 switch(c1){
		 case '(':
			 if(c2==')')return true;
			 else return false;
		case '[':
			if(c2==']')return true;
			 else return false;
		 case '{':
			 if(c2=='}')return true;
			 else return false;
		 default:
			 return false;
		 }
		
	 } 
	public static int removeDuplicates(int[] nums) {
		 LinkedList<Integer> l1=new LinkedList<Integer>();
		 for(int i=0;i<nums.length;i++){
			 if(!l1.contains(nums[i])){
				 l1.add(nums[i]);
			 }
		 }
		 System.out.println(l1.toString());
	        return l1.size() ;
	    }
	public static int  removeElement(int[] nums, int val) {//移除指定元素
        int count=nums.length;
        for(int i=0;i<nums.length&&count>i;i++){
            if(nums[i]==val){
                int temp=nums[count-1];
                nums[count-1]=val;
                nums[i]=temp;
                i--;
                count--;
            }
        }
//        for(int i=0;i<nums.length;i++)
//        System.out.print(nums[i]+"  ");
//        System.out.println("\n");
        return count;
    }
	public static int searchInsert(int[] nums, int target) {//插入元素
	        if(nums[0]>target||nums.length==0)return 0;
	        if(nums[nums.length-1]<target)return nums.length;
	        for(int i=0;i<nums.length-1;i++){
	            //if(nums[i]==target)return i;
	            if(nums[i]<=target&&nums[i+1]>target){
	                return i;
	            }
	        }
	        return 0;
	    }
	public static String countAndSay(int n) {
        String s1="1";
        if(n==1)return s1;
        String s=countAndSay(n-1);
        char[] sc=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<sc.length){
            int count=1;
            while(i!=sc.length-1&&sc[i+1]==sc[i]){
                count++;
                i++;
            }
            sb.append(count).append(sc[i]);
            i++;
        }
        return sb.toString();
        
    }
	public static int[] plusOne(int[] digits) {
	   boolean need=true;
       for(int i=0;i<digits.length;i++){
    	   if(digits[i]!=9){
    		   need=false;
    		   break;
    		   }
       }
       int l=digits.length;
       if(need==false){
    	   int[] n=new int[l];
    	   n[l-1]=digits[l-1]+1;
    	   for(int i=l-2;i>=0;i--){
    		   n[i]=n[i+1]/10+digits[i];
    		   n[i+1]=n[i+1]%10;
    	   }
    	   
    	   return n;
       }else{
    	   int[] n=new int[l+1];
    	   n[0]=1;
    	   for(int i=1;i<l;i++){
    		   n[i]=0;
    		   }
    	   return n;
       }
        
    }
	public static List<Integer> grayCode(int n){
		List<Integer> result=new ArrayList<Integer>();
		if(n==0){
			return null;
		}
		if(n==1){
			result.add(0);
			result.add(1);
			return result;
		}else{
			List<Integer> pre=grayCode(n-1);
			for(int i=0;i<pre.size();i++){
				result.add(pre.get(i));
			}
			for(int i=pre.size()-1;i>=0;i--){
				int p=pre.get(i)+(int)Math.pow(2, n-1);
				result.add(p);
			}
			return result;
		}
		
		
	}
	public static String longestCommonPrefix(String[] strs) {//求最长公共前缀字符串
		int n=strs.length;
		StringBuilder res=new StringBuilder();
		if(n==0)return "";
		
		for(int pos=0;pos<strs[0].length();pos++){
			for(int k=0;k<n;k++){
				if(strs[k].length()==pos||strs[k].charAt(pos)!=strs[0].charAt(pos))
					return res.toString();
			}
			res.append(strs[0].charAt(pos));
			
		}
		return res.toString();
		
    }
	public static TreeNode mergeTrees(TreeNode t1,TreeNode t2){//合并两棵二叉树
		if(t1==null)return t2;
		if(t2==null)return t1;
		TreeNode res=new TreeNode(t1.val+t2.val);
		res.left=mergeTrees(t1.left, t2.left);
		res.right=mergeTrees(t1.right, t2.right);
		return res;
	}
	public static List<Integer> findDisappearedNumbers(int[] nums) {
	        List<Integer> res=new ArrayList<Integer>();
	        for(int i=0;i<nums.length;i++){
	        	res.add(i+1);
	        }
	        for(int i=0;i<nums.length;i++){
	        	if(res.contains(new Integer(nums[i]))){
	        		res.remove(new Integer(nums[i]));
	        	}
	        }
	        return res;
	    }
	public static boolean isKeyRow(String word){//判断字符串是否为单行按键的集合
		boolean result1=true;
		boolean result2=true;
		boolean result3=true;
		Character[] f1={'q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P'};
        Character[] f2={'a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L'};
        Character[] f3={'z','x','c','v','b','n','m','Z','X','C','V','B','N','M'};
        
        List<Character> l1=Arrays.asList(f1);
        List<Character> l2=Arrays.asList(f2);
        List<Character> l3=Arrays.asList(f3);
        
        char[] c=word.toCharArray();
    	
    	for(char cc:c){
    		if(!l1.contains(cc)){
    			result1=false;
    		};
    	}
    	if(result1==true)return result1;
    	for(char cc:c){
    		if(!l2.contains(cc)){
    			result2=false;
    		};
    	}
    	if(result2==true)return result2;
    	for(char cc:c){
    		if(!l3.contains(cc)){
    			result3=false;
    		};
    	}
		return result3;
	}
	public static String[] findWords(String[] words) {
        
        List<String> res=new ArrayList<String>();
 
        for(String s:words){
        	if(isKeyRow(s))res.add(s);
        }
       
        String[] final_res=new String[res.size()];
        for(int i=0;i<res.size();i++){
        	final_res[i]=res.get(i);
        }
		return final_res;
    }
	public static void main(String[] args) {
		String[] test={"Hello", "Alaska", "Dad", "Peace"};
		String[] res=findWords(test);
		//List<String> resTest=new ArrayList<String>();
		for(String s : res)System.out.println(s);
		//System.out.println(res);
		
		}
	}


