import java.util.ArrayList;
import java.util.HashMap;
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


}
