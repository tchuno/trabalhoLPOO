package modelos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guiherme - Wasys
 */
public class TabelaPedido extends AbstractTableModel {
    private String[] colunas=new String[]{"Forma", "Material", "Tamanho","Preço"};

    private List<Pedido> lista = new ArrayList();
    private final Util util = new Util();


    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        //if(column==0)
        //    return false;
        //return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido customer = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getForma();//if column 1 (name)
            case 1: return customer.getMaterial();//if column 2 (birthday)
            case 2: return customer.getTamanho();
            case 3: return util.formatarReais(customer.getPreco());
            default : return null;
        }
    }

    public void adicionaPedido(Pedido customer) {
        this.lista.add(customer);
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
        System.out.println(this.lista.size());
    }
    
    public boolean removePedido(Pedido customer) {
        int linha = this.lista.indexOf(customer);
        boolean result = this.lista.remove(customer);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void atualizarTabela(List<Pedido> lista){
        this.lista = new ArrayList();
        this.lista.addAll(lista);
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Pedido getPedido(int linha){
        return lista.get(linha);
    }
    
    public String atualizaPreco(){
        Double preco = 0.0;
        for(Pedido pedido : lista){
            preco += pedido.getPreco();
        }

        return util.formatarReais(preco);
    }
    
}
