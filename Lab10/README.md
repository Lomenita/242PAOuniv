# CURS 10 - 11 (Programare functionala, Lambda Expression, Stream)

### **Programare functionala**

    Programare imperativa:
    for(int i=0;i<n;i++){
    sum = sum + i;
    }

    Programare functionala:
        sum = IntStream.rangeClosed(0,n).sum();
    
### **Lambda expression**

     (parametri ) -> {expresie}
   Tipul parametrului se deduce din context.
Exemplu:

    (int a, int b) -> a+b
    (int a, int b) -> return a+b
    a -> return a*a  (daca e un singur parametru pot lipsi parantezele)
Daca expresia lambda nu contine instructiuni, acoladele pot fi omise.
Expresie lambda cu instructiuni (se pun acolade):

    (a,b) -> {a>b ? return a : return b;}
Expresiile lambda se folosesc si cu interfete functionale.

Interfata functionala = o interfata care are o singura metoda neimplementata. 
                  Se face marcarea cu @FunctionalInterface . 
                 Aceasta adnotare nu este obligatorie dar protejeaza sa nu se poata adauga mai multe metode neimplementate avand ca scop utilizarea cu lambda.

**Exemplul 1**

Pentru a putea fi folosita aceasta interfata, va trebui sa fie implementata in mod specific de niste clase.
    
    public interface FunctieGenerica{
        int functie(int x);
    }

    public class Suma{
       ....
       public static calculeazaSuma(FunctieGenerica f, int n){.... }
    }

    public class TermenGeneral1 implements FunctieGenerica{ 
       @Override
       public int functie(int x){return x+x; }
    } 

    public class TermenGeneral2 implements FunctieGenerica{
        @Override
        public int functie(int x){return x*x; }
    }

Utilizare clasica:

    FunctieGenerica f1 = new TermenGeneral1();
    int suma1 = Suma.calculeazaSuma(f1, 10);
    FunctieGenerica f2 = new TermenGeneral2();
    int suma2 = Suma.calculeazaSuma(f2, 10);
Cu expresii lambda:
Nu se mai fac clasele suplimentare care implementeaza interfata.
Semnatura metodei din interfata functionala precizeaza forma expresiei lambda.
   
    FunctieGenerica f = x+x;
    int suma1 = Suma.calculeazaSuma(f1, 10);

  sau, cu lambda expression:

    int suma1 = Suma.calculeazaSuma(x -> x+x, 10);
    int suma2 = Suma.calculeazaSuma(x -> x*x, 10);

**Exemplul 2** 

Interfata Comparator este tot interfata functionala.

    int compare(Object o1, Object o2)

Pentru un array de Persoana, sortare dupa nume

      Persoana[] arrayPersoana = new Persoana[]{new Persoana("Dan", 10), new Persoana("Ana", 30)};

      Arrays.sort(arrayPersoana, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return ((Persoana)o1).getName().compareTo(((Persoana)o2).getName());
            }
     });

Cu Lambda expression:

        Arrays.sort(arrayPersoana, (Object o1, Object o2) -> ((Persoana)o1).getName().compareTo(((Persoana)o2).getName()));
  sau

        Arrays.sort(arrayPersoana, (o1, o2) -> ((Persoana)o1).getName().compareTo(((Persoana)o2).getName()));
  sau

        Arrays.sort(arrayPersoana, (o1, o2) -> o1.getName().compareTo(o2.getName()));
  sau

        Arrays.sort(arrayPersoana, Comparator.comparing(Persoana::getName));

Moduri de afisare a unei liste

        List<Persoana> persoanaList = Arrays.asList(arrayPersoana);

        for(int i = 0; i< persoanaList.size(); i++){
            System.out.println(persoanaList.get(i));
        }
   sau:

        for(Persoana p : persoanaList){
            System.out.println(p);
        }
   sau, cu iterator:

        Iterator<Persoana> persoanaIterator = persoanaList.iterator();
        while(persoanaIterator.hasNext()){
            System.out.println(persoanaIterator.next());
        }
   afisare cu for each:

        persoanaList.forEach(p -> System.out.println(p));
   sau

        persoanaList.forEach(System.out::println);


### **STREAM-uri**

   Stream urile sunt fluxuri de date.
   
   Utilizare stream pentru afisarea sortata alfabetic a listei persoanaList.
   Afisare alfabetica persoane cu varsta > 20;

       List<Persoana> persSelected = new ArrayList<>();
       for(Persoana p : persoanaList){
          if(p.getAge() > 20){
                    persSelected.add(p);
          }
       }

    Collections.sort(persSelected, new Comparator<Persoana>(){
                @Override
                public int compare(Persoana p1, Persoana p2){
                    return p1.getName().compareTo(p2.getName());
                }
         });
sau

    Collections.sort(persSelected, (p1,p2) -> p1.getName().compareTo(p2.getName());
sau

    Collections.sort(persSelected, Comparator.comparing(Persoana::getName));

Cu stream:

    List<Persoana> persoanaStream = persoanaList.stream().filter(persoana -> persoana.getAge()>20).sorted(Comparator.comparing(Persoana::getName)).collect(Collectors.toList());
    System.out.println("persoanaStream = " + persoanaStream);

## Operatiuni pe stream-uri

  **lista.stream().operatiune**

  **forEach** : executa anumita prelucrare

  **sorted** : face sortare cu ajutorul comparatorului

  **filter** : pastreaza doar cazurile selectate

  **limit** : pastreaza un string cu un numar de elemente specificat

  **boxed** : face conversie intre tipuri. 

    Conversie de la array de primitive la array de obiecte:
    int[] input = {0, 1, 2, 3, 4};
    Integer[] expected = {0, 1, 2, 3, 4};
    
    Integer[] output = Arrays.stream(input).boxed().toArray(Integer[]::new);

  **max**

  **min** : se aplica pe comparator
     se obtine un Optional. Pentru a se extrage valoarea din Optional se foloseste get()

      int minim = persoanaStream.stream().min((a, b) -> a.getAge() - b.getAge()).get()
sau

      persoanaStream.stream().min(Comparator.comparingInt(Persoana::getAge)).get()
    
  **map**  : se produce un stream nou avand ca obiecte ceea ce produce mapperul

    List<String> names = persoanaList.stream().map(p-> p.getName()).collect(Collectors.toList());
 sau

    names = persoanaList.stream().map(Persoana::getName).collect(Collectors.toList());

 

  **colectori**:  collect

    - count si counting : numara elementele stream ului
    - toList(), toSet(), toMap() : returneaza o colectie de tipul cerut
    - joining(String delimitator) : se obtine un String

      String ss = persoanaList.stream().map(Persoana::getName).collect(Collectors.joining(","));
       
    - colector pentru calcul media   
        averagingDouble, averagingLong, averagingInt

            double mediaVarsta = persoanaList.stream().collect(averagingInt(Persoana::getAge));
    - colector pentru calcul suma        
          summingDouble, summingLong, summingInt
     
            double sumaVarste = persoanaList.stream().collect(summingInt(Persoana::getAge));
    - groupingBy 
    
        grupare persoane dupa varsta
           Map<Integer, List<Persoana>> mapGoupingByAge = persoanaList.stream().collect(groupingBy(Persoana::getAge));
    
        suma salariilor pe categorii de varsta:
           Map<Integer, Integer> salariiByAge = persoanaList.stream().collect(groupingBy(Persoana::getAge, summingInt(Persoana::getWage)));
            
  **reduce**

    calcul suma salariilor
  
        Integer sumaSalarii = persoanaList.stream().map(Persoana::getWage).reduce(0, (x,y) -> x+y);