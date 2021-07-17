import java.util.Stack;

public class SimplifyPath71 {
    public static String simplifyPath(String path) {
        Stack<String> stack  = new Stack<>();
        String[] components = path.split("/");

        for(String directory : components){
            if(directory.equals(".") || directory.isEmpty()){
                continue;
            }else if(directory.equals("..")){
                if(!stack.isEmpty())
                stack.pop();
            }else{
                stack.add(directory);
            }
        }

        StringBuilder res = new StringBuilder();
        for(String dir : stack){
            res.append("/");
            res.append(dir);
        }
        return res.length() > 0 ? res.toString() : "/";
    }

    public static void main(String[] args) {
        String s=  "/a/./b/../../c/";
        String a;
        a = simplifyPath(s);
        System.out.println(a);
    }
}
