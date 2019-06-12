/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Guilherme - Wasys
 */
public class GenericComboModel<E> extends AbstractListModel<E> implements ComboBoxModel<E>{

    private List<E> itemList;
    private E selection;

    public GenericComboModel(List<E> list) {
        this.itemList = list;
    }

    @Override
    public int getSize() {
        return this.itemList.size();
    }

    @Override
    public E getElementAt(int index) {
        return this.itemList.get(index);
    }

    @Override
    public Object getSelectedItem() {
        return this.selection;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selection = (E) anItem;
    }
}