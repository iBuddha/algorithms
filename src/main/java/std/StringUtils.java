package std;

public class StringUtils {
    public static String[] eachCharactor(String s) {
        String[] r = new String[s.length()];
        for(int i = 0; i < s.length(); i++){
            r[i] = s.substring(i, i+1);
        }
        return r;
    }

    public static String[] eachNonBlankOperator(String s){
        String nonBlank = s.replaceAll("\\s", "");
        return eachCharactor(nonBlank);
    }

}
