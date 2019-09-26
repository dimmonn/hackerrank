package algos.hackerrank.misc;

public class Primality {

  static String primality(int n) {
    if (n==2) {
      return "Prime";
    }
    else if(n%2==0|| n%3==0||n==1){
      return "Not prime";
    }
    for (int i=3;i<=Math.sqrt(n);i=i+2){
      if (n % i == 0) {
        return "Not prime";
      }
    }
    return "Prime";
  }

  public static void main(String[] args) {
    System.out.println(primality(2));
  }
}
