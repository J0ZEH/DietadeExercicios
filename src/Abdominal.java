import java.util.Date;

public class Abdominal extends Exercicio{
    private float cal;
    public Abdominal(int minutos, Date date) {
        super(minutos, date);
        this.cal = 180;
    }
    @Override
    public float getCalorias() {
        //formula para calcular calorias
        return (cal * getMinutos());
    }

    @Override
    public String getTipo() {
        return "Abdominal";
    }
}
