import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Domaci {

    // 1. Sve brojeve deljive sa 3 uvecati za 2
    public static List<Integer> divBy3Add2(List<Integer> numbers) {
        List<Integer> list = numbers.stream().map(x -> x % 3 == 0 ? x + 2 : x).collect(Collectors.toList());
        return list;
    }

    // 2. Izbaciti sve brojeve koji su deljivi sa 3 prilikom njihovog dupliranja
    public static List<Integer> afterDoubleDeleteDivBy3 (List<Integer> numbers) {
        List<Integer> list = numbers.stream().map(x -> x * 2).filter(x ->x % 3 == 0).collect(Collectors.toList());
        return list;
    }

    // 3. Pomnoziti svaki neparan broj sa 2 i izbaciti duplikate
    public static List<Integer> multiplyAllOddNumbersBy2DeleteDuplicates(List<Integer> numbers){
        List<Integer> multiplyAllOddNumbersBy2 = numbers.stream().map(x -> x % 2 != 0 ? x*2 : x).collect(Collectors.toList());
        HashSet<Integer> set = new HashSet<>(multiplyAllOddNumbersBy2);
        ArrayList<Integer> list = new ArrayList(set);
        return list;
    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6);

        System.out.println(divBy3Add2(numbers));

        System.out.println(afterDoubleDeleteDivBy3(numbers));

        System.out.println(multiplyAllOddNumbersBy2DeleteDuplicates(numbers));
    }
}
