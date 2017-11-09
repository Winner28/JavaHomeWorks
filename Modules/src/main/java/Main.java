import java.util.*;
import java.util.stream.Collectors;

public interface Main {
    static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        list.add("one");

        list.add("two");
        Map<String, Long> map = counter(list);
        System.out.println(map);

    }


    public static Map<String, Long> counter(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.groupingBy(str -> str,Collectors.counting()));
    }

}
