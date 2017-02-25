/**
 * Created by eric on 2017/2/23.
 */
public class Main {
    public static void main(String[] args) {

        Main test = new Main();
//        test.reverse("I am a coder");
//        test.findComplement(5);
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

}
