import java.util.Arrays;
import java.util.Scanner;

public class PrimeChecker {

	public static boolean isPrime(int n) {
		if (n < 2) return false;

		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		return isPrime[n];
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter a number to check if it's prime: ");
			int num = scanner.nextInt();

			if (isPrime(num)) {
				System.out.println(num + " is prime.");
			} else {
				System.out.println(num + " is NOT prime.");
			}
		}
	}
}
