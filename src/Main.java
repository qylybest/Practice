import com.sun.tools.jdi.LinkedHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by eric on 2017/2/23.
 */
public class Main {
    public static void main(String[] args) {

        Main test = new Main();
//        test.reverse("I am a coder");
//        test.findComplement(5);
//        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
//        System.out.println(test.findWords(words));
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

        Map<Integer,Integer> map = new LinkedHashMap();
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

}
