package stream;

import designer.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ： fjl
 * @date ： 2018/12/13/013 14:28
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("hello", "aworldsi", "tingnishuo"));
        List<String> collect = list.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Object[] objects = Stream.iterate(1.0, p -> p * 2).peek(System.out::println).limit(20).toArray();

        Optional<String> max = list.stream().max(String::compareToIgnoreCase);
        System.out.println(max.orElse(""));

        Optional<String> a = list.stream().parallel().filter(s -> s.startsWith("a")).findFirst();
        System.out.println(a.orElse(""));
        boolean z = list.stream().parallel().noneMatch(s -> s.startsWith("z"));

        System.out.println(z);

        boolean z1 = list.stream().parallel().anyMatch(s -> s.startsWith("z"));
        System.out.println(z1);

        a.ifPresent(System.out::println);

        List<User> userList = new ArrayList<>();
        userList.add(new User(2, 2));
        userList.add(new User(2, 3));
        userList.add(new User(3, 5));


        //IllegalStateException: Duplicate key 如果键有重复的会报错 解决:(exist, newValue) -> newValue)
        LinkedHashMap<Integer, User> userMap = userList
                .stream()
                .filter(user -> user.getId() >= 2)
                .collect(Collectors.toMap(User::getId, Function.identity(), (existValue, newValue) -> newValue, LinkedHashMap::new));
        userMap.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

        System.out.println("==========================");
        Map<Integer, List<User>> integerListMap = userList.stream().collect(Collectors.groupingBy(User::getId));
        integerListMap.forEach((key, value) -> {
            System.out.printf("key:%s=>value%s\n", key, value);
        });


        System.out.println("counting===========");
        //分组并统计计数
        Map<Integer, Long> collect1 = userList.stream().collect(Collectors.groupingBy(User::getId, Collectors.counting()));
        collect1.forEach((k,v)->{
            System.out.printf("k:%s=>v:%s\n", k, v);
        });

        //分组,然后再每组中找出最大的
        Map<Integer, Optional<User>> collect2 = userList.stream().collect(Collectors.groupingBy(User::getId, Collectors.maxBy(Comparator.comparing(User::getNo))));


        System.out.println("max===================");
        collect2.forEach((key,value)->{
            System.out.printf("key:%s=>value%s\n", key, value);
        });

        System.out.printf("%s", "--------------------------\n");
        Map<Boolean, List<User>> booleanListMap = userList.stream().collect(Collectors.partitioningBy(user -> user.getId() == 2));
        System.out.printf("%s", "--------------------------\n");
        List<User> userList1 = booleanListMap.get(true);
        userList1.forEach(System.out::println);
    }
}
