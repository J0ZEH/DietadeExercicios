import java.util.Date;

public class Caminhada extends Exercicio {
    private float cal;

    public Caminhada(int minutos, Date date) {
        super(minutos, date);
        this.cal = 45;
    }

    @Override
    public float getCalorias() {
        return (cal * getMinutos());
    }

    @Override
    public String getTipo() {
        return "Caminhada";
    }
}
