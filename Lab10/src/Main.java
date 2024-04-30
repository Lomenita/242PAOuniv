import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int n =10;

        //programare imperativa
        for(int i=0;i<n;i++){
            sum = sum + i;
        }
        System.out.println(sum);

        //programare functionala
        sum = IntStream.rangeClosed(0,n).sum();
        System.out.println(sum);


        Persoana[] arrayPersoana = new Persoana[]{new Persoana("Dan", 20, 1000),
                new Persoana("Ana", 30, 2000),
                new Persoana("Emilia", 20, 3000)};

        Arrays.sort(arrayPersoana, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return ((Persoana)o1).getName().compareTo(((Persoana)o2).getName());
            }
        });

        //Lambda expression
        Arrays.sort(arrayPersoana, (Object o1, Object o2) -> ((Persoana)o1).getName().compareTo(((Persoana)o2).getName()));
        //sau
        Arrays.sort(arrayPersoana, (o1, o2) -> ((Persoana)o1).getName().compareTo(((Persoana)o2).getName()));
        //sau
        Arrays.sort(arrayPersoana, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        //sau
        Arrays.sort(arrayPersoana, Comparator.comparing(Persoana::getName));

        int[] array = {2,5,2,8,3,6};

        Arrays.sort(array);


        //Moduri de afisare a unei liste
        List<Persoana> persoanaList = Arrays.asList(arrayPersoana);

        for(int i = 0; i< persoanaList.size(); i++){
            System.out.println(persoanaList.get(i));
        }
        //sau
        for(Persoana p : persoanaList){
            System.out.println(p);
        }
        //sau, cu iterator
        Iterator<Persoana> persoanaIterator = persoanaList.iterator();
        while(persoanaIterator.hasNext()){
            System.out.println(persoanaIterator.next());
        }
        //afisare cu for each a unei liste
        persoanaList.forEach(p -> System.out.println(p));
        //sau
        persoanaList.forEach(System.out::println);

        streams(persoanaList);

    }

    private static void streams(List<Persoana> persoanaList) {
        List<Persoana> persSelected = new ArrayList<>();
        for(Persoana p : persoanaList){
            if(p.getAge() > 20){
                persSelected.add(p);
            }
        }

        Collections.sort(persSelected, Comparator.comparing(Persoana::getName));

        //cu stream
        List<Persoana> persoanaStream = persoanaList.stream().filter(persoana -> persoana.getAge()>20).sorted(Comparator.comparing(Persoana::getName)).collect(Collectors.toList());
        System.out.println("persoanaStream = " + persoanaStream);

        //min
        System.out.println("1 Varsta minima = " + persoanaStream.stream().min((a, b) -> a.getAge() - b.getAge()).get());
        System.out.println("2 Varsta minima = " + persoanaStream.stream().min(Comparator.comparingInt(Persoana::getAge)).get());

        //mapper. Va fi o lista de String
        List<String> names = persoanaList.stream().map(p-> p.getName()).collect(Collectors.toList());
        System.out.println("names = " + names);
        //sau
        names = persoanaList.stream().map(Persoana::getName).collect(Collectors.toList());

        String ss = persoanaList.stream().map(Persoana::getName).collect(Collectors.joining(","));
        System.out.println("joining ss = " + ss);

        //calcul media de varsta
        double mediaVarsta = persoanaList.stream().collect(averagingInt(Persoana::getAge));
        System.out.println("media de varsta = " + mediaVarsta);

        //suma varstelor
        double sumaVarste = persoanaList.stream().collect(summingInt(Persoana::getAge));
        System.out.println("sumaVarste = " + sumaVarste);

        //grupare persoane dupa varsta
        Map<Integer, List<Persoana>> mapGoupingByAge = persoanaList.stream().collect(groupingBy(Persoana::getAge));
        System.out.println("mapGoupingByAge = " + mapGoupingByAge);

        //suma salariilor pe categorii de varsta
        Map<Integer, Integer> salariiByAge = persoanaList.stream().collect(groupingBy(Persoana::getAge, summingInt(Persoana::getWage)));
        System.out.println("salariiByAge = " + salariiByAge);

        //reduce , calcul suma salarii
        Integer sumaSalarii = persoanaList.stream().map(Persoana::getWage).reduce(0, (x,y) -> x+y);
        System.out.println("sumaSalarii = " + sumaSalarii);
    }
}