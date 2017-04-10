import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by eric on 2017/2/23.
 */
public class Main {
    public static void main(String[] args) throws Exception{

		Main test = new Main();
//        test.reverse("I am a coder");
//        test.findComplement(5);
//        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
//        System.out.println(test.findWords(words));
//        test.StringBuilderVSString();
		test.test();
	}



    public void test() throws Exception{
        Map map = new HashMap();
        int[] a = {};
        System.out.println(a.length);
        Double d = Double.parseDouble(".1");
        System.out.println(d);
        BigDecimal b = new BigDecimal(d);

    }


	/**
	 * 逆序输出str
	 * @param str
	 */
	public void reverse(String str){
//        String[] str1 = str.split(" ");
		String[] str1 = str.split(" ");
		for(String s:str1){
			System.out.print(s+" ");
		}
		System.out.println("");

		for(int i = str1.length-1; i>=0; i--){
			System.out.print(str1[i]+" ");
		}
		System.out.println("");
	}

	/** 将int所有bit位翻转输出
	 *
	 * @param num
	 */
	public void findComplement(int num) {
		int l = 0;
		int a = num;
		while((a>>1) > 0){
			++l;
			a = a>>1;
		}
		System.out.println(num^((1<<(l+1))-1));
	}

	/**
	 * 给定一组string，找出可以在string中所有字母均在键盘同一行的string
	 * @param words
	 */
	public String[] findWords(String[] words) {
		Map<Character,Integer> map = new HashMap<>();
		map.put('q',1);map.put('w',1);map.put('e',1);map.put('r',1);map.put('t',1);
		map.put('y',1);map.put('u',1);map.put('i',1);map.put('o',1);map.put('p',1);
		map.put('Q',1);map.put('W',1);map.put('E',1);map.put('R',1);map.put('T',1);
		map.put('Y',1);map.put('U',1);map.put('I',1);map.put('O',1);map.put('P',1);

		map.put('a',2);map.put('s',2);map.put('d',2);map.put('f',2);map.put('g',2);
		map.put('h',2);map.put('j',2);map.put('k',2);map.put('l',2);
		map.put('A',2);map.put('S',2);map.put('D',2);map.put('F',2);map.put('G',2);
		map.put('H',2);map.put('J',2);map.put('K',2);map.put('L',2);

		map.put('z',3);map.put('x',3);map.put('c',3);map.put('v',3);map.put('b',3);
		map.put('n',3);map.put('m',3);
		map.put('Z',3);map.put('X',3);map.put('C',3);map.put('V',3);map.put('B',3);
		map.put('N',3);map.put('M',3);

		List<String> list = new ArrayList<>();

		for(String word:words){
			int l = word.length();
			int k = map.get(word.charAt(0));
			if( l == 1){//只有一个字符，符合
				list.add(word);
			}else{
				int i = 1;
				boolean inLine = true;
				boolean e = true;
				while(i<l){
					e = map.get(word.charAt(i))==k;
					if(!e){
						inLine = false;
						break;
					}
					i++;
				}
				if(inLine){
					list.add(word);
				}
			}
		}

		String[] strings = {};

		int size = list.size();
		if(size != 0){
			strings = list.toArray(new String[size]);
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		return strings;
	}

	/**
	 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
	 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
	 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
	 * If it does not exist, output -1 for this number.
	 * @param findNums
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		if(null == findNums || null == nums){
			return new int[0];
		}

		int size = findNums.length;
		int sizeB = nums.length;
		int[] result = new int[size];

		Map<Integer,Integer> map = new LinkedHashMap<>();
		int index = 0;
		for(int n:nums){
			map.put(n,index);
			index++;
		}

		List<Integer> list = new ArrayList<>();
		index = 0;
		for(int n: findNums){
			result[index] = -1;
			if(null != map.get(n)) {
				int indexB = map.get(n);

				while (indexB < sizeB) {
					if (nums[indexB] > n) {
						result[index] = nums[indexB];
						break;
					}
					indexB++;
				}
			}
			index++;
		}
		return result;
	}

	/**
	 * Write a program that outputs the string representation of numbers from 1 to n.
	 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
	 *For numbers which are multiples of both three and five output “FizzBuzz”.
	 * @param n
	 * @return
	 */
	public List<String> fizzBuzz(int n) {
		List<String> list = new LinkedList<>();
		String s1 = "Fizz";
		String s2 = "Buzz";
		String s3 = "FizzBuzz";

		if(n<1){
			list = null;
		}else{
			for(int k = 1; k<=n; k++){
				if(0==k%3 && 0!=k%5){
					list.add(s1);
				}
				if(0!=k%3 && 0==k%5){
					list.add(s2);
				}
				if(0==k%3 && 0==k%5){
					list.add(s3);
				}
				if(0!=k%3 && 0!=k%5){
					list.add(String.valueOf(k));
				}
			}
		}
		return list;
	}

	/**
	 * Write a function that takes a string as input and returns the string reversed.
	 * Example:
	 * Given s = "hello", return "olleh".
	 * @param s
	 * @return
	 */
	public String reverseString(String s) {
		if(null == s || s.isEmpty()){
			return "";
		}
		int l = s.length();
		StringBuilder sb = new StringBuilder();

		for(int n=l-1;n>=0;n--){
			sb.append(s.charAt(n));
		}
		return new String(sb);
	}

	/**
	 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
	 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
	 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1.
	 * The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
	 * @param grid
	 * @return
	 */
	public int islandPerimeter(int[][] grid) {
		int result = 0;
		int d1 = grid.length;
		if(d1 == 0){
			return 0;
		}
		int d2 = grid[0].length;

		for(int a=0;a<d1;a++){
			result += grid[a][0]^0;
			for(int b=0;b<d2-1;b++){
				if(d2>1){
					result += grid[a][b]^grid[a][b+1];
				}
			}
			result += grid[a][d2-1]^0;
		}
		for(int b=0;b<d2;b++){
			result += grid[0][b]^0;
			for(int a=0;a<d1-1;a++){
				if(d1>1){
					result += grid[a][b]^grid[a+1][b];
				}
			}
			result += grid[d1-1][b]^0;
		}
		return result;
	}


	/**
	 *Given a binary array, find the maximum number of consecutive 1s in this array.
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		if(null == nums || nums.length == 0){
			return 0;
		}

		int largest = 0;
		int r = 0;
		for(int n:nums){
			if(n==1){
				r += 1;
				if(r>largest){
					largest = r;
				}
			}else{
				r = 0;
			}
		}
		return largest;
	}


	/**
	 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
	 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
	 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
	 * @param n
	 * @return
	 */
	public boolean canWinNim(int n) {
		if(n%4==0){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * Given a word, you need to judge whether the usage of capitals in it is right or not.

	 We define the usage of capitals in a word to be right when one of the following cases holds:

	 All letters in this word are capitals, like "USA".
	 All letters in this word are not capitals, like "leetcode".
	 Only the first letter in this word is capital if it has more than one letter, like "Google".
	 Otherwise, we define that this word doesn't use capitals in a right way.
	 * @param word
	 * @return
	 */
	public boolean detectCapitalUse(String word) {
		if(null == word || word.isEmpty()){
			return false;
		}
		if(word.length() == 1){
			return true;
		}

		int l = word.length();
		boolean result = true;
		if(word.charAt(0)>='A'&& word.charAt(0)<='Z' && word.charAt(1)>='A' && word.charAt(1)<='Z'){
			int index = 2;
			while(index < l){
				if(word.charAt(index)<'A' || word.charAt(index)>'Z'){
					result = false;
					break;
				}
				index++;
			}
			return result;
		}

		if(word.charAt(0)>='A'&& word.charAt(0)<='Z' && word.charAt(1)>='a'&& word.charAt(1)<='z'){
			int index = 2;
			while(index < l){
				if(word.charAt(index)<'a' || word.charAt(index)>'z'){
					result = false;
					break;
				}
				index++;
			}
			return result;
		}

		if(word.charAt(0)>='a'&&word.charAt(0)<='z'){
			int index = 1;
			while(index < l){
				if(word.charAt(index)<'a' || word.charAt(index)>'z'){
					result = false;
					break;
				}
				index++;
			}
			return result;
		}
		return false;
	}


	/**
	 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
	 * Find all the elements of [1, n] inclusive that do not appear in this array.
	 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> list = new LinkedList<>();

		//通过数字本身负代表是否已经有了
		for (int i = 0; i < nums.length; i++) {
			int absIndex = nums[i]>=0? nums[i]- 1:-nums[i]- 1;
			nums[absIndex] = (nums[absIndex] > 0) ? -nums[absIndex] : nums[absIndex];
		}
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] > 0) {
				list.add(index);
			}
		}
		return list;
	}

	/**
	 * Given an array of integers, every element appears twice except for one. Find that single one.

	 Note:
	 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		int r = 0;
		//与0异或===自己，与1异或===取反
		//与自己异或===0；
		for(int n=0;n<nums.length;n++){
			r ^= nums[n];
		}
		return r;
	}



	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	/**
	 * Given a binary tree, find its maximum depth.
	 */
	public int maxDepth(TreeNode root) {
		if(null == root){
			return 0;
		}
		return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
	}


	/**
	 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSum(int a, int b) {
		if(b == 0){
			return a;
		}
		int r = a ^ b; //无进位
		int j = (a & b)<<1;//进位部分
		return getSum(r,j);
	}

	/**
	 * Given two strings s and t which consist of only lowercase letters.
	 String t is generated by random shuffling string s and then add one more letter at a random position.
	 Find the letter that was added in t.
	 * @param s
	 * @param t
	 * @return
	 */
	public char findTheDifference(String s, String t) {
		Character[] cs = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
				'u','v','w','x','y','z'};

		Character s1 = null;
		if(null == s || s.isEmpty()){
			s1 = t.charAt(0);
		}

		Integer r = 0;
		int index = 0;
		while(index < s.length()){
			r ^= (s.charAt(index)-'a');
			index++;
		}
		index = 0;
		while(index < t.length()){
			r ^= (t.charAt(index)-'a');
			index++;
		}
		s1 = cs[r];
		return s1;
	}

	/**
	 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

	 For example:

	 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	 * @param num
	 * @return
	 */
	public int addDigits(int num) {
		return num==0?0:(num%9==0?9:(num%9));
	}

	/**
	 * For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

	 1. The area of the rectangular web page you designed must equal to the given target area.

	 2. The width W should not be larger than the length L, which means L >= W.

	 3. The difference between length L and width W should be as small as possible.
	 * @param area
	 * @return
	 */
	public int[] constructRectangle(int area) {
		if(area<=0){
			return new int[2];
		}
		double l = Math.sqrt(area);
		int[] r = new int[2];
		int i = (int)l;
		while(i<=l && i>=1){
			int k = area%i;
			if(k == 0){
				r[0] = area/i;
				r[1] = i;
				break;
			}
			i--;
		}
		return r;

	}


	/**
	 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

	 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) return;

		int insertPos = 0;
		for (int num: nums) {
			if (num != 0) nums[insertPos++] = num;
		}

		while (insertPos < nums.length) {
			nums[insertPos++] = 0;
		}
	}

	/**
	 * 通过对string和StringBuilder类进行1亿次测试得到：
	 * 不清空变量，连续追加一亿次，StringBuilder会明显优于String
	 * 但是每次都是清空的来开，一亿次才差0.6秒。
	 */
	public void StringBuilderVSString(){
		Long l1 = System.currentTimeMillis();
		int index = 0;
		int end = 10000 * 10000;
		String s = "";
		StringBuilder sb =new StringBuilder();
		for(int i = 0; i < end; i++){
			s += "1";
//            sb.append("1");
			if(i%(end/10) == 0){
				System.out.println("doing index : " + i);
			}
			s = "";
		}
		Long l2 = System.currentTimeMillis();
		for(int i = 0; i < end; i++){
//            s += "1";
			sb.append("1");
			if(i%(end/10) == 0){
				System.out.println("doing index : " + i);
			}
			sb.delete(0,sb.length());
		}
		Long l3 = System.currentTimeMillis();

		System.out.println("String time : " + (l2 - l1));
		System.out.println("StringBuilder time : " + (l3 - l2));
	}



    /**
     * Given a string, sort it in decreasing order based on the frequency of characters.
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if(null == s || s.isEmpty()){
            return "";
        }
        String str = "";
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            Integer k = map.get(s.charAt(i));
            if(null == k){
                k = 0;
            }
            map.put(c,k+1);
        }

		return str;
	}


}
