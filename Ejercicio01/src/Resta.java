public class Resta {

    public int restaAcum;

    public Resta(int restaAcum) {
        this.restaAcum = restaAcum;
    }

    public int getRestaAcum() {
        return restaAcum;
    }

    public void setRestaAcum(int restaAcum) {
        this.restaAcum = restaAcum;
    }

    public static int restar(int n1, int n2) {
        return n1 - n2;
    }

    public int restA(int n1) {
        this.setRestaAcum(this.getRestaAcum()-n1);
        return restaAcum;
    }
}
