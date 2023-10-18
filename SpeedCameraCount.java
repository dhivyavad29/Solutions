import java.util.Arrays;

public class SpeedCameraCount {
   public static int solution(String S) {
    int c = 0;
    int[] l = new int[S.length()];
    
    for (int i = 0; i < S.length(); i++) {
        if (S.charAt(i) == '.') {
            c++;
        }
        l[i] = c;
    }

    System.out.println(String.join(", ", Arrays.stream(l).mapToObj(Integer::toString).toArray(String[]::new)));

    c = 0;
    int[] r = new int[S.length()];
    
    for (int i = S.length() - 1; i >= 0; i--) {
        if (S.charAt(i) == '.') {
            c++;
        }
        r[i] = c;
    }

    System.out.println(String.join(", ", Arrays.stream(r).mapToObj(Integer::toString).toArray(String[]::new)));

    c = 0;
    
    for (int i = 0; i < S.length(); i++) {
        if (S.charAt(i) == '<') {
            c += l[i];
        } else if (S.charAt(i) == '>') {
            c += r[i];
        }
    }
    return c;
}


    public static void main(String[] args) {
        String input = ".>...";
        int cameraCount = solution(input);
        System.out.println("Number of speed cameras passed: " + cameraCount);
    }
}
