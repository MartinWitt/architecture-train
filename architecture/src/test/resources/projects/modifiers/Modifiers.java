public abstract class Public {
  
  public int a;
  private int b;
  protected int c;
  int d;
  transient int e;
  volatile int f;
  static int g;
  private static int h;
  public static int i;
  public transient static int j;
  public volatile static int k;
  public static final int l;
  strictfp public static int m;


  public abstract void m1();
  
  protected abstract void m2();
  
  abstract void m3();

  private void m4() {

  }

  private native int m5();

}
