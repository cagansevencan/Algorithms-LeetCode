public class SimplifyPath71 {
    public static String simplifyPath(String path) {
        int j = path.lastIndexOf("/");
        int i = path.lastIndexOf("/", j-1) ;

        String newPath;
        newPath = path.substring(i, j);

        String lastString = newPath.replace("..", "");

        return lastString;
    }

    public static void main(String[] args) {
        String s=  "/../";
        String a;
        a = simplifyPath(s);
        System.out.println(a);
    }
}
