/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class HelloGoodbye {
    public static void main(String[] args) {
        System.out.printf("Hello " + String.join(" and ", args) + ".\r\n");
        System.out.printf("Goodbye " + args[1] + " and " + args[0] + ".");
    }
}
