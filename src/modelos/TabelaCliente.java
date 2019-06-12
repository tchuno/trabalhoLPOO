package modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author babar
 */
public class TabelaCliente extends AbstractTableModel {
    private String[] colunas=new String[]{"Nome", "Email", "Nascimento","CPF"};

    private List<Cliente> lista = new ArrayList();


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
        Cliente customer = lista.get(rowIndex);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatado = customer.getDataNascimento().format(formatter);
        switch (columnIndex) {
            case 0: return customer.getNome();//if column 1 (name)
            case 1: return customer.getEmail();//if column 2 (birthday)
            case 2: return formatado;
            case 3: return customer.getCpf() ;
            default : return null;
        }
    }

    public void adicionaCliente(Cliente customer) {
        this.lista.add(customer);
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
        System.out.println(this.lista.size());
    }
    
    public boolean removeCliente(Cliente customer) {
        int linha = this.lista.indexOf(customer);
        boolean result = this.lista.remove(customer);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void atualizarTabela(List<Cliente> lista){
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

    public Cliente getCliente(int linha){
      try{
        return lista.get(linha);
      }catch(IndexOutOfBoundsException e){
          JOptionPane.showMessageDialog(null, "Cliente não selecionado na Lista!");
          return null;
      }
    }
}
