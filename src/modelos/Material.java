package modelos;

import java.math.BigDecimal;

/**
 *
 * @author babar
 */
public class Material {
    private String tipo;
    private BigDecimal valor;  
   

    public Material(String tipo, BigDecimal valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return this.tipo;
    }
   
}
