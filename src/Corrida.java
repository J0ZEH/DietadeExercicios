import java.util.Date;

public class Corrida extends Exercicio {
    private float cal;

    public Corrida(int minutos, Date date) {
        super(minutos, date);
        this.cal = 90;
    }

    @Override
    public float getCalorias() {
        return (cal * getMinutos());
    }

    @Override
    public String getTipo() {
        return "Corrida";
    }
}
