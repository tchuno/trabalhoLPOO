package modelos;

import java.math.BigDecimal;

/**
 *
 * @author babar
 */
public class Circulo extends Forma {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public BigDecimal calcularArea() {
        return new BigDecimal(Math.pow(raio, 2) * Math.PI);
    }
    
    
}
