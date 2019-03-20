import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double startingX;
        int k;
        double alpha;
        double epsX;
        double epsF;
        
        System.out.println("Please enter X: ");
        startingX = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter K: ");
        k = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter alpha: ");
        alpha = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter epsX");
        epsX = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter epsF");
        epsF = Double.parseDouble(scanner.nextLine());

        functionExample(startingX, k, alpha, epsX, epsF);
    }
    
    public static void functionExample(double startingX, int k, double alpha, double epsX, double epsF) {

        double gradF;
        double lastX = 0;
        int counter = 0;
        
        while(counter < 100000) {
            gradF = (10 * startingX + 1) / (2 * Math.sqrt(5 * startingX * startingX) + startingX + 6) + 
            3 / (2 * Math.sqrt(3 * startingX + 7));
            
            mainFunction(lastX);
            
            lastX = startingX;
            startingX = startingX - alpha * gradF;
            counter++;
            
            if(Math.abs(lastX - startingX) < epsX) {
                break;
            }
            
            if(Math.abs(mainFunction(startingX) - mainFunction(lastX)) < epsF) {
                break;
            }
        }
        
        System.out.printf("Fmin = %f%n", mainFunction(lastX));
        System.out.printf("Xmin= %f%n", lastX);
        System.out.printf("Kmin= %d%n", counter);
    }
    
        public static double mainFunction(double lastX) {
            return Math.sqrt((5 * lastX * lastX) + lastX + 6) + Math.sqrt(3 * lastX + 7);
        }        
}