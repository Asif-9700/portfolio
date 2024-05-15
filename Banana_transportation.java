import java.util.*;

public class Banana_transportation {

  public static int minVehicles(int[] weights, int limit) {
    Arrays.sort(weights);
    int left = 0, right = weights.length - 1;
    int vehicles = 0;

    while (left <= right) {
      if (weights[left] + weights[right] <= limit) {
        left++;
        right--;
      } else {
        right--;
      }
      vehicles++;
    }

    return vehicles;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the weights of bananas separated by space:");
    String[] weightsStr = scanner.nextLine().split(" ");
    int[] weights = Arrays
      .stream(weightsStr)
      .mapToInt(Integer::parseInt)
      .toArray();

    System.out.println("Enter the weight limit of the vehicle:");
    int limit = scanner.nextInt();

    int result = minVehicles(weights, limit);
    System.out.println("Minimum number of vehicles needed: " + result);
  }
}
