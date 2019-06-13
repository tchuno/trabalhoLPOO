package modelos;

import java.math.BigDecimal;

/**
 *
 * @author babar
 */
public class Retangulo extends Forma {
    private double altura;
    private double lado;

    public Retangulo(double altura, double lado) {
        this.altura = altura;
        this.lado = lado;
    } 
   
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public BigDecimal calcularArea() {
        return new BigDecimal(lado*altura);
    }
    
}
