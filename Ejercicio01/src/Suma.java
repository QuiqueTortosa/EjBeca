public class Suma {

    public int sumaAcum;

    public Suma(int sumaAcum) {
        this.sumaAcum = sumaAcum;
    }

    public int getSumaAcum() {
        return sumaAcum;
    }

    public void setSumaAcum(int sumaAcum) {
        this.sumaAcum = sumaAcum;
    }

    public static int sumar(int n1, int n2) {
        return n1 + n2;
    }

    public int sumA(int n1) {
        this.setSumaAcum(n1 + this.getSumaAcum());
        return sumaAcum;
    }

}
