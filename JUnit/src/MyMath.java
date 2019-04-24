public class MyMath {
    private static MyMath instance = new MyMath();

    public static MyMath getInstance(){
        return instance;
    }

    public int division(int a , int b){


        if (b==0)
            throw new ArithmeticException("Devision by zero");
            return a/b;

    }

public int multiply(int a , int b){
        return a*b;
}



}
