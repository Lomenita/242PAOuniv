import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Exercitiu {
    public static void main(String[] args) {
        /*
        Sa se defineasca un array de Integers.
        Sa se sorteze descrescator folosind lambda expression
        Sa se calculeze suma intregilor folosind reduce
        Sa se calculeze suma intregilor folosind summingInt
        Sa se calculeze media folosind lambda averagingInt
        Sa se afiseze min folosind lambda.
        Sa se afiseze max folosind lambda
        Sa se afiseze intregii mai mari de o anumita valoare folosind filter
         */
        Integer[] integers = {2, 4,6};
        Arrays.sort(integers, (a,b)-> b-a);
        Arrays.stream(integers).forEach(p -> System.out.print(p + " "));
        System.out.println("\nSuma = " + Arrays.stream(integers).reduce(0, (a, b) -> a + b));

        System.out.println("summingInt Suma = " + Arrays.stream(integers).collect(Collectors.summingInt(v -> v)));

        System.out.println("averagingInt media =" + Arrays.stream(integers).collect(Collectors.averagingInt(Integer::intValue)));

        System.out.println("minim min = " + Arrays.stream(integers).min(Integer::compareTo).get());
        System.out.println("maxim max = " + Arrays.stream(integers).max(Integer::compareTo).get());
        Arrays.stream(integers).filter(i -> i > 2).forEach(i -> System.out.print(i + " "));


        /*
         Se defineste un array de primitive int
         sa se sorteze crescator
         Sa se sorteze descrescator -> se foloseste stream
         Lista cu elementele ar2 ridicate la patrat
         sa se afiseze numarul de elemente mai mare decat o valoare data;
         */
        int[] ar2 = {4,2,6,9};

        Arrays.sort(ar2);
        Arrays.stream(ar2).forEach(i -> System.out.print(i + " "));
        List<Integer> list = Arrays.stream(Arrays.stream(ar2).boxed().toArray(Integer[]::new))
                .sorted((a, b) -> b - a).collect(Collectors.toList());
        System.out.println("\nArray sortat descrescator = " + list);

        System.out.println("Lista cu elementele ar2 ridicate la patrat = " + list.stream().map(p -> p * p).collect(Collectors.toList()));

        System.out.println("numarul de elemente mai mare decat 2 = " + list.stream().filter(el -> el > 2).count());

    }
}
