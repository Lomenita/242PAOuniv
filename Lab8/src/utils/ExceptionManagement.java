package utils;

import exceptii.MyException;

public class ExceptionManagement {

    public static void verificareSuma(float suma) throws MyException {
        if(suma > 2000){
            throw new MyException("Suma este mai mare de 2000");
        }
    }
}
