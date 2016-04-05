/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import ModelDAO.CanBoDAO;
import View.CanBoSearchView;
import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DINHQUY
 */
public class CanBoSearchViewController {
    String user;
    private CanBo cb;
    private CanBoSearchView cbs;
    private CanBoDAO cbd;
    public int selected_index_1 = 0;
    public int selected_index_2 = 0;
    public int selected_index_3 = 0; 
    
    public CanBoSearchViewController(CanBoSearchView cbs, CanBo cb, CanBoDAO cbd, String s) {
        this.user = s;
        this.cb = cb;
        this.cbs = cbs;
        this.cbs.Combobox_1Listener(new CanBoSearchViewController.CBx1Action());
        this.cbs.Combobox_2Listener(new CanBoSearchViewController.CBx2Action());
        this.cbs.Conbobox_3Listener(new CanBoSearchViewController.CBx3Action());
        this.cbs.SearchBtnListener(new CanBoSearchViewController.SearchCNAction());
        this.cbs.RefreshBtnListener(new CanBoSearchViewController.RefreshBtnAction());
        this.cbs.BackBtnListener(new CanBoSearchViewController.BackListener());
        cbs.Binding(cbd.loadSearchTable());
    }
    
    private void BindingSearch(){
        cbs.Binding(cbd.loadSearchTable());
    }

    private class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
           Main m = new Main();
           cbs.setVisible(false);
            MainViewController mvc = new MainViewController(m, user);
            m.setVisible(true);
        }
    }
    
    private class RefreshBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            BindingSearch();
        }
    }

    private  class SearchCNAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            RowFilter<TableModel, Object> firstFiler = null;
        RowFilter<TableModel, Object> secondFilter = null;
        RowFilter<TableModel, Object> thirdFilter = null;
        
        List<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel, Object>>();
        RowFilter<TableModel, Object> compoundRowFilter = null;
        try {
            firstFiler = RowFilter.regexFilter(cbs.text_1.getText(), selected_index_1);
            secondFilter = RowFilter.regexFilter(cbs.text_2.getText(), selected_index_2);
            thirdFilter = RowFilter.regexFilter(cbs.text_3.getText(), selected_index_3);
            filters.add(firstFiler);
            filters.add(secondFilter);
            filters.add(thirdFilter);
            compoundRowFilter = RowFilter.andFilter(filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }

        DefaultTableModel m = (DefaultTableModel) cbs.jTable1.getModel();
        TableRowSorter sorter = new TableRowSorter(m);
        cbs.jTable1.setRowSorter(sorter);

        sorter.setRowFilter(compoundRowFilter);
        }
    }

    private  class CBx3Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
                        String cb_3_value = cbs.CB_3.getSelectedItem().toString();
        switch (cb_3_value) {
          case "cán bộ ID": {
                selected_index_3 = 0;
                break;
            }
            case "họ tên": {
                selected_index_3 = 1;
                break;
            }
            case "giới tính": {
                selected_index_3 = 3;
                break;
            }
            case "năm sinh": {
                selected_index_3 = 2;
                break;
            }
            case "địa chỉ": {
                selected_index_3 = 9;

                break;
            }
            case "email": {
                selected_index_3 = 10;
                break;
            }
            case "số điện thoại": {
                selected_index_3 = 11;
                break;
            }
            case "chức vụ": {
                selected_index_3 =7;
                break;
            }
            case "chức danh": {
                selected_index_3 = 8;
                break;
            }
            case "nơi công tác":{
                selected_index_3 =4;
                break;
            }
            case "thời gian bắt đầu công tác":{
                selected_index_3 =5;
                break;
            }
            case "trình độ":{
                selected_index_3 =6;
                break;
            }
        }
        }
    }

    private class CBx2Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
                    String cb_2_value = cbs.CB_2.getSelectedItem().toString();
        switch (cb_2_value) {
          case "cán bộ ID": {
                selected_index_2 = 0;
                break;
            }
            case "họ tên": {
                selected_index_2 = 1;
                break;
            }
            case "giới tính": {
                selected_index_2 = 3;
                break;
            }
            case "năm sinh": {
                selected_index_2 = 2;
                break;
            }
           case "địa chỉ": {
                selected_index_2 = 9;

                break;
            }
            case "email": {
                selected_index_2 = 10;
                break;
            }
            case "số điện thoại": {
                selected_index_2 = 11;
                break;
            }
            case "chức vụ": {
                selected_index_2 =7;
                break;
            }
            case "chức danh": {
                selected_index_2 = 8;
                break;
            }
            case "nơi công tác":{
                selected_index_2 =4;
                break;
            }
            case "thời gian bắt đầu công tác":{
                selected_index_2 =5;
                break;
            }
            case "trình độ":{
                selected_index_2 =6;
                break;
            }
        }
        }
    }

    private  class CBx1Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        String cb_1_value = cbs.CB_1.getSelectedItem().toString();
        switch (cb_1_value) {
            case "cán bộ ID": {
                selected_index_1 = 0;
                break;
            }
            case "họ tên": {
                selected_index_1 = 1;
                break;
            }
            case "giới tính": {
                selected_index_1 = 3;
                break;
            }
            case "năm sinh": {
                selected_index_1 = 2;
                break;
            }
            case "địa chỉ": {
                selected_index_1 = 9;

                break;
            }
            case "email": {
                selected_index_1 = 10;
                break;
            }
            case "số điện thoại": {
                selected_index_1 = 11;
                break;
            }
            case "chức vụ": {
                selected_index_1 =7;
                break;
            }
            case "chức danh": {
                selected_index_1 = 8;
                break;
            }
            case "nơi công tác":{
                selected_index_1 =4;
                break;
            }
            case "thời gian bắt đầu công tác":{
                selected_index_1 =5;
                break;
            }
            case "trình độ":{
                selected_index_1 =6;
                break;
            }
        }
        }
    }



}
