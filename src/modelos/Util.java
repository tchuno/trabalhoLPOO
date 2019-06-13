/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

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
    
    public BigDecimal calcularTamanho(String altura, String largura, String forma){
        BigDecimal valor = BigDecimal.ZERO;
         if(forma.equals("Retangular")){
               if(altura.isEmpty() || altura == null){
                   altura = "0";
               }if(largura.isEmpty() || largura == null){
                   largura = "0";
               }
               Retangulo retangulo = new Retangulo(toDouble(altura), toDouble(largura));
               retangulo.calcularArea();
               retangulo.setArea(retangulo.calcularArea());
               valor = retangulo.getArea();
            }if(forma.equals("Triangular")){
               if(altura.isEmpty() || altura == null){
                   altura = "0";
               }if(largura.isEmpty() || largura == null){
                   largura = "0";
               }
               Triangulo triangulo = new Triangulo(toDouble(altura), toDouble(largura));
               triangulo.calcularArea();
               triangulo.setArea(triangulo.calcularArea());
               valor = triangulo.getArea();
            }if(forma.equals("Circular")){
               if(largura.isEmpty() || largura == null){
                   largura = "0";
               }
               Circulo circulo = new Circulo(toDouble(largura));
               circulo.calcularArea();
               circulo.setArea(circulo.calcularArea());
               valor = circulo.getArea();
               String convert = String.valueOf(valor);
               convert = convert.substring(0,convert.indexOf(".")+2);
               valor = new BigDecimal(convert);
            }
         return valor;
    }
    
    public BigDecimal tamanhoAltLarg(String tamanho, String forma){
        if(tamanho.isEmpty() || tamanho == null){
            return new BigDecimal(0);
        }
        if(forma.equals("Retangular")){
            Double tam = toDouble(tamanho);
            tam = tam/2;
            return new BigDecimal(tam);
        }if(forma.equals("Triangular")){
            Double tam = toDouble(tamanho);
            tam = (tam/2)/2;
            return new BigDecimal(tam);
        }if(forma.equals("Circular")){
            Double tam = toDouble(tamanho);
            tam = (Math.sqrt(tam)) / Math.PI;
            String convert = toString(tam);
            convert = convert.substring(0,convert.indexOf(".")+2);
            return new BigDecimal(convert);
        }
        return new BigDecimal(0);
    }
    
    public BigDecimal calcularPreco(String tamanho, Material material){
        BigDecimal tamanhoB = new BigDecimal(tamanho);
        tamanhoB = tamanhoB.multiply(material.getValor());
      return tamanhoB;
    }
   
    public String formatarReais(BigDecimal valor){
        Locale.setDefault(new Locale("pt", "BR"));
        return NumberFormat.getCurrencyInstance().format(valor);
    }
    
    public Cliente buscarCliente(List<Cliente> clientes, String pesquisa){
        for(Cliente cliente : clientes){
            String cpfFormatado = limpaCPF(cliente.getCpf());
            if(cpfFormatado.equals(pesquisa)){
                return cliente;
            }
        }
        return null;
    }
}
