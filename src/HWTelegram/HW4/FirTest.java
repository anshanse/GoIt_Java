package HWTelegram.HW4;

public class FirTest {
    public int test(FirNum firNum, int number) {
        return firNum.calc(number);
    }

    public static void main(String[] args) {
        FirNum firNum = new FirNumBasis();
        FirTest firTest = new FirTest();

        //Should be 10
        //System.out.println(firTest.test(firNum, 10));

        //Should be 105
        System.out.println(firNum.calc(9));
    }
}

class FirNum{
    public int calc(int n){
        return n;
    }
}

class FirNumSum extends FirNum{
    @Override
    public int calc(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum+=i;
        }
        return sum;
    }
}
class FirNumFactorial extends FirNum{
    @Override
    public int calc(int n) {
        int mult=1;
        for (int i = 1; i <= n ; i++) {
            mult*=i;
        }
        return mult;
    }
}
class FirNumMultiplyOdd extends FirNum{
    @Override
    public int calc(int n) {
        int mult = 1;
        for (int i = 1; i <=n ; i++) {
            if (i%2 != 0) mult*=i;
        }
        return mult;
    }
}
class FirNumFizzBuzz extends FirNumSum{
    @Override
    public int calc(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if ((i%3 == 0) ^ (i%5 == 0)) sum+=i;
        }
        return sum;
    }
}
class FirNumBasis extends FirNum{
    int basis = 0;
    @Override
    public int calc(int n) {
        for (int i = 0; i <= n; i++) {
            if (i%2 == 0) basis +=i;
        }
        return basis/2;
    }
}