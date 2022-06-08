/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class HelloGoodbye {
    public static void main(String[] args) {
        System.out.printf("Hello " + String.join(" and ", args) + ".\r\n");

        String[] newArgs = new String[args.length];

        for (int i = args.length - 1; i >=0; i--) {
            newArgs[args.length - i -1] = args[i];
        }

        System.out.printf("Goodbye " + String.join(" and ", newArgs) + ".");
    }
}
