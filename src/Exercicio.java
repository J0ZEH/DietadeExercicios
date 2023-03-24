import java.util.Date;

public abstract class Exercicio {
    protected int minutos;
    protected Date date;
    public Exercicio(int minutos, Date date){
        this.minutos = minutos;
        this.date = date;
    }
    public abstract float getCalorias();
    public abstract String getTipo();
    public int getMinutos() {
        return minutos;
    }

    public Date getDate() {
        return date;
    }
}
