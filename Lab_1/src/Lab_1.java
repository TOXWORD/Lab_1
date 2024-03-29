import java.text.DecimalFormat;
import java.util.Scanner;

class Taylor{

    double x = 0;
    int k = 0;

    Taylor(){

    }

    double countArctg(){

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter x (-1; 1): ");
            x = Double.parseDouble(sc.next());

            if(x <= -1 || x >= 1){
                throw new NumberFormatException();
            }

            System.out.print("Enter k: ");
            k = Integer.parseInt(sc.next());

        double eps = Math.pow(10, -k);
        double res = x;
        int powerer = 3;
        double ter = -1 * Math.pow(x, powerer) / powerer;

        while(Math.abs(ter) > eps){
            res += ter;
            powerer += 2;
            ter = -1 * ter / Math.abs(ter) * Math.pow(x, powerer) / powerer;
        }

        return res;
        }
        catch (NumberFormatException e){
            throw new NumberFormatException();
        }
    }

}

public class Lab_1 {
    public static void main(String[] args) {
        try {

            Taylor t = new Taylor();
            DecimalFormat df = new DecimalFormat("#.###");
            System.out.println("Counted by handwritten code: " + df.format(t.countArctg()));
            System.out.println("Counted by Math library: " + df.format(Math.atan(t.x)));

        }
        catch (NumberFormatException e){
            System.out.println("Incorrect input!");
        }
    }
}
