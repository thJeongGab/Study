package StreamExer.Ex1.first;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamMain03 {

    public static void main(String[] args) {

        /**
         * 문자열 스트림을 만들어서 정렬하는 방법입니다.
         */
        Stream<String> strStream01 = Stream.of("b", "c", "a");
        strStream01.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> strStream02 = Stream.of("b", "c", "a").sorted();
        strStream02.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> strStream03 = Stream.of("b", "c", "a").sorted((i1, i2) -> i1.compareTo(i2));
        strStream03.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> strStream04 = Stream.of("b", "c", "a").sorted(String::compareTo);
        strStream04.forEach(i -> System.out.print(i + " "));
        System.out.println();

        /**
         * 역순으로 정렬합니다.
         */
        Stream<String> reverseStream01 = Stream.of("b", "c", "a").sorted(Comparator.reverseOrder());
        reverseStream01.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> caseStream01 = Stream.of("b", "c", "A", "A", "B");
        caseStream01.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> caseStream02 = Stream.of("b", "c", "A", "A", "B").sorted();
        caseStream02.forEach(i -> System.out.print(i + " "));
        System.out.println();

        /**
         * 대소문자 상관없이 정렬하고 역순으로도 정렬합니다.
         */
        Stream<String> caseStream03 = Stream.of("b", "c", "A", "A", "B").sorted(String.CASE_INSENSITIVE_ORDER);
        caseStream03.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> caseStream04 = Stream.of("b", "c", "A", "A", "B").sorted(String.CASE_INSENSITIVE_ORDER.reversed());
        caseStream04.forEach(i -> System.out.print(i + " "));
        System.out.println();

        /**
         * 문자열 길이순으로 정렬합니다.
         */
        Stream<String> caseStream05 = Stream.of("b", "cc", "A", "A", "B").sorted(Comparator.comparing(String::length));
        caseStream05.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream<String> caseStream06 = Stream.of("b", "cc", "A", "A", "B").sorted(Comparator.comparing(i -> i.length()));
        caseStream06.forEach(i -> System.out.print(i + " "));
        System.out.println();

        /**
         * 문자열 길이순으로 역순으로 정렬합니다.
         */
        Stream<String> caseStream07
                = Stream.of("b", "c", "A", "A", "B").sorted(Comparator.comparing(String::length).reversed());
        caseStream07.forEach(i -> System.out.print(i + " "));

    }

}
