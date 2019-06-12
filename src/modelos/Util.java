/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author Guilherme - Wasys
 */
public class Util {
    
    public List<Material> popularMateriais(List<Material> materiais){
        materiais.add(new Material("Comum", 10.0));
        materiais.add(new Material("Luxo", 50.0));
        materiais.add(new Material("Premium", 100.0));
        return materiais;
    }
    
    public static String imprimeCPF(String CPF) {
           return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
           CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
     
    public static String limpaCPF(String CPF) {
        CPF = CPF.replaceAll("\\.", "");
        CPF = CPF.replaceAll("-", "");
        return CPF;
    }
    
    public String toString(Double var){
        String varD = String.valueOf(var);
        return varD;
    }
    
    public double toDouble(String string){
       if(string.contains(","))
           string = string.replace(",", ".");
      return Double.valueOf(string);
    }
    
    public String calcularTamanho(String altura, String largura){
        BigDecimal alturaD = new BigDecimal(altura);
        BigDecimal larguraD = new BigDecimal(largura);
        BigDecimal result = alturaD.multiply(alturaD);
        String resultStr = String.valueOf(result);
      return resultStr;
    }
    
    public double calcularPreco(Forma forma, Material material){
      return ((forma.calcularArea())*(material.getValor()));
    }
   
    public String formatarReais(Double valor){
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        return df.format(valor);
    }
    
}
