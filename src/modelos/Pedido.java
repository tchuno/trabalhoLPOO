package modelos;

/**
 *
 * @author babar
 */
public class Pedido {
    
    private Long id;
    private String forma;
    private String material;
    private Cliente cliente;
    private double largura;
    private double altura;
    private double tamanho;
    private double preco;
    
      public Pedido(Long id, String forma, String material, double largura, double altura, double tamanho, double preco) {
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
