/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Guilherme - Wasys
 */
public class Util {
    
    public List<Material> popularMateriais(List<Material> materiais){
        materiais.add(new Material("Comum", new BigDecimal(10.0)));
        materiais.add(new Material("Luxo", new BigDecimal(50.0)));
        materiais.add(new Material("Premium", new BigDecimal(100.0)));
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
    
    public Double calcularTamanho(String altura, String largura, String forma){
         Double result = 0.0;
        if(altura.isEmpty() || altura == null){
            altura = "0";
        }
        if(largura.isEmpty() || largura == null){
            largura = "0";
        }
        Double larg = toDouble(altura);
        Double alt = toDouble(largura);
       if(forma.equals("Retangular")){
          Retangulo retangulo = new Retangulo();
          retangulo.setAltura(alt);
          retangulo.setLado(larg);
          result = retangulo.calcularArea();
          retangulo.setArea(formatarValor(result));
          return retangulo.getArea();
           
       }if(forma.equals("Circular")){
           Circulo circulo = new Circulo();
           circulo.setRaio(toDouble(largura));
           result = circulo.calcularArea();
           circulo.setArea(formatarValor(result));
           return circulo.getArea();     
       }if(forma.equals("Triangular")){
           Triangulo triangulo = new Triangulo();
           triangulo.setAltura(alt);
           triangulo.setLado(larg);
           result = triangulo.calcularArea();
           triangulo.setArea(formatarValor(result));
           return triangulo.getArea();
       }
      return result;
    }
    
    public Double tamanhoAltLarg(String tamanho, String forma){
        if(tamanho.isEmpty() || tamanho == null){
            tamanho = "0";
        }
        Double tam = toDouble(tamanho);
       if(forma.equals("Retangular")){
          tam = Math.sqrt(tam);
          BigDecimal bd = new BigDecimal(tam).setScale(2, RoundingMode.HALF_EVEN);
          String valor = String.valueOf(bd);
          return toDouble(valor);
       }if(forma.equals("Circular")){
           tam = tam / Math.PI;
           tam = Math.sqrt(tam);
           BigDecimal bd = new BigDecimal(tam).setScale(2, RoundingMode.HALF_EVEN);
           String valor = String.valueOf(bd);
           return toDouble(valor);
       }if(forma.equals("Triangular")){
           tam = Math.sqrt(tam*2);
           BigDecimal bd = new BigDecimal(tam).setScale(2, RoundingMode.HALF_EVEN);
           String valor = String.valueOf(bd);
           return toDouble(valor);
       }
      return 0D;
    }
    
    public BigDecimal calcularPreco(String tamanho, Material material){
        BigDecimal tamanhoB = new BigDecimal(tamanho);
        tamanhoB = tamanhoB.multiply(material.getValor());
      return tamanhoB;
    }
    
     public Double formatarValor(Double valor){
           String resultStr = String.valueOf(valor);
           resultStr = resultStr.substring(0, resultStr.lastIndexOf(".")+2);
           return toDouble(resultStr);
    }
   
    public String formatarReais(BigDecimal valor){
        Locale.setDefault(new Locale("pt", "BR"));
        return NumberFormat.getCurrencyInstance().format(valor);
    }
    
    public Cliente buscarCliente(List<Cliente> clientes, String pesquisa){
        for(Cliente cliente : clientes){
            String cpf = cliente.getCpf();
            if(cpf.equals(imprimeCPF(pesquisa))){
                return cliente;
            }
        }
        return null;
    }
    
    public Boolean cpfRepetido(List<Cliente> clientes, String pesquisa){
        for(Cliente cliente : clientes){
            String cpf = cliente.getCpf();
            if(cpf.equals(imprimeCPF(pesquisa))){
                return true;
            }
        }
        return false;
    }
    
}
