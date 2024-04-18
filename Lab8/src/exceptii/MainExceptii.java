package exceptii;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainExceptii {
    public static void main(String[] args) {
        exceptiiDemo();
    }

    private static void exceptiiDemo() {
        try ( FileOutputStream fos = new FileOutputStream("testfile1.txt")) {

            String text = "Hello World. This is my java program";
            byte arr[] = text.getBytes();
            fos.write(arr);
            int a = 8;
            checkValue(a);
        } catch (FileNotFoundException e) { //este aruncata de FileOutputStream
            throw new RuntimeException(e);
        } catch (IOException e) { //este aruncata de write
            throw new RuntimeException(e);
        } catch (MyException e) {
            throw new RuntimeException(e);// aici exceptia se trateaza/se logheaza/sau se arunca
            // throw new Exception(e);//se observa ca daca se pune Exception , va trebui adaugat in antetul metodei main
        }
      /*
       Aici nu se poate folosi catch(FileNotFoundException | IOException e)
       deoarece FileNotFoundException este subclasa a lui IOException
       */

        System.out.println("Resource are closed and message has been written into the testfile1.txt");
    }

    private static void checkValue(int a) throws MyException {
        if(a > 7){
            System.out.println("bigger than 7");
            throw new MyException("a is bigger than 7");
        }
    }
}
