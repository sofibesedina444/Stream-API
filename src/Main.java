import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(156, 4, 90, 66, 3, 9, 11, 4596)).stream();
        findMinMax(
                stream,
                Comparator.naturalOrder(),
                (x, y) -> System.out.printf("min: %s, max: %s%n", x, y)
        );
        getSizeEvenNumbers(156, 4, 90, 66, 3, 9, 11, 4596);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> arrayList;
        T min;
        T max;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
            minMaxConsumer.accept(min, max);
            if (min == null && max == null) {
                minMaxConsumer.accept(null, null);
            }
        }
    }

    public static void getSizeEvenNumbers(Integer... n) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(n));
        List<Integer> num = numbers.stream().filter(e -> (e % 2 == 0)).toList();
        System.out.println("Количество чётных чисел - " + num.size());
    }
}