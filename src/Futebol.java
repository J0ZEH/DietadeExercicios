import java.util.Date;

public class Futebol extends Exercicio {
    private float cal;

    public Futebol(int minutos, Date date) {
        super(minutos, date);
        this.cal = 180;
    }

    @Override
    public float getCalorias() {
        return (cal * getMinutos());
    }

    @Override
    public String getTipo() {
        return "Futebol";
    }
}
