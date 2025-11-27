import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFactorization {

    public static ArrayList<Integer> primeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();

        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number to factorize: ");
            int num = scanner.nextInt();
            ArrayList<Integer> result = primeFactors(num);

            System.out.println("Prime factors of " + num + ": " + result);
        }
    }
}
