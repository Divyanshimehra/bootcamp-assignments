import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@FunctionalInterface
interface NumberRule{
    boolean apply(int n);
}

public class Q2Java8 {
    static void main() {
        List<Integer> nums = Arrays.asList(3, 2, 10, 15, 8, 21, 14, 7);

        //lambda rules
        NumberRule isEven = n -> n%2 == 0;
        NumberRule isPrime = n -> {
            if (n <= 1) return false;
            for (int i=2; i<= Math.sqrt(n); i++){
                if(n%i == 0) return false;
            }
            return true;
        };

        //stream operations
        List<Integer> result = nums.stream()
                .filter(n -> isEven.apply(n) && isPrime.apply(n))
                .map(n -> n * n)
                .toList();

        // Optional handling
        Optional<Integer> first = result.stream().findFirst();

        if (first.isPresent()) {
            System.out.println("First squared number: " + first.get());
        } else {
            System.out.println("No matching number found");
        }


    }
}