package modelos;

import java.math.BigDecimal;

/**
 *
 * @author babar
 */
public abstract class Forma {
    
    protected BigDecimal area;
        
    public abstract BigDecimal calcularArea();

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }
    
}
