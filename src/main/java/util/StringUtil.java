package util;

public class StringUtil {
    public static Boolean isNotBlank(String var){
        if(var == null || "".equals(var)){
            return false;
        }
        return true;
    }
}
