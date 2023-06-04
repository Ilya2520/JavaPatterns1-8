package yand;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static long find(String s,char e) {
        return s.chars().filter(c->c==e).count();
    }

    public static String removeDuplicates(String input){
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if(!result.contains(String.valueOf(input.charAt(i)))) {
                result += String.valueOf(input.charAt(i));
            }
        }
        return result;
    }
    public static String word(String w) {
        if(w.length()!=1) {
            return w + " " + word(w.substring(0, w.length()-1 )) + " " + word(w.substring(1, w.length()));
        }
        else
            return w;
    }
    public static void main(String[] args) {
        Scanner a=new Scanner(System.in);
        String b=a.nextLine();
        String bc=word(b);
        System.out.println(bc);
        String[] sp=bc.split(" ");
        Set<String> st=new HashSet<>();
        String cv=removeDuplicates(b);

        for(String wrd:sp){
            st.add(wrd);
        }
        String l="";
        for(String acc:st){
            l+=acc;
        }
        for(int i=0;i<cv.length();i++){
            System.out.println(cv.charAt(i)+": "+find(l,cv.charAt(i)));
        }
    }
}
