import java.util.ArrayList;
import java.util.Scanner;

public class GCDandLCM {

    // method 1: using euclidean algorithm
    public static int gcdEuclidean(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcmEuclidean(int a, int b) {
        return (a * b) / gcdEuclidean(a, b);
    }

    // method 2: using prime factorization
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

    public static int gcdPrimeFactorization(int a, int b) {
        ArrayList<Integer> factorsA = primeFactors(a);
        ArrayList<Integer> factorsB = primeFactors(b);

        int gcd = 1;

        // find common prime factors
        for (int i = 0; i < factorsA.size(); i++) {
            for (int j = 0; j < factorsB.size(); j++) {
                if (factorsA.get(i).equals(factorsB.get(j))) {
                    gcd *= factorsA.get(i);
                    factorsB.remove(j);
                    break;
                }
            }
        }

        return gcd;
    }

    public static int lcmPrimeFactorization(int a, int b) {
        ArrayList<Integer> factorsA = primeFactors(a);
        ArrayList<Integer> factorsB = primeFactors(b);

        int lcm = 1;

        // mltiply all factors of A
        for (int factor : factorsA) {
            lcm *= factor;
        }

        // multiply remaining factors of B that are not common
        for (int factorB : factorsB) {
            boolean found = false;
            for (int i = 0; i < factorsA.size(); i++) {
                if (factorsA.get(i).equals(factorB)) {
                    factorsA.remove(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                lcm *= factorB;
            }
        }

        return lcm;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            System.out.println("\n--- Using Euclidean Algorithm ---");
            System.out.println("GCD(" + num1 + ", " + num2 + ") = " + gcdEuclidean(num1, num2));
            System.out.println("LCM(" + num1 + ", " + num2 + ") = " + lcmEuclidean(num1, num2));

            System.out.println("\n--- Using Prime Factorization ---");
            System.out.println("Prime factors of " + num1 + ": " + primeFactors(num1));
            System.out.println("Prime factors of " + num2 + ": " + primeFactors(num2));
            System.out.println("GCD(" + num1 + ", " + num2 + ") = " + gcdPrimeFactorization(num1, num2));
            System.out.println("LCM(" + num1 + ", " + num2 + ") = " + lcmPrimeFactorization(num1, num2));
        }
    }
}