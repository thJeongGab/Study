package lec08.stream05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreanExer01 {

    public static void main(String[] args) {

        List<String> strList01 = new ArrayList<>();
        strList01.add("반도체");
        strList01.add("가전제품");
        strList01.add("휴대폰");
        strList01.add("자동차");
        strList01.add("배");

        /**
         * Stream을 이용한 정렬
         */
        strList01.stream().sorted().forEach(i -> System.out.print(i + " "));
        System.out.println();

        String[] strArray = new String[]{"Alpha", "Bravo", "Charlie", "Delta"};

        List<String> cvtStrList = Arrays.asList(strArray);
        cvtStrList.stream().forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> cvtStream01 = Arrays.stream(strArray);
        cvtStream01.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> cvtStream02 = Arrays.stream(strArray, 2, 3);
        cvtStream02.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> cvtStream03 = Stream.of(strArray);
        cvtStream03.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> streamCompany = Stream.of("Samsung", "LG", "Hyundai", "SK");
        streamCompany.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> streamCountry = Stream.of("Korea", "America", "Japan", "China", "Russia");
        streamCountry.forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream intStream01 = IntStream.range(1, 7);
        intStream01.forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream intStream02 = IntStream.rangeClosed(1, 7);
        intStream02.forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream intsRandom01 = new Random().ints();
        intsRandom01.limit(5).forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream intsRandom02 = new Random().ints(3);
        intsRandom02.forEach(i -> System.out.print(i + " "));
        System.out.println();

        DoubleStream doublesRandom01 = new Random().doubles();
        doublesRandom01.limit(2).forEach(i -> System.out.print(i + " "));
        System.out.println();

        DoubleStream doublesRandom02 = new Random().doubles(5);
        doublesRandom02.forEach(i -> System.out.print(i + " "));
        System.out.println();

        DoubleStream doubleStream01 = DoubleStream.of(0.1, 0.2, 0.3, 0.4, 0.5);
        doubleStream01.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Double[] arrayDouble = new Double[]{0.31, 0.32, 0.33, 0.34};
        Stream<Double> doubleStream02 = Arrays.stream(arrayDouble);
        doubleStream02.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> generateString01 = Stream.generate(() -> "Good company is best solution.");
        generateString01.limit(3).forEach(i -> System.out.print(i + " "));
        System.out.println();

        generateString01 = Stream.generate(() -> "Good company is best solution.");
        generateString01.limit(1).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<Double> generateMathRandom01 = Stream.generate(() -> Math.random() * 10);
        generateMathRandom01.limit(3).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<Double> generateAnotherMathRandom = Stream.generate(Math::random);
        generateAnotherMathRandom.limit(3).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<Integer> iterateStream01 = Stream.iterate(1, i -> i + 3);
        iterateStream01.limit(5).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<Double> iterateStream02 = Stream.iterate(1.0, i -> i - 0.2);
        iterateStream02.limit(5).forEach(i -> System.out.print(i + " "));
        System.out.println();

    }

}
