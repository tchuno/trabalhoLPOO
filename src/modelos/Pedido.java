package modelos;

import java.math.BigDecimal;

/**
 *
 * @author babar
 */
public class Pedido {
    
    private Long id;
    private String forma;
    private Material material;
    private Cliente cliente;
    private double largura;
    private double altura;
    private double tamanho;
    private BigDecimal preco;
    
      public Pedido(Long id, String forma, Material material, double largura, double altura, double tamanho, BigDecimal preco) {
        this.id = id;
        this.forma = forma;
        this.material = material;
        this.largura = largura;
        this.altura = altura;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
      
    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
