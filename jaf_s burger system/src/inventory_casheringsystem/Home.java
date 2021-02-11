package inventory_casheringsystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.TableModel;

public class Home extends javax.swing.JFrame {

    Connection con = null;
   

    public String getdata[] = new String[2];

    public Home() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Display_on_Table();
        Display_on_Cashering();
        CasheringMoveProduct();
        SearchintoCasher();
        addTotal();
        TableonStocksdisplay();

        showDate();
        showTime();
        salesdaily();
        UserTable();
        currentDate( );
    }
    public void StockSuccessClearField(){
        product_ID.setText("");
        products_name.setText("");
        category_product.setText("");
        qtys.setText("");
        avs.setText("");
    }
    public void currentDate( ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM,dd");
        Date d = new Date();
        datescashier.setText(dateFormat.format(d));
        System.out.println("time:"+ datescashier.getText());
    }
    public void print_removeListed(){
           try {
            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM insertedintocart");
            ps.executeUpdate();
            CasheringMoveProduct();
            addTotal();
               System.out.println("has beed remove to cart!");

        } catch (Exception e) {
            System.out.println("unable to remove please check your db!");
        }
    }
    public void stockInlog() {
        Statement st;
        ResultSet rs;

        String info = "Stock In : ID: " + pIDs.getText() + " Product Name:" + pnames.getText() + "QTY:" + qtyss.getText();
        try {

            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("Insert into viewlogs(Date,Time,Details,userTypes) values(?,?,?,?)");
            ps.setString(1, date.getText());
            ps.setString(2, times.getText());
            ps.setString(3, info);
            ps.setString(4, textlogin.getText());

            System.out.println("logs recorded!");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public void stockOutLogs() {
        Statement st;
        ResultSet rs;

        String info = "Stock Out : ID: " + pIDs.getText() + " Product Name:" + pnames.getText() + "QTY:" + qtys.getText();
        try {

            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("Insert into viewlogs(Date,Time,Details,userTypes) values(?,?,?,?)");
            ps.setString(1, date.getText());
            ps.setString(2, times.getText());
            ps.setString(3, info);
            ps.setString(4, textlogin.getText());

            System.out.println("logs recorded!");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public void logOut() {
        Statement st;
        ResultSet rs;

        String info = "Logout";
        try {

            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("Insert into viewlogs(Date,Time,Details,userTypes) values(?,?,?,?)");
            ps.setString(1, date.getText());
            ps.setString(2, times.getText());
            ps.setString(3, info);
            ps.setString(4, textlogin.getText());

            System.out.println("logs recorded!");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public void viewlogss() {
        Statement st;
        ResultSet rs;
        con = Connections.getConnection();

        String sql = "SELECT * FROM `viewlogs`";
        try {
            DefaultTableModel model = (DefaultTableModel) viewlogtables.getModel();
            model.setRowCount(0);
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String datelog = rs.getString("Date");
                String timelog = rs.getString("Time");
                String detailslog = rs.getString("Details");
                String userlog = rs.getString("userTypes");

                Object[] row = {datelog, timelog, detailslog, userlog};
                model.addRow(row);

            }

        } catch (Exception ex) {
            System.out.println(ex);

        }

    }

    public void addProductLog() {
        Statement st;
        ResultSet rs;

        String info = "has added new Product! -" + "Product Name: " + pn.getText() + " Category: " + cat.getText() + " Portion: " + por.getText() + " Serving : " + ser.getText() + " Price: " + pri.getText() + " QTY: " + productqty.getText();
        try {

            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("Insert into viewlogs(Date,Time,Details,userTypes) values(?,?,?,?)");
            ps.setString(1, date.getText());
            ps.setString(2, times.getText());
            ps.setString(3, info);
            ps.setString(4, textlogin.getText());

            System.out.println("logs recorded!");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public void UpdateProductLog() {
        Statement st;
        ResultSet rs;

        String info = "has update:! -" + "Product Name: " + pn.getText() + " Category: " + cat.getText() + " Portion: " + por.getText() + " Serving : " + ser.getText() + " Price: " + pri.getText() + " QTY: " + productqty.getText();
        try {

            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("Insert into viewlogs(Date,Time,Details,userTypes) values(?,?,?,?)");
            ps.setString(1, date.getText());
            ps.setString(2, times.getText());
            ps.setString(3, info);
            ps.setString(4, textlogin.getText());

            System.out.println("logs recorded!");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public void DeleteAddProductLog() {
        Statement st;
        ResultSet rs;

        String info = "has been deleted :! -" + "Product Name: " + pn.getText() + " Category: " + cat.getText() + " Portion: " + por.getText() + " Serving : " + ser.getText() + " Price: " + pri.getText() + " QTY: " + productqty.getText();
        try {

            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("Insert into viewlogs(Date,Time,Details,userTypes) values(?,?,?,?)");
            ps.setString(1, date.getText());
            ps.setString(2, times.getText());
            ps.setString(3, info);
            ps.setString(4, textlogin.getText());

            System.out.println("logs recorded!");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public void CreateAccount() {

        try {
            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO `usertype_table`(`firstname`, `middlename`, `lastname`, `address`, `age`, `user`, `pass`, `gender`, `usertype`) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, fn1.getText());
            ps.setString(2, mn1.getText());
            ps.setString(3, ln1.getText());
            ps.setString(4, ad1.getText());
            ps.setString(5, age1.getText());
            ps.setString(6, user1.getText());
            ps.setString(7, pass1.getText());
            ps.setString(8, String.valueOf(gen1.getSelectedItem()));
            ps.setString(9, String.valueOf(usertype1.getSelectedItem()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(rootPane, "Has been Created");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "One or more Field to fill up");

        }
    }

    public void resetField() {
        fn1.setText("");
        mn1.setText("");
        ln1.setText("");
        ad1.setText("");
        age1.setText("");
        user1.setText("");
        pass1.setText("");

    }

    public void exportTable(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        for (int i = 0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                out.write(model.getValueAt(i, j).toString() + "\t");
            }
            out.write("\n");
        }

        out.close();
        System.out.println("write out to: " + file);
    }

    public void sumTotalDailyInven() {

        String dateinven = ((JTextField) date_inven_daily.getDateEditor().getUiComponent()).getText();
        String select = (String) select_stock_in_out.getSelectedItem();
        PreparedStatement pst = null;
        ResultSet rs = null;
        con = Connections.getConnection();
        try {
            String d = daydate.getText();
            String SQL = "SELECT SUM(qty) FROM `inventory` WHERE Date = '" + dateinven + "' AND Stock_In_Out = '" + select + "'";

            pst = con.prepareStatement(SQL);
            rs = pst.executeQuery();
            if (rs.next()) {
                float sum = rs.getFloat("Sum(qty)");
                String data = String.valueOf(sum);
                totalIn_outText.setText(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void dailyinven() {
        Statement st;
        ResultSet rs;
        con = Connections.getConnection();
        String dateinven = ((JTextField) date_inven_daily.getDateEditor().getUiComponent()).getText();

        String select = (String) select_stock_in_out.getSelectedItem();
        System.out.println(select);
        System.out.println(dateinven);

        String sql = "SELECT * FROM `inventory` WHERE Date = '" + dateinven + "' AND Stock_In_Out = '" + select + "'";
        try {
            DefaultTableModel model = (DefaultTableModel) InventoryDaily.getModel();
            model.setRowCount(0);
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String productcode = rs.getString("id");
                String pname = rs.getString("Product_name");
                String cat = rs.getString("Category");
                String qty = rs.getString("qty");
                String dat = rs.getString("Date");
                String inorout = rs.getString("Stock_In_Out");
                Object[] row = {productcode, pname, cat, qty, dat, inorout};
                model.addRow(row);

            }

        } catch (Exception ex) {
            System.out.println(ex);

        }

    }

    public void sumTotalYearlySale() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        int year = selectyear.getYear();
        con = Connections.getConnection();
        try {

            String SQL = "SELECT  SUM(totalp) FROM salesreport WHERE date LIKE '" + year + "%'";

            pst = con.prepareStatement(SQL);
            rs = pst.executeQuery();
            if (rs.next()) {
                float sum = rs.getFloat("Sum(totalp)");
                String datas = String.valueOf(sum);
                monthlysum1.setText(datas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sumTotalMonthly() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        con = Connections.getConnection();
        try {
            String data = yeartextsale.getText() + "-" + monthtext.getText() + ",";
            String SQL = "SELECT  SUM(totalp) FROM salesreport WHERE date LIKE '" + data + "%'";

            pst = con.prepareStatement(SQL);
            rs = pst.executeQuery();
            if (rs.next()) {
                float sum = rs.getFloat("Sum(totalp)");
                String datas = String.valueOf(sum);
                monthlysum.setText(datas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sumTotaldaily() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        con = Connections.getConnection();
        try {
            String d = daydate.getText();
            String SQL = "SELECT *, SUM(totalp) FROM salesreport WHERE date = '" + d + "'";

            pst = con.prepareStatement(SQL);
            rs = pst.executeQuery();
            if (rs.next()) {
                float sum = rs.getFloat("Sum(totalp)");
                String data = String.valueOf(sum);
                dailysum.setText(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void salesday() {
        Statement st;
        ResultSet rs;
        con = Connections.getConnection();
        String d = daydate.getText();
        String sql = "SELECT * FROM `salesreport` WHERE date  LIKE '" + d + "'";
        try {
            DefaultTableModel model = (DefaultTableModel) TableDailySales.getModel();
            model.setRowCount(0);
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String productcode = rs.getString("pcode");
                String pname = rs.getString("pname");
                String date = rs.getString("date");
                String qty = rs.getString("qty");
                String price = rs.getString("price");
                String totalp = rs.getString("totalp");
                Object[] row = {productcode, pname, date, qty, price, totalp};
                model.addRow(row);

            }

        } catch (Exception ex) {
            System.out.println(ex);

        }

    }

    public void UserTable() {
        ArrayList<UsersInfo> list = getIDlist();

        DefaultTableModel model = (DefaultTableModel) users.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for (int x = 0; x < list.size(); x++) {
            row[0] = list.get(x).getID();
            row[1] = list.get(x).getFirstname();
            row[2] = list.get(x).getMiddlename();
            row[3] = list.get(x).getLastname();
            row[4] = list.get(x).getAddress();
            row[5] = list.get(x).getAge();
            row[6] = list.get(x).getUsername();
            row[7] = list.get(x).getPassword();
            row[8] = list.get(x).getGender();
            row[9] = list.get(x).getUsersType();

            model.addRow(row);

        }

    }

    public ArrayList<UsersInfo> getIDlist() {
        ArrayList<UsersInfo> userinfo = new ArrayList<UsersInfo>();
        con = Connections.getConnection();
        String query = "SELECT * FROM `usertype_table";

        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            UsersInfo userss;
            while (rs.next()) {
                userss = new UsersInfo(rs.getInt("id"), rs.getString("firstname"),
                        rs.getString("middlename"), rs.getString("lastname"), rs.getString("address"), rs.getInt("age"), rs.getString("user"), rs.getString("pass"),
                        rs.getString("gender"), rs.getString("usertype"));
                userinfo.add(userss);
            }

        } catch (SQLException ex) {
            Logger.getLogger(inv_products.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userinfo;
    }

    public void getInfoUsers(int index) {
        idtext.setText(Integer.toString(getIDlist().get(index).getID()));
        fn.setText(getIDlist().get(index).getFirstname());
        mn.setText(getIDlist().get(index).getMiddlename());
        ln.setText(getIDlist().get(index).getLastname());
        ad.setText(getIDlist().get(index).getAddress());
        age.setText(Integer.toString(getIDlist().get(index).getAge()));
        user.setText(getIDlist().get(index).getUsername());
        pass.setText(getIDlist().get(index).getPassword());

    }

    //display daily
    public void salesdaily() {
        ArrayList<salesgetdata> list = salesReportList();

        DefaultTableModel model = (DefaultTableModel) TableDailySales.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        for (int x = 0; x < list.size(); x++) {
            row[0] = list.get(x).getProductCode();
            row[1] = list.get(x).getProductname();
            row[2] = list.get(x).getDate();
            row[3] = list.get(x).getQuality();
            row[4] = list.get(x).getPrice();
            row[5] = list.get(x).getTotalPrice();

            model.addRow(row);

        }

    }

    public ArrayList<salesgetdata> salesReportList() {
        ArrayList<salesgetdata> productlist = new ArrayList<salesgetdata>();
        con = Connections.getConnection();
        String query = "SELECT*FROM salesreport";

        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            salesgetdata product;
            while (rs.next()) {
                product = new salesgetdata(rs.getInt("pcode"), rs.getString("pname"),
                        rs.getString("date"), rs.getInt("qty"), rs.getFloat("price"), rs.getFloat("totalp")
                );
                productlist.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(inv_products.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productlist;
    }

    void showDate( ) {

        DateFormat dateFormat = new SimpleDateFormat("MM-dd,yyyy");
        Date d = new Date();
        date.setText(dateFormat.format(d));

    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss a");
                times.setText(f.format(d));
            }
        }).start();
    }

    public void getAllDataTo_Print() {
        ArrayList<gettheproduct> list = getProductListed();
        printTextArea.append("\n\n\n\n\t\tSY JAFS BURGER\n"
                
                + "\t\t   Welcome... \n\n\n"
                + "  =========================================\n"
                + "\t" + date.getText() + "\t" + times.getText() + "\n"
                + "  =========================================\n");

        Object[] row = new Object[5];
        for (int x = 0; x < list.size(); x++) {

            row[0] = list.get(x).getidlist();
            row[1] = list.get(x).getPns();
            row[2] = list.get(x).getQTY();
            row[3] = list.get(x).getpric();
            row[4] = list.get(x).getTotal();

            printTextArea.append("  " + row[1].toString() + "\n\t" + row[2].toString() + "\t" + row[3].toString() + "\t" + row[4].toString() + "\n");
            printTextArea.append("  _________________________________________\n");

            Statement st;
            ResultSet rs;

            String info = "Sales : ID: " + row[0].toString() + " Product Name: " + row[1].toString() + " QTY: " + row[2].toString() + " Price: " + row[3].toString() + " Total Price: " + row[4].toString();
            try {

                con = Connections.getConnection();
                PreparedStatement ps = con.prepareStatement("Insert into viewlogs(Date,Time,Details,userTypes) values(?,?,?,?)");
                ps.setString(1, date.getText());
                ps.setString(2, times.getText());
                ps.setString(3, info);
                ps.setString(4, textlogin.getText());

                System.out.println("logs recorded!");
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);

            }
        }
        printTextArea.append("\n\t\tCash:  " + ammount.getText());
        printTextArea.append("\n\t\tChange:  " + change.getText());
        printTextArea.append("\n\t\tTotal Ammount: " + sumTotal.getText());
        printTextArea.append("\n  _________________________________________\n");

    }

    // Sales Report Function
    public void insetToDB_SalesReport() {
        ArrayList<gettheproduct> list = getProductListed();

        Object[] row = new Object[5];
        for (int x = 0; x < list.size(); x++) {

            row[0] = list.get(x).getidlist();
            row[1] = list.get(x).getPns();
            row[2] = list.get(x).getQTY();
            row[3] = list.get(x).getpric();
            row[4] = list.get(x).getTotal();

            PreparedStatement psd;

            String quantity_in = qtyss.getText();
            String id_Product_In = pIDs.getText();

            String update_out = "UPDATE inv_products  SET qty = qty - " + row[2].toString() + " WHERE id = " + row[0].toString();

            try {

                psd = con.prepareStatement(update_out);
                psd.execute();

            } catch (Exception e) {

            }

            try {

                con = Connections.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO `salesreport`(pcode,pname,date,qty,price,totalp)" + "values(?,?,?,?,?,?)");

                ps.setString(1, row[0].toString());
                ps.setString(2, row[1].toString());
                ps.setString(3, datescashier.getText());
                ps.setString(4, row[2].toString());
                ps.setString(5, row[3].toString());
                ps.setString(6, row[4].toString());

                ps.executeUpdate();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "cant record logs");
            }
        }
    }

    //_________________________________________Search from database inven_stock_table
    public ArrayList<inven_table_display> SearchintoInven_Data(String ValToSearch) {
        ArrayList<inven_table_display> productlist = new ArrayList<inven_table_display>();

        Statement st;
        ResultSet rs;

        try {
            con = Connections.getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `inv_products` WHERE CONCAT(`id`, `Product_name`, `Category`,`qty`) LIKE '%" + ValToSearch + "%'";
            rs = st.executeQuery(searchQuery);

            inven_table_display product;

            while (rs.next()) {
                product = new inven_table_display(
                        rs.getInt("id"),
                        rs.getString("Product_name"),
                        rs.getString("Category"),
                        rs.getInt("qty")
                );
                productlist.add(product);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return productlist;
    }

    public void SearchTableStock() {
        ArrayList<inven_table_display> product = SearchintoInven_Data(searchInven.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Product Code", "Product Name", "Category ", "Qty"});
        Object[] row = new Object[4];

        for (int i = 0; i < product.size(); i++) {
            row[0] = product.get(i).getID();
            row[1] = product.get(i).getProductName();
            row[2] = product.get(i).getCategory();
            row[3] = product.get(i).getQTY();

            model.addRow(row);
        }
        inven_stock_table.setModel(model);

    }

    //display on talbe inventory
    public void inven_in_out() {
        ArrayList<inventory_product_in_out> list = getInventoryList();

        DefaultTableModel model = (DefaultTableModel) TableDailySales.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        for (int x = 0; x < list.size(); x++) {
            row[0] = list.get(x).getID();

            row[1] = list.get(x).getProductName();
            row[2] = list.get(x).getCategory();
            row[3] = list.get(x).getQTY();
            row[4] = list.get(x).getDate();
            row[5] = list.get(x).getIN_out();

            model.addRow(row);

        }

    }

    public ArrayList<inventory_product_in_out> getInventoryList() {
        ArrayList<inventory_product_in_out> productlist = new ArrayList<inventory_product_in_out>();
        con = Connections.getConnection();
        String query = "SELECT*FROM inventory";

        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            inventory_product_in_out product;
            while (rs.next()) {
                product = new inventory_product_in_out(rs.getInt("id"), rs.getString("Product_name"),
                        rs.getString("Category"), rs.getInt("qty"), rs.getString("Date"), rs.getString("Stock_In_Out"));
                productlist.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(inv_products.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productlist;
    }

    //--------------------Clear field per click ---------------
    public void clear() {
        pIDs.setText("");
        pnames.setText("");
        pcat.setText("");
        qtyss.setText("");
        product_ID.setText("");
        products_name.setText("");
        category_product.setText("");
        avs.setText("");
    }
    ////////////////////////////////// get price and amount //////

    void setText(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class getData {

        public getData(String getdata[]) {
            getdata[0] = change.getText();
            getdata[1] = ammount.getText();
        }

    }    //___________________________display data to table inventory stock_____________________________________

    public void TableonStocksdisplay() {
        ArrayList<inv_stocks> list = getProductListss();

        DefaultTableModel model = (DefaultTableModel) inven_stock_table.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int x = 0; x < list.size(); x++) {
            row[0] = list.get(x).getID();
            row[1] = list.get(x).getProductname();
            row[2] = list.get(x).getCategory();
            row[3] = list.get(x).getQty();

            model.addRow(row);

        }

    }

    public ArrayList<inv_stocks> getProductListss() {
        ArrayList<inv_stocks> productlist = new ArrayList<inv_stocks>();
        con = Connections.getConnection();
        String query = "SELECT*FROM inv_products";

        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            inv_stocks product;
            while (rs.next()) {
                product = new inv_stocks(rs.getInt("id"), rs.getString("Product_name"),
                        rs.getString("Category"), rs.getFloat("Price"), rs.getFloat("qty"));
                productlist.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(inv_products.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productlist;
    }

    //_______________________________Table - Add inventory__________________________________________________________________
    public void Display_on_Table() {
        ArrayList<inv_products> list = getProductList();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int x = 0; x < list.size(); x++) {
            row[0] = list.get(x).getID();
            row[1] = list.get(x).getProductname();
            row[2] = list.get(x).getCategory();
            row[3] = list.get(x).getPortion();
            row[4] = list.get(x).getServing();
            row[5] = list.get(x).getprice();
            row[6] = list.get(x).getQty();

            model.addRow(row);

        }

    }

    public ArrayList<inv_products> getProductList() {
        ArrayList<inv_products> productlist = new ArrayList<inv_products>();
        con = Connections.getConnection();
        String query = "SELECT*FROM inv_products";

        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            inv_products product;
            while (rs.next()) {
                product = new inv_products(rs.getInt("id"), rs.getString("Product_name"),
                        rs.getString("Category"), rs.getString("Portion"), rs.getString("Serving"), rs.getFloat("Price"), rs.getFloat("qty"));
                productlist.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(inv_products.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productlist;
    }

    public ArrayList<inv_products> ListProduct(String ValToSearch) {
        ArrayList<inv_products> productlist = new ArrayList<inv_products>();

        Statement st;
        ResultSet rs;

        try {
            con = Connections.getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `inv_products` WHERE CONCAT(`id`, `Product_name`, `Category`,`Portion`, `Serving`,`Price`,`qty`) LIKE '%" + ValToSearch + "%'";
            rs = st.executeQuery(searchQuery);

            inv_products product;

            while (rs.next()) {
                product = new inv_products(
                        rs.getInt("id"),
                        rs.getString("Product_name"),
                        rs.getString("Category"),
                        rs.getString("Portion"),
                        rs.getString("Serving"),
                        rs.getInt("Price"),
                        rs.getFloat("qty")
                );
                productlist.add(product);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return productlist;
    }

    // function to display data in jtable
    public void findProduct() {
        ArrayList<inv_products> product = ListProduct(sort.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Product Code", "Product Name", "Category ", "Portion", "Serving", "Price", "Qty"});
        Object[] row = new Object[7];

        for (int i = 0; i < product.size(); i++) {
            row[0] = product.get(i).getID();
            row[1] = product.get(i).getProductname();
            row[2] = product.get(i).getCategory();
            row[3] = product.get(i).getPortion();
            row[4] = product.get(i).getServing();
            row[5] = product.get(i).getprice();
            row[6] = product.get(i).getQty();

            model.addRow(row);
        }
        table.setModel(model);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        footercolor = new javax.swing.JPanel();
        times = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        textlogin = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        datescashier = new javax.swing.JLabel();
        head = new javax.swing.JPanel();
        inven_pro = new javax.swing.JButton();
        inven_stock = new javax.swing.JButton();
        Casher = new javax.swing.JButton();
        report = new javax.swing.JButton();
        logingout = new javax.swing.JButton();
        userText = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        Cashering = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listed = new javax.swing.JTable();
        searching = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pID = new javax.swing.JTextField();
        Pname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        addCart = new javax.swing.JButton();
        p_order = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        sumTotal = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        idlisted = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pnamelabel = new javax.swing.JLabel();
        ammount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        change = new javax.swing.JTextField();
        text = new javax.swing.JLabel();
        nameofproduct = new javax.swing.JLabel();
        availableStocks1 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        casherTable = new javax.swing.JTable();
        inventoryProduct = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sort = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        pn = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        por = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ser = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pri = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        productqty = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        orderprint = new javax.swing.JPanel();
        printbg = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        printTextArea = new javax.swing.JTextArea();
        jButton14 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        manageusers = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        users = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        mn = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        ad = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        gen = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        usertype = new javax.swing.JComboBox<>();
        update_user = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        idtext = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        signupuser = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        fn1 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        mn1 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        ln1 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        ad1 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        age1 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        gen1 = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        user1 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        jLabel70 = new javax.swing.JLabel();
        ClearField = new javax.swing.JButton();
        usertype1 = new javax.swing.JComboBox<>();
        createuser = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        showP = new javax.swing.JCheckBox();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        viewlog = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        viewlogtables = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel60 = new javax.swing.JLabel();
        salesreports = new javax.swing.JPanel();
        bodyofsales = new javax.swing.JPanel();
        Daily = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableDailySales = new javax.swing.JTable();
        date2 = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        dailysum = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        daydate = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        Monthly = new javax.swing.JPanel();
        yearsales = new com.toedter.calendar.JYearChooser();
        jScrollPane10 = new javax.swing.JScrollPane();
        monthsaletable = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        monthlysum = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        monthtext = new javax.swing.JLabel();
        months = new javax.swing.JComboBox<>();
        yeartextsale = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        Yearly = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        yeartablesale = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        monthlysum1 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        selectyear = new com.toedter.calendar.JYearChooser();
        jButton35 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        inventory_reports = new javax.swing.JPanel();
        bodyofinventorylog = new javax.swing.JPanel();
        Daily1 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        InventoryDaily = new javax.swing.JTable();
        selected = new javax.swing.JLabel();
        totalIn_outText = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        date_inven_daily = new com.toedter.calendar.JDateChooser();
        jButton29 = new javax.swing.JButton();
        select_stock_in_out = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        jButton36 = new javax.swing.JButton();
        Monthly1 = new javax.swing.JPanel();
        selectMonthly_In_out = new javax.swing.JComboBox<>();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        selected1 = new javax.swing.JLabel();
        totalMonthlyIn_out = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        InvenMonthlyTable = new javax.swing.JTable();
        jLabel57 = new javax.swing.JLabel();
        monthlyInven = new javax.swing.JComboBox<>();
        yearInven = new com.toedter.calendar.JYearChooser();
        textinvenmonthly = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        Yearly1 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        InvenYearlytable = new javax.swing.JTable();
        yearInven1 = new com.toedter.calendar.JYearChooser();
        selectYearly = new javax.swing.JComboBox<>();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        selected2 = new javax.swing.JLabel();
        totalYearlySum = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jButton38 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        reports = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        inventoryStocks = new javax.swing.JPanel();
        stockIN_Out = new javax.swing.JPanel();
        stock_in = new javax.swing.JPanel();
        pIDs = new javax.swing.JTextField();
        pnames = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        pcat = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        qtyss = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        In_BTN = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        date_In = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        stock_out = new javax.swing.JPanel();
        product_ID = new javax.swing.JTextField();
        products_name = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        category_product = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        avs = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Out_Stock = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        date_out = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        qtys = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        inven_stock_table = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        searchInven = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        stock_btn_in = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 589));
        setSize(new java.awt.Dimension(900, 589));
        getContentPane().setLayout(null);

        footercolor.setBackground(new java.awt.Color(255, 255, 0));
        footercolor.setMaximumSize(new java.awt.Dimension(900, 40));

        times.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        times.setForeground(new java.awt.Color(255, 255, 255));
        times.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        textlogin.setForeground(new java.awt.Color(255, 255, 255));

        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel61.setText("Welcome !");

        javax.swing.GroupLayout footercolorLayout = new javax.swing.GroupLayout(footercolor);
        footercolor.setLayout(footercolorLayout);
        footercolorLayout.setHorizontalGroup(
            footercolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footercolorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(datescashier, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(times, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
            .addGroup(footercolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footercolorLayout.createSequentialGroup()
                    .addContainerGap(745, Short.MAX_VALUE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        footercolorLayout.setVerticalGroup(
            footercolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(times, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(textlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(footercolorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datescashier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(footercolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );

        getContentPane().add(footercolor);
        footercolor.setBounds(0, 550, 900, 60);

        head.setBackground(new java.awt.Color(255, 255, 0));
        head.setLayout(null);

        inven_pro.setBackground(new java.awt.Color(255, 255, 255));
        inven_pro.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 14)); // NOI18N
        inven_pro.setText("Add Product");
        inven_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven_proActionPerformed(evt);
            }
        });
        head.add(inven_pro);
        inven_pro.setBounds(250, 50, 140, 26);

        inven_stock.setBackground(new java.awt.Color(255, 255, 255));
        inven_stock.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 14)); // NOI18N
        inven_stock.setText("Inventory Stocks");
        inven_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inven_stockActionPerformed(evt);
            }
        });
        head.add(inven_stock);
        inven_stock.setBounds(400, 50, 170, 26);

        Casher.setBackground(new java.awt.Color(255, 255, 255));
        Casher.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 14)); // NOI18N
        Casher.setText("Cashering");
        Casher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CasherActionPerformed(evt);
            }
        });
        head.add(Casher);
        Casher.setBounds(580, 50, 130, 26);

        report.setBackground(new java.awt.Color(255, 255, 255));
        report.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 14)); // NOI18N
        report.setText("Reports");
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });
        head.add(report);
        report.setBounds(720, 50, 94, 27);

        logingout.setBackground(new java.awt.Color(255, 255, 255));
        logingout.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 8)); // NOI18N
        logingout.setText("Logout");
        logingout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logingoutActionPerformed(evt);
            }
        });
        head.add(logingout);
        logingout.setBounds(830, 80, 70, 20);

        userText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        userText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        head.add(userText);
        userText.setBounds(710, 10, 180, 30);

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/tttttttt.png"))); // NOI18N
        head.add(jLabel59);
        jLabel59.setBounds(40, 0, 120, 100);

        getContentPane().add(head);
        head.setBounds(0, 0, 900, 100);

        body.setMaximumSize(new java.awt.Dimension(900, 450));
        body.setLayout(new java.awt.CardLayout());

        home.setMaximumSize(new java.awt.Dimension(900, 450));
        home.setMinimumSize(new java.awt.Dimension(900, 450));
        home.setPreferredSize(new java.awt.Dimension(900, 450));
        home.setLayout(null);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/3.jpg"))); // NOI18N
        home.add(jLabel20);
        jLabel20.setBounds(0, 0, 900, 450);

        body.add(home, "card5");

        Cashering.setBackground(new java.awt.Color(36, 37, 42));
        Cashering.setMaximumSize(new java.awt.Dimension(900, 450));
        Cashering.setMinimumSize(new java.awt.Dimension(900, 450));
        Cashering.setPreferredSize(new java.awt.Dimension(900, 450));
        Cashering.setLayout(null);

        listed.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        listed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "QTY", "PRICE", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listed.getTableHeader().setReorderingAllowed(false);
        listed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listedMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listed);
        if (listed.getColumnModel().getColumnCount() > 0) {
            listed.getColumnModel().getColumn(0).setResizable(false);
            listed.getColumnModel().getColumn(1).setResizable(false);
            listed.getColumnModel().getColumn(2).setResizable(false);
            listed.getColumnModel().getColumn(3).setResizable(false);
            listed.getColumnModel().getColumn(4).setResizable(false);
        }

        Cashering.add(jScrollPane3);
        jScrollPane3.setBounds(520, 140, 360, 139);

        searching.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searching.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchingKeyTyped(evt);
            }
        });
        Cashering.add(searching);
        searching.setBounds(148, 17, 221, 35);

        jLabel13.setForeground(new java.awt.Color(252, 252, 252));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/search.png"))); // NOI18N
        Cashering.add(jLabel13);
        jLabel13.setBounds(108, 17, 30, 35);

        jLabel14.setForeground(new java.awt.Color(252, 252, 252));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Product Code");
        Cashering.add(jLabel14);
        jLabel14.setBounds(536, 10, 100, 25);

        pID.setEditable(false);
        pID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Cashering.add(pID);
        pID.setBounds(520, 40, 120, 31);

        Pname.setEditable(false);
        Pname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PnameActionPerformed(evt);
            }
        });
        Cashering.add(Pname);
        Pname.setBounds(649, 40, 230, 31);

        jLabel15.setForeground(new java.awt.Color(252, 252, 252));
        jLabel15.setText("Product Name");
        Cashering.add(jLabel15);
        jLabel15.setBounds(650, 10, 130, 25);

        addCart.setBackground(new java.awt.Color(0, 153, 153));
        addCart.setForeground(new java.awt.Color(255, 255, 255));
        addCart.setText("Add Cart");
        addCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCartActionPerformed(evt);
            }
        });
        Cashering.add(addCart);
        addCart.setBounds(760, 90, 120, 40);

        p_order.setEditable(false);
        p_order.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Cashering.add(p_order);
        p_order.setBounds(610, 100, 140, 31);

        jLabel16.setForeground(new java.awt.Color(252, 252, 252));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("QTY");
        Cashering.add(jLabel16);
        jLabel16.setBounds(540, 70, 60, 25);

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setForeground(new java.awt.Color(51, 0, 0));
        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        Cashering.add(jButton10);
        jButton10.setBounds(670, 290, 100, 40);

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setForeground(new java.awt.Color(51, 0, 51));
        jButton11.setText("Reset");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        Cashering.add(jButton11);
        jButton11.setBounds(780, 290, 100, 40);

        sumTotal.setEditable(false);
        sumTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sumTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumTotalActionPerformed(evt);
            }
        });
        Cashering.add(sumTotal);
        sumTotal.setBounds(610, 400, 140, 40);

        qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Cashering.add(qty);
        qty.setBounds(520, 100, 80, 31);

        jLabel25.setForeground(new java.awt.Color(252, 252, 252));
        jLabel25.setText("PRICE");
        Cashering.add(jLabel25);
        jLabel25.setBounds(610, 70, 130, 25);

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setForeground(new java.awt.Color(51, 0, 0));
        jButton12.setText("Print");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        Cashering.add(jButton12);
        jButton12.setBounds(760, 400, 120, 40);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(252, 252, 252));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Code #");
        Cashering.add(jLabel26);
        jLabel26.setBounds(520, 290, 70, 40);

        idlisted.setEditable(false);
        idlisted.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Cashering.add(idlisted);
        idlisted.setBounds(590, 290, 70, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/php.png"))); // NOI18N
        Cashering.add(jLabel3);
        jLabel3.setBounds(550, 390, 60, 60);

        pnamelabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnamelabel.setForeground(new java.awt.Color(255, 255, 255));
        Cashering.add(pnamelabel);
        pnamelabel.setBounds(100, 360, 220, 30);

        ammount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ammount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ammountKeyReleased(evt);
            }
        });
        Cashering.add(ammount);
        ammount.setBounds(520, 340, 130, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cash:");
        Cashering.add(jLabel2);
        jLabel2.setBounds(470, 340, 50, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Serving:");
        Cashering.add(jLabel4);
        jLabel4.setBounds(10, 360, 90, 17);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        Cashering.add(jLabel18);
        jLabel18.setBounds(170, 440, 350, 25);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Change:");
        Cashering.add(jLabel19);
        jLabel19.setBounds(650, 340, 80, 40);

        change.setEditable(false);
        change.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Cashering.add(change);
        change.setBounds(730, 340, 150, 41);

        text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        text.setForeground(new java.awt.Color(255, 255, 255));
        Cashering.add(text);
        text.setBounds(100, 390, 260, 30);

        nameofproduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameofproduct.setForeground(new java.awt.Color(255, 255, 255));
        Cashering.add(nameofproduct);
        nameofproduct.setBounds(100, 380, 340, 0);

        availableStocks1.setEditable(false);
        availableStocks1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cashering.add(availableStocks1);
        availableStocks1.setBounds(410, 20, 70, 30);

        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("Available Stocks:");
        Cashering.add(jLabel74);
        jLabel74.setBounds(390, 4, 110, 20);

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setForeground(new java.awt.Color(51, 0, 0));
        jButton13.setText("Reprint");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        Cashering.add(jButton13);
        jButton13.setBounds(390, 410, 120, 30);

        casherTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        casherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Category", "Price", "Serving", "QTY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        casherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                casherTableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(casherTable);

        Cashering.add(jScrollPane9);
        jScrollPane9.setBounds(10, 60, 500, 280);

        body.add(Cashering, "card4");

        inventoryProduct.setBackground(new java.awt.Color(36, 37, 42));
        inventoryProduct.setMaximumSize(new java.awt.Dimension(900, 450));
        inventoryProduct.setMinimumSize(new java.awt.Dimension(900, 450));
        inventoryProduct.setPreferredSize(new java.awt.Dimension(900, 450));
        inventoryProduct.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(252, 252, 252));
        jLabel1.setForeground(new java.awt.Color(252, 252, 252));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/search.png"))); // NOI18N
        inventoryProduct.add(jLabel1);
        jLabel1.setBounds(450, 30, 30, 30);

        sort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sortKeyTyped(evt);
            }
        });
        inventoryProduct.add(sort);
        sort.setBounds(490, 30, 214, 30);

        table = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Category", "Portion", "Serving", "Price", "QTY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setToolTipText("");
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        inventoryProduct.add(jScrollPane1);
        jScrollPane1.setBounds(250, 70, 624, 309);
        inventoryProduct.add(pn);
        pn.setBounds(70, 60, 160, 31);

        id.setEditable(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        inventoryProduct.add(id);
        id.setBounds(20, 60, 47, 30);

        jLabel5.setBackground(new java.awt.Color(252, 252, 252));
        jLabel5.setForeground(new java.awt.Color(252, 252, 252));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Pcode");
        inventoryProduct.add(jLabel5);
        jLabel5.setBounds(20, 30, 48, 20);

        jLabel6.setBackground(new java.awt.Color(252, 252, 252));
        jLabel6.setForeground(new java.awt.Color(252, 252, 252));
        jLabel6.setText("Category");
        inventoryProduct.add(jLabel6);
        jLabel6.setBounds(20, 90, 101, 20);
        inventoryProduct.add(cat);
        cat.setBounds(20, 120, 211, 31);

        jLabel7.setBackground(new java.awt.Color(252, 252, 252));
        jLabel7.setForeground(new java.awt.Color(252, 252, 252));
        jLabel7.setText("Product Name");
        inventoryProduct.add(jLabel7);
        jLabel7.setBounds(70, 30, 157, 20);

        jLabel8.setBackground(new java.awt.Color(252, 252, 252));
        jLabel8.setForeground(new java.awt.Color(252, 252, 252));
        jLabel8.setText("Portion");
        inventoryProduct.add(jLabel8);
        jLabel8.setBounds(20, 150, 101, 30);
        inventoryProduct.add(por);
        por.setBounds(20, 180, 211, 31);

        jLabel9.setBackground(new java.awt.Color(252, 252, 252));
        jLabel9.setForeground(new java.awt.Color(252, 252, 252));
        jLabel9.setText("Serving");
        inventoryProduct.add(jLabel9);
        jLabel9.setBounds(20, 210, 101, 30);
        inventoryProduct.add(ser);
        ser.setBounds(20, 240, 211, 31);

        jLabel10.setBackground(new java.awt.Color(252, 252, 252));
        jLabel10.setForeground(new java.awt.Color(252, 252, 252));
        jLabel10.setText("Price");
        inventoryProduct.add(jLabel10);
        jLabel10.setBounds(20, 270, 101, 30);
        inventoryProduct.add(pri);
        pri.setBounds(20, 300, 211, 31);

        insert.setBackground(new java.awt.Color(0, 153, 0));
        insert.setForeground(new java.awt.Color(255, 255, 255));
        insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/add.png"))); // NOI18N
        insert.setText("Add");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        inventoryProduct.add(insert);
        insert.setBounds(70, 400, 110, 40);

        delete.setBackground(new java.awt.Color(255, 51, 51));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/remove.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        inventoryProduct.add(delete);
        delete.setBounds(750, 390, 120, 38);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        inventoryProduct.add(jButton3);
        jButton3.setBounds(260, 390, 80, 38);

        jLabel24.setBackground(new java.awt.Color(252, 252, 252));
        jLabel24.setForeground(new java.awt.Color(252, 252, 252));
        jLabel24.setText("QTY");
        inventoryProduct.add(jLabel24);
        jLabel24.setBounds(20, 330, 101, 30);
        inventoryProduct.add(productqty);
        productqty.setBounds(20, 360, 210, 31);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Note: Select on table. To delete or update");
        inventoryProduct.add(jLabel12);
        jLabel12.setBounds(340, 400, 280, 20);

        body.add(inventoryProduct, "card2");

        orderprint.setMaximumSize(new java.awt.Dimension(900, 450));
        orderprint.setMinimumSize(new java.awt.Dimension(900, 450));
        orderprint.setLayout(null);

        printbg.setMaximumSize(new java.awt.Dimension(360, 450));
        printbg.setMinimumSize(new java.awt.Dimension(360, 450));
        printbg.setLayout(null);

        printTextArea.setEditable(false);
        printTextArea.setColumns(20);
        printTextArea.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        printTextArea.setRows(5);
        jScrollPane2.setViewportView(printTextArea);

        printbg.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 290, 428);

        orderprint.add(printbg);
        printbg.setBounds(290, 0, 310, 450);

        jButton14.setBackground(new java.awt.Color(0, 204, 102));
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/print.png"))); // NOI18N
        jButton14.setText("Print");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        orderprint.add(jButton14);
        jButton14.setBounds(760, 400, 120, 40);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b - Copy.jpg"))); // NOI18N
        orderprint.add(jLabel23);
        jLabel23.setBounds(0, 0, 900, 450);

        body.add(orderprint, "card7");

        manageusers.setBackground(new java.awt.Color(36, 37, 42));
        manageusers.setMaximumSize(new java.awt.Dimension(900, 450));
        manageusers.setMinimumSize(new java.awt.Dimension(900, 450));
        manageusers.setPreferredSize(new java.awt.Dimension(900, 450));
        manageusers.setLayout(null);

        users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Middle Name", "Last Name", "Address", "Age", "User", "Password", "Gender", "User Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(users);

        manageusers.add(jScrollPane8);
        jScrollPane8.setBounds(22, 65, 850, 180);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("First Name:");
        manageusers.add(jLabel36);
        jLabel36.setBounds(30, 260, 70, 15);
        manageusers.add(fn);
        fn.setBounds(30, 280, 180, 30);
        manageusers.add(mn);
        mn.setBounds(30, 340, 180, 30);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Middle Name:");
        manageusers.add(jLabel37);
        jLabel37.setBounds(30, 320, 100, 15);
        manageusers.add(ln);
        ln.setBounds(30, 400, 180, 30);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Last Name:");
        manageusers.add(jLabel38);
        jLabel38.setBounds(30, 380, 70, 15);
        manageusers.add(ad);
        ad.setBounds(230, 280, 180, 30);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Address:");
        manageusers.add(jLabel39);
        jLabel39.setBounds(230, 260, 70, 15);
        manageusers.add(age);
        age.setBounds(230, 340, 180, 30);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Age:");
        manageusers.add(jLabel44);
        jLabel44.setBounds(230, 320, 70, 15);

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Username:");
        manageusers.add(jLabel49);
        jLabel49.setBounds(430, 260, 70, 15);

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Password:");
        manageusers.add(jLabel50);
        jLabel50.setBounds(430, 320, 70, 15);
        manageusers.add(user);
        user.setBounds(430, 280, 180, 30);
        manageusers.add(pass);
        pass.setBounds(430, 340, 180, 30);

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(252, 252, 252));
        jLabel51.setText("Gender:");
        manageusers.add(jLabel51);
        jLabel51.setBounds(230, 380, 49, 17);

        gen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        manageusers.add(gen);
        gen.setBounds(230, 400, 110, 28);

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(252, 252, 252));
        jLabel52.setText("User Type:");
        manageusers.add(jLabel52);
        jLabel52.setBounds(430, 380, 67, 17);

        usertype.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Casher" }));
        usertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertypeActionPerformed(evt);
            }
        });
        manageusers.add(usertype);
        usertype.setBounds(430, 400, 110, 28);

        update_user.setBackground(new java.awt.Color(255, 255, 255));
        update_user.setText("Update");
        update_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_userActionPerformed(evt);
            }
        });
        manageusers.add(update_user);
        update_user.setBounds(750, 390, 120, 40);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Manage Users");
        manageusers.add(jLabel53);
        jLabel53.setBounds(280, 10, 330, 40);

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("ID:");
        manageusers.add(jLabel54);
        jLabel54.setBounds(620, 390, 50, 40);

        idtext.setEditable(false);
        idtext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idtext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtextActionPerformed(evt);
            }
        });
        manageusers.add(idtext);
        idtext.setBounds(660, 390, 70, 40);

        jButton19.setText("Add Account");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        manageusers.add(jButton19);
        jButton19.setBounds(710, 260, 160, 60);

        Delete.setBackground(new java.awt.Color(255, 255, 255));
        Delete.setForeground(new java.awt.Color(51, 0, 51));
        Delete.setText("Delete");
        Delete.setDefaultCapable(false);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        manageusers.add(Delete);
        Delete.setBounds(750, 341, 120, 40);

        body.add(manageusers, "card11");

        signupuser.setBackground(new java.awt.Color(36, 37, 42));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(252, 252, 252));
        jLabel62.setText("First Name:");

        fn1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(252, 252, 252));
        jLabel63.setText("Middle Name:");

        mn1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn1ActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(252, 252, 252));
        jLabel64.setText("Last name:");

        ln1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(252, 252, 252));
        jLabel65.setText("Address:");

        ad1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(252, 252, 252));
        jLabel66.setText("Age:");

        age1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(252, 252, 252));
        jLabel67.setText("Gender:");

        gen1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gen1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(252, 252, 252));
        jLabel68.setText("Username:");

        user1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(252, 252, 252));
        jLabel69.setText("Password:");

        pass1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass1ActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(252, 252, 252));
        jLabel70.setText("User Type:");

        ClearField.setBackground(new java.awt.Color(255, 255, 255));
        ClearField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ClearField.setText("Clear");
        ClearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearFieldActionPerformed(evt);
            }
        });

        usertype1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usertype1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Casher" }));

        createuser.setBackground(new java.awt.Color(252, 252, 252));
        createuser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createuser.setText("Create");
        createuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createuserActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(252, 252, 252));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/back.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        showP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/eyeclose.png"))); // NOI18N
        showP.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/eyeopen.png"))); // NOI18N
        showP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPActionPerformed(evt);
            }
        });

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/user.png"))); // NOI18N

        jLabel72.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("Add User");

        javax.swing.GroupLayout signupuserLayout = new javax.swing.GroupLayout(signupuser);
        signupuser.setLayout(signupuserLayout);
        signupuserLayout.setHorizontalGroup(
            signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupuserLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ln1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mn1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(signupuserLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signupuserLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(signupuserLayout.createSequentialGroup()
                                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(age1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ad1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(signupuserLayout.createSequentialGroup()
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gen1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signupuserLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClearField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signupuserLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(signupuserLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(signupuserLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usertype1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(signupuserLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(signupuserLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(createuser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(signupuserLayout.createSequentialGroup()
                    .addContainerGap(596, Short.MAX_VALUE)
                    .addComponent(user1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(showP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 26, Short.MAX_VALUE)))
        );
        signupuserLayout.setVerticalGroup(
            signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupuserLayout.createSequentialGroup()
                .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(signupuserLayout.createSequentialGroup()
                        .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(signupuserLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(signupuserLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(signupuserLayout.createSequentialGroup()
                                .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(age1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(156, 156, 156))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupuserLayout.createSequentialGroup()
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel70)
                                    .addComponent(usertype1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55))))
                    .addGroup(signupuserLayout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addGap(18, 18, 18)
                        .addComponent(fn1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mn1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ad1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gen1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signupuserLayout.createSequentialGroup()
                        .addComponent(ln1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupuserLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ClearField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(createuser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(signupuserLayout.createSequentialGroup()
                    .addGap(130, 158, Short.MAX_VALUE)
                    .addGroup(signupuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupuserLayout.createSequentialGroup()
                            .addComponent(user1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70))
                        .addComponent(showP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 181, Short.MAX_VALUE)))
        );

        body.add(signupuser, "card13");

        viewlog.setBackground(new java.awt.Color(36, 37, 42));
        viewlog.setMaximumSize(new java.awt.Dimension(900, 450));
        viewlog.setMinimumSize(new java.awt.Dimension(900, 450));
        viewlog.setPreferredSize(new java.awt.Dimension(900, 450));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        viewlogtables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Details", "User"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(viewlogtables);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Logs Reports");

        javax.swing.GroupLayout viewlogLayout = new javax.swing.GroupLayout(viewlog);
        viewlog.setLayout(viewlogLayout);
        viewlogLayout.setHorizontalGroup(
            viewlogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewlogLayout.createSequentialGroup()
                .addGroup(viewlogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewlogLayout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewlogLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewlogLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        viewlogLayout.setVerticalGroup(
            viewlogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewlogLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        body.add(viewlog, "card12");

        salesreports.setBackground(new java.awt.Color(36, 37, 42));
        salesreports.setMaximumSize(new java.awt.Dimension(900, 450));
        salesreports.setMinimumSize(new java.awt.Dimension(900, 450));
        salesreports.setLayout(null);

        bodyofsales.setBackground(new java.awt.Color(36, 37, 42));
        bodyofsales.setLayout(new java.awt.CardLayout());

        Daily.setBackground(new java.awt.Color(36, 37, 42));
        Daily.setLayout(null);

        TableDailySales = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TableDailySales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Date", "Qty", "Price", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TableDailySales);

        Daily.add(jScrollPane6);
        jScrollPane6.setBounds(10, 74, 880, 326);

        date2.setDateFormatString("yyyy-MM,dd");
        Daily.add(date2);
        date2.setBounds(40, 30, 146, 30);

        jButton5.setText("SEARCH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Daily.add(jButton5);
        jButton5.setBounds(200, 30, 100, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total Daily Sales:  P");
        Daily.add(jLabel11);
        jLabel11.setBounds(549, 28, 160, 40);

        dailysum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dailysum.setForeground(new java.awt.Color(255, 255, 255));
        Daily.add(dailysum);
        dailysum.setBounds(710, 30, 183, 36);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/excel.png"))); // NOI18N
        jButton8.setText("Export");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Daily.add(jButton8);
        jButton8.setBounds(420, 30, 100, 30);

        daydate.setBackground(new java.awt.Color(36, 37, 42));
        daydate.setForeground(new java.awt.Color(255, 255, 255));
        daydate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Daily.add(daydate);
        daydate.setBounds(550, 10, 190, 20);

        jButton18.setBackground(new java.awt.Color(0, 204, 102));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/print.png"))); // NOI18N
        jButton18.setText("Print");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        Daily.add(jButton18);
        jButton18.setBounds(310, 30, 100, 30);

        bodyofsales.add(Daily, "card4");

        Monthly.setBackground(new java.awt.Color(36, 37, 42));
        Monthly.setLayout(null);
        Monthly.add(yearsales);
        yearsales.setBounds(150, 30, 90, 30);

        monthsaletable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        monthsaletable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Date", "Qty", "Price", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(monthsaletable);

        Monthly.add(jScrollPane10);
        jScrollPane10.setBounds(10, 74, 880, 326);

        jButton20.setText("SEARCH");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        Monthly.add(jButton20);
        jButton20.setBounds(250, 30, 100, 30);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Total Monthly Sales:");
        Monthly.add(jLabel27);
        jLabel27.setBounds(580, 30, 140, 30);

        monthlysum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        monthlysum.setForeground(new java.awt.Color(255, 255, 255));
        Monthly.add(monthlysum);
        monthlysum.setBounds(730, 30, 160, 36);

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/excel.png"))); // NOI18N
        jButton26.setText("Export");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        Monthly.add(jButton26);
        jButton26.setBounds(470, 30, 100, 30);

        monthtext.setBackground(new java.awt.Color(36, 37, 42));
        monthtext.setForeground(new java.awt.Color(255, 255, 255));
        monthtext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Monthly.add(monthtext);
        monthtext.setBounds(660, 10, 40, 20);

        months.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        Monthly.add(months);
        months.setBounds(20, 30, 120, 30);

        yeartextsale.setBackground(new java.awt.Color(36, 37, 42));
        yeartextsale.setForeground(new java.awt.Color(255, 255, 255));
        yeartextsale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Monthly.add(yeartextsale);
        yeartextsale.setBounds(560, 10, 100, 20);

        jButton34.setBackground(new java.awt.Color(0, 204, 102));
        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/print.png"))); // NOI18N
        jButton34.setText("Print");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        Monthly.add(jButton34);
        jButton34.setBounds(360, 30, 100, 30);

        bodyofsales.add(Monthly, "card3");

        Yearly.setBackground(new java.awt.Color(36, 37, 42));

        yeartablesale = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        yeartablesale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Date", "Qty", "Price", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(yeartablesale);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Total Monthly Sales:");

        monthlysum1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        monthlysum1.setForeground(new java.awt.Color(255, 255, 255));

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/excel.png"))); // NOI18N
        jButton27.setText("Export");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("SEARCH");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(0, 204, 102));
        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/print.png"))); // NOI18N
        jButton35.setText("Print");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout YearlyLayout = new javax.swing.GroupLayout(Yearly);
        Yearly.setLayout(YearlyLayout);
        YearlyLayout.setHorizontalGroup(
            YearlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YearlyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(YearlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(YearlyLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(selectyear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(YearlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(YearlyLayout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(monthlysum1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        YearlyLayout.setVerticalGroup(
            YearlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, YearlyLayout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(YearlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(YearlyLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(YearlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(YearlyLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(monthlysum1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(YearlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(selectyear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, YearlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bodyofsales.add(Yearly, "card2");

        salesreports.add(bodyofsales);
        bodyofsales.setBounds(0, 0, 900, 400);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jButton1.setText("Yearly Sales");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(550, 10, 180, 30);

        jButton4.setText("Daily Sales");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(170, 10, 180, 30);

        jButton6.setText("Monthly Sales");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);
        jButton6.setBounds(360, 10, 180, 30);

        salesreports.add(jPanel4);
        jPanel4.setBounds(10, 400, 880, 50);

        body.add(salesreports, "card8");

        inventory_reports.setBackground(new java.awt.Color(36, 37, 42));
        inventory_reports.setMaximumSize(new java.awt.Dimension(900, 450));
        inventory_reports.setMinimumSize(new java.awt.Dimension(900, 450));
        inventory_reports.setPreferredSize(new java.awt.Dimension(900, 450));
        inventory_reports.setLayout(null);

        bodyofinventorylog.setBackground(new java.awt.Color(36, 37, 42));
        bodyofinventorylog.setLayout(new java.awt.CardLayout());

        Daily1.setBackground(new java.awt.Color(36, 37, 42));
        Daily1.setLayout(null);

        InventoryDaily = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        InventoryDaily.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Category", "Qty", "Date", "Stock In_Out"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(InventoryDaily);

        Daily1.add(jScrollPane11);
        jScrollPane11.setBounds(60, 74, 780, 280);

        selected.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selected.setForeground(new java.awt.Color(255, 255, 255));
        selected.setText("Total Daily :");
        Daily1.add(selected);
        selected.setBounds(650, 30, 80, 30);

        totalIn_outText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalIn_outText.setForeground(new java.awt.Color(255, 255, 255));
        totalIn_outText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Daily1.add(totalIn_outText);
        totalIn_outText.setBounds(730, 30, 130, 30);

        jButton21.setText("Search");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        Daily1.add(jButton21);
        jButton21.setBounds(310, 30, 100, 30);

        date_inven_daily.setDateFormatString("yyyy,MM,dd");
        date_inven_daily.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Daily1.add(date_inven_daily);
        date_inven_daily.setBounds(60, 30, 130, 30);

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/excel.png"))); // NOI18N
        jButton29.setText("Export");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        Daily1.add(jButton29);
        jButton29.setBounds(530, 30, 100, 30);

        select_stock_in_out.setEditable(true);
        select_stock_in_out.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        select_stock_in_out.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stock In", "Stock Out" }));
        select_stock_in_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_stock_in_outActionPerformed(evt);
            }
        });
        Daily1.add(select_stock_in_out);
        select_stock_in_out.setBounds(200, 30, 100, 30);

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("DAILY STOCK IN AND STOCK OUT");
        Daily1.add(jLabel56);
        jLabel56.setBounds(270, 360, 370, 30);

        jButton36.setBackground(new java.awt.Color(0, 204, 102));
        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/print.png"))); // NOI18N
        jButton36.setText("Print");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        Daily1.add(jButton36);
        jButton36.setBounds(420, 30, 100, 30);

        bodyofinventorylog.add(Daily1, "card4");

        Monthly1.setBackground(new java.awt.Color(36, 37, 42));
        Monthly1.setForeground(new java.awt.Color(255, 255, 255));
        Monthly1.setLayout(null);

        selectMonthly_In_out.setEditable(true);
        selectMonthly_In_out.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectMonthly_In_out.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stock In", "Stock Out" }));
        Monthly1.add(selectMonthly_In_out);
        selectMonthly_In_out.setBounds(230, 30, 90, 30);

        jButton30.setText("Search");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        Monthly1.add(jButton30);
        jButton30.setBounds(330, 30, 100, 30);

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/excel.png"))); // NOI18N
        jButton31.setText("Export");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        Monthly1.add(jButton31);
        jButton31.setBounds(550, 30, 100, 30);

        selected1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selected1.setForeground(new java.awt.Color(255, 255, 255));
        selected1.setText("Total Monthly :");
        Monthly1.add(selected1);
        selected1.setBounds(650, 30, 100, 30);

        totalMonthlyIn_out.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalMonthlyIn_out.setForeground(new java.awt.Color(255, 255, 255));
        totalMonthlyIn_out.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Monthly1.add(totalMonthlyIn_out);
        totalMonthlyIn_out.setBounds(750, 30, 120, 30);

        InvenMonthlyTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        InvenMonthlyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Category", "Qty", "Date", "Stock In_Out"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(InvenMonthlyTable);

        Monthly1.add(jScrollPane15);
        jScrollPane15.setBounds(60, 74, 780, 280);

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("MONTHLY STOCK IN AND STOCK OUT");
        Monthly1.add(jLabel57);
        jLabel57.setBounds(270, 360, 370, 30);

        monthlyInven.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        monthlyInven.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        Monthly1.add(monthlyInven);
        monthlyInven.setBounds(40, 30, 100, 30);
        Monthly1.add(yearInven);
        yearInven.setBounds(150, 30, 70, 30);

        textinvenmonthly.setForeground(new java.awt.Color(255, 255, 255));
        textinvenmonthly.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Monthly1.add(textinvenmonthly);
        textinvenmonthly.setBounds(590, 10, 140, 0);

        jButton37.setBackground(new java.awt.Color(0, 204, 102));
        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/print.png"))); // NOI18N
        jButton37.setText("Print");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        Monthly1.add(jButton37);
        jButton37.setBounds(440, 30, 100, 30);

        bodyofinventorylog.add(Monthly1, "card3");

        Yearly1.setBackground(new java.awt.Color(36, 37, 42));

        InvenYearlytable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        InvenYearlytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Category", "Qty", "Date", "Stock In_Out"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane16.setViewportView(InvenYearlytable);

        selectYearly.setEditable(true);
        selectYearly.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectYearly.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stock In", "Stock Out" }));

        jButton32.setText("Search");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/excel.png"))); // NOI18N
        jButton33.setText("Export");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        selected2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selected2.setForeground(new java.awt.Color(255, 255, 255));
        selected2.setText("Total Yearly:");

        totalYearlySum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalYearlySum.setForeground(new java.awt.Color(255, 255, 255));
        totalYearlySum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("YEARLY STOCK IN AND STOCK OUT");

        jButton38.setBackground(new java.awt.Color(0, 204, 102));
        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/print.png"))); // NOI18N
        jButton38.setText("Print");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Yearly1Layout = new javax.swing.GroupLayout(Yearly1);
        Yearly1.setLayout(Yearly1Layout);
        Yearly1Layout.setHorizontalGroup(
            Yearly1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Yearly1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(Yearly1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Yearly1Layout.createSequentialGroup()
                        .addComponent(yearInven1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectYearly, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(selected2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(totalYearlySum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Yearly1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        Yearly1Layout.setVerticalGroup(
            Yearly1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Yearly1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(Yearly1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Yearly1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectYearly, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Yearly1Layout.createSequentialGroup()
                        .addGroup(Yearly1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Yearly1Layout.createSequentialGroup()
                                .addGroup(Yearly1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selected2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalYearlySum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Yearly1Layout.createSequentialGroup()
                                .addComponent(yearInven1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        bodyofinventorylog.add(Yearly1, "card2");

        inventory_reports.add(bodyofinventorylog);
        bodyofinventorylog.setBounds(0, 0, 900, 400);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(null);

        jButton15.setText("Yearly Inventory");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton15);
        jButton15.setBounds(550, 10, 180, 30);

        jButton16.setText("Daily Inventory");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton16);
        jButton16.setBounds(170, 10, 180, 30);

        jButton17.setText("Monthly Inventory");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton17);
        jButton17.setBounds(360, 10, 180, 30);

        inventory_reports.add(jPanel10);
        jPanel10.setBounds(10, 400, 880, 50);

        body.add(inventory_reports, "card8");

        reports.setBackground(new java.awt.Color(36, 37, 42));
        reports.setMaximumSize(new java.awt.Dimension(900, 450));
        reports.setMinimumSize(new java.awt.Dimension(900, 450));
        reports.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(22, 23, 25));
        jPanel5.setLayout(null);

        jButton22.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jButton22.setText("MANAGE USER");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton22);
        jButton22.setBounds(130, 90, 160, 80);

        jButton23.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jButton23.setText("INVENTORY REPORT");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton23);
        jButton23.setBounds(310, 60, 190, 120);

        jButton24.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jButton24.setText("SALES REPORT");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton24);
        jButton24.setBounds(520, 90, 160, 80);

        reports.add(jPanel5);
        jPanel5.setBounds(30, 140, 820, 230);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("View Reports");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel55)
                .addContainerGap())
        );

        reports.add(jPanel1);
        jPanel1.setBounds(320, 60, 290, 50);

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setText("View Logs");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        reports.add(jButton9);
        jButton9.setBounds(370, 400, 150, 23);

        body.add(reports, "card10");

        inventoryStocks.setBackground(new java.awt.Color(36, 37, 42));
        inventoryStocks.setForeground(new java.awt.Color(204, 102, 0));
        inventoryStocks.setMaximumSize(new java.awt.Dimension(900, 450));
        inventoryStocks.setMinimumSize(new java.awt.Dimension(900, 450));
        inventoryStocks.setPreferredSize(new java.awt.Dimension(900, 450));

        stockIN_Out.setMaximumSize(new java.awt.Dimension(350, 350));
        stockIN_Out.setMinimumSize(new java.awt.Dimension(350, 350));
        stockIN_Out.setPreferredSize(new java.awt.Dimension(350, 350));
        stockIN_Out.setLayout(new java.awt.CardLayout());

        stock_in.setBackground(new java.awt.Color(255, 255, 255));
        stock_in.setMaximumSize(new java.awt.Dimension(350, 350));
        stock_in.setMinimumSize(new java.awt.Dimension(350, 350));
        stock_in.setLayout(null);

        pIDs.setEditable(false);
        stock_in.add(pIDs);
        pIDs.setBounds(40, 80, 84, 35);

        pnames.setEditable(false);
        stock_in.add(pnames);
        pnames.setBounds(40, 150, 270, 37);

        jLabel40.setText("Product Name:");
        stock_in.add(jLabel40);
        jLabel40.setBounds(40, 120, 270, 34);

        jLabel41.setText("Category:");
        stock_in.add(jLabel41);
        jLabel41.setBounds(40, 190, 270, 34);

        pcat.setEditable(false);
        stock_in.add(pcat);
        pcat.setBounds(40, 220, 270, 37);

        jLabel42.setText("Product Code:");
        stock_in.add(jLabel42);
        jLabel42.setBounds(40, 60, 80, 20);
        stock_in.add(qtyss);
        qtyss.setBounds(40, 280, 80, 40);

        jLabel43.setText("Quantity:");
        stock_in.add(jLabel43);
        jLabel43.setBounds(40, 260, 270, 14);

        In_BTN.setText("Stocks In");
        In_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                In_BTNActionPerformed(evt);
            }
        });
        stock_in.add(In_BTN);
        In_BTN.setBounds(190, 280, 120, 40);

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/chest_in.png"))); // NOI18N
        jLabel35.setToolTipText("");
        stock_in.add(jLabel35);
        jLabel35.setBounds(180, 0, 160, 140);

        date_In.setDateFormatString("yyyy,MM,dd");
        stock_in.add(date_In);
        date_In.setBounds(40, 30, 130, 30);

        jLabel22.setText("Date:");
        stock_in.add(jLabel22);
        jLabel22.setBounds(40, 10, 70, 14);

        stockIN_Out.add(stock_in, "card3");

        stock_out.setBackground(new java.awt.Color(255, 255, 255));
        stock_out.setMaximumSize(new java.awt.Dimension(350, 350));
        stock_out.setMinimumSize(new java.awt.Dimension(350, 350));
        stock_out.setPreferredSize(new java.awt.Dimension(350, 350));
        stock_out.setLayout(null);

        product_ID.setEditable(false);
        stock_out.add(product_ID);
        product_ID.setBounds(40, 80, 84, 35);

        products_name.setEditable(false);
        stock_out.add(products_name);
        products_name.setBounds(40, 150, 270, 37);

        jLabel29.setText("Product Name:");
        stock_out.add(jLabel29);
        jLabel29.setBounds(40, 120, 270, 34);

        jLabel31.setText("Category:");
        stock_out.add(jLabel31);
        jLabel31.setBounds(40, 190, 270, 34);

        category_product.setEditable(false);
        stock_out.add(category_product);
        category_product.setBounds(40, 220, 270, 37);

        jLabel32.setText("Product Code:");
        stock_out.add(jLabel32);
        jLabel32.setBounds(40, 60, 80, 20);

        avs.setEditable(false);
        stock_out.add(avs);
        avs.setBounds(110, 280, 60, 40);

        jLabel33.setText("Quantity:");
        stock_out.add(jLabel33);
        jLabel33.setBounds(40, 260, 270, 14);

        Out_Stock.setText("Stocks Out");
        Out_Stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Out_StockActionPerformed(evt);
            }
        });
        stock_out.add(Out_Stock);
        Out_Stock.setBounds(190, 280, 120, 40);

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/chest_out.png"))); // NOI18N
        jLabel34.setToolTipText("");
        stock_out.add(jLabel34);
        jLabel34.setBounds(180, 0, 160, 140);

        date_out.setDateFormatString("yyyy,MM,dd");
        stock_out.add(date_out);
        date_out.setBounds(40, 30, 130, 30);

        jLabel21.setText("Date:");
        stock_out.add(jLabel21);
        jLabel21.setBounds(40, 10, 70, 14);

        jLabel73.setText("Available:");
        stock_out.add(jLabel73);
        jLabel73.setBounds(110, 260, 70, 20);
        stock_out.add(qtys);
        qtys.setBounds(40, 280, 60, 40);

        stockIN_Out.add(stock_out, "card3");

        inven_stock_table  = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        inven_stock_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Category", "QTY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inven_stock_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inven_stock_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(inven_stock_table);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/search.png"))); // NOI18N

        searchInven.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchInvenKeyTyped(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tabloid Scuzzball", 0, 18)); // NOI18N
        jButton2.setText("Stock Out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        stock_btn_in.setFont(new java.awt.Font("Tabloid Scuzzball", 0, 18)); // NOI18N
        stock_btn_in.setText("Stock In");
        stock_btn_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_btn_inActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(stock_btn_in, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stock_btn_in, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout inventoryStocksLayout = new javax.swing.GroupLayout(inventoryStocks);
        inventoryStocks.setLayout(inventoryStocksLayout);
        inventoryStocksLayout.setHorizontalGroup(
            inventoryStocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryStocksLayout.createSequentialGroup()
                .addGroup(inventoryStocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventoryStocksLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inventoryStocksLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel28)
                        .addGap(6, 6, 6)
                        .addComponent(searchInven, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(inventoryStocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockIN_Out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );
        inventoryStocksLayout.setVerticalGroup(
            inventoryStocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryStocksLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(inventoryStocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventoryStocksLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockIN_Out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(inventoryStocksLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(inventoryStocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchInven, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        body.add(inventoryStocks, "card3");

        getContentPane().add(body);
        body.setBounds(0, 100, 900, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (!id.getText().equals("")) {

            try {
                con = Connections.getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM inv_products WHERE id = ?");
                int id_products = Integer.parseInt(id.getText());
                ps.setInt(1, id_products);
                ps.executeUpdate();
                Display_on_Table();
                DeleteAddProductLog();
                JOptionPane.showMessageDialog(rootPane, "Has been deleted!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Product not deleted!");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Product not deleted : No ID to delete");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed

        Statement st;
        ResultSet rs;
        String pc = id.getText();
        String pname = pn.getText();
        String categ = cat.getText();
        try {
            st = con.createStatement();

            String query = "SELECT * FROM inv_products WHERE id = '" + pc+ "' AND Product_name = '" + pname + "' AND Category ='" + categ + "'";
            rs = st.executeQuery(query);
            if (rs.next() == true) {
                JOptionPane.showMessageDialog(rootPane, "Product is already inserted!");
            } else {

                double data = Float.parseFloat(pri.getText());
              
                con = Connections.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO `inv_products`(`Product_name`, `Category`, `Portion`, `Serving`, `Price`, `qty`) VALUES (?,?,?,?,?,?)");
                ps.setString(1, pn.getText());
                ps.setString(2, cat.getText());
                ps.setString(3, por.getText());
                ps.setString(4, ser.getText());
                ps.setDouble(5, data);
                ps.setString(6, productqty.getText());

                ps.executeUpdate();
                Display_on_Table();
                addProductLog();

                JOptionPane.showMessageDialog(rootPane, "Inserted!");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "One or more field left : or value inputed is wrong!");

        }
    }//GEN-LAST:event_insertActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedROwIndex = table.getSelectedRow();
        id.setText(model.getValueAt(selectedROwIndex, 0).toString());
        pn.setText(model.getValueAt(selectedROwIndex, 1).toString());
        cat.setText(model.getValueAt(selectedROwIndex, 2).toString());
        por.setText(model.getValueAt(selectedROwIndex, 3).toString());
        ser.setText(model.getValueAt(selectedROwIndex, 4).toString());
        pri.setText(model.getValueAt(selectedROwIndex, 5).toString());
        productqty.setText(model.getValueAt(selectedROwIndex, 6).toString());


    }//GEN-LAST:event_tableMouseClicked

    private void sortKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sortKeyTyped
        findProduct();
    }//GEN-LAST:event_sortKeyTyped

    private void PnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PnameActionPerformed

    }//GEN-LAST:event_PnameActionPerformed

    private void addCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCartActionPerformed

        Statement st;
        ResultSet rs;
        String id = pID.getText();
        String name = Pname.getText();
        try {
            st = con.createStatement();
            Float availableStocks = Float.parseFloat(availableStocks1.getText());
            //validation
            String query = "SELECT * FROM  insertedintocart WHERE id = '" + id + "' AND Product_name = '" + name + "'";

            rs = st.executeQuery(query);

            if (rs.next() == true) {
                JOptionPane.showMessageDialog(rootPane, "Selected Product is already added!");

            } else if (Float.parseFloat(qty.getText()) > availableStocks) {
                JOptionPane.showMessageDialog(rootPane, "Insufficient stocks! unable to add! ");
            } else if (availableStocks < 0) {
                JOptionPane.showMessageDialog(rootPane, "Out of stocks!");

            } else {

                int quantity = Integer.parseInt(qty.getText());
                float price = Float.parseFloat(p_order.getText());
                Float total = quantity * price;

                String alltotal = String.valueOf(total);

                con = Connections.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO `insertedintocart`( `id`,`Product_name`, `qty`, `price`,`total_product`)" + "values(?,?,?,?,?)");

                float data = Float.parseFloat(p_order.getText());
                ps.setString(1, pID.getText());
                ps.setString(2, Pname.getText());
                ps.setString(3, qty.getText());
                ps.setFloat(4, data);
                ps.setString(5, alltotal);

                ps.executeUpdate();
                Display_on_Table();
                CasheringMoveProduct();
                addTotal();
                getResult();
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_addCartActionPerformed

    private void listedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listedMouseClicked
        int index = listed.getSelectedRow();
        CasherMovedata(index);
        addTotal();


    }//GEN-LAST:event_listedMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (!idlisted.getText().equals("")) {

            try {
                con = Connections.getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM insertedintocart WHERE id = ?");
                int id_products = Integer.parseInt(idlisted.getText());
                ps.setInt(1, id_products);
                ps.executeUpdate();
                CasheringMoveProduct();
                addTotal();
                JOptionPane.showMessageDialog(rootPane, "Has Been Remove");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Unable to Remove");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "No ID to Remove");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM insertedintocart");
            ps.executeUpdate();
            CasheringMoveProduct();
            addTotal();
            JOptionPane.showMessageDialog(rootPane, "Has Been Reset!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Unable to Reset");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void searchingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchingKeyTyped
        SearchintoCasher();
    }//GEN-LAST:event_searchingKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        id.setText("");
        pn.setText("");
        cat.setText("");
        por.setText("");
        ser.setText("");
        pri.setText("");
        productqty.setText("");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        printTextArea.setText("");
        try {
            Float c = Float.parseFloat(change.getText());

            if (ammount.getText().equals("")) {

                JOptionPane.showMessageDialog(rootPane, "Cash is empty or invalid output!");
            } else if (c < 0) {
                JOptionPane.showMessageDialog(rootPane, "Cash is not enough!");

            } else {
                int x = JOptionPane.showConfirmDialog(null, "Press Enter to continue.", "Confirm", JOptionPane.YES_NO_OPTION);
                if (x == JOptionPane.YES_OPTION) {
                    getAllDataTo_Print();
                    insetToDB_SalesReport();
                    
                    
                    printbg.setBackground(new Color(0, 0, 0, 93));
                    body.removeAll();
                    body.add(orderprint);
                    body.repaint();
                    body.revalidate();
                    
                    Toolkit tkp = printTextArea.getToolkit();
                    PrintJob pjp = tkp.getPrintJob(this, null, null);
                    Graphics g = pjp.getGraphics();
                    printTextArea.print(g);
                    g.dispose();
                    pjp.end();
                    
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void logingoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logingoutActionPerformed
        logOut();
        LoginForm log = new LoginForm();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
        dispose();

    }//GEN-LAST:event_logingoutActionPerformed

    private void CasherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CasherActionPerformed
        
        body.removeAll();
        body.add(Cashering);
        body.repaint();
        body.revalidate();
        Display_on_Cashering();
        print_removeListed();
    }//GEN-LAST:event_CasherActionPerformed

    private void inven_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven_stockActionPerformed
        TableonStocksdisplay();
        body.removeAll();
        body.add(inventoryStocks);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_inven_stockActionPerformed

    private void inven_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inven_proActionPerformed
        body.removeAll();
        body.add(inventoryProduct);
        body.repaint();
        body.revalidate();
        Display_on_Table();
    }//GEN-LAST:event_inven_proActionPerformed

    private void sumTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumTotalActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_sumTotalActionPerformed

    //__________________________________________________PRINT _______________________________   
    public void printComponenet(Component component) {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");

        pj.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                component.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (pj.printDialog() == false) {
            return;
        }

        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    }
//_____________________________________________________________________________________________________________


    private void ammountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ammountKeyReleased
        getResult();
    }//GEN-LAST:event_ammountKeyReleased

    private void inven_stock_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inven_stock_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) inven_stock_table.getModel();

        //-------------------------------inventory table in
        int selectedROwIndex = inven_stock_table.getSelectedRow();
        product_ID.setText(model.getValueAt(selectedROwIndex, 0).toString());
        products_name.setText(model.getValueAt(selectedROwIndex, 1).toString());
        category_product.setText(model.getValueAt(selectedROwIndex, 2).toString());

        qtyss.setText("");
        //-------------------------------inventory table out
        pIDs.setText(model.getValueAt(selectedROwIndex, 0).toString());
        pnames.setText(model.getValueAt(selectedROwIndex, 1).toString());
        pcat.setText(model.getValueAt(selectedROwIndex, 2).toString());
        avs.setText(model.getValueAt(selectedROwIndex, 3).toString());
        qtys.setText("");
    }//GEN-LAST:event_inven_stock_tableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        stockIN_Out.removeAll();
        stockIN_Out.add(stock_out);
        stockIN_Out.repaint();
        stockIN_Out.revalidate();
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void stock_btn_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_btn_inActionPerformed

        stockIN_Out.removeAll();
        stockIN_Out.add(stock_in);
        stockIN_Out.repaint();
        stockIN_Out.revalidate();
        clear();


    }//GEN-LAST:event_stock_btn_inActionPerformed

    private void In_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_In_BTNActionPerformed

//___________________________Stock in _________________________________
        String date = ((JTextField) date_In.getDateEditor().getUiComponent()).getText();

        if (date.equals("") || qtyss.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please Add Date or Quantity is empty or invalid input!");

        } else {

          
            int x = JOptionPane.showConfirmDialog(null, "Stock In Items", "Stock In", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION) {
                  try {
                      
                con = Connections.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO `inventory`(`id`, `Product_name`, `Category`,`qty`, `Date`, `Stock_In_Out`) VALUES (?,?,?,?,?,?)");
               Float a = Float.parseFloat(qtyss.getText());
                ps.setString(1, pIDs.getText());
                ps.setString(2, pnames.getText());
                ps.setString(3, pcat.getText());
                ps.setFloat(4, a);
                ps.setString(5, date);
                ps.setString(6, "Stock In");

                ps.executeUpdate();
                stockInlog();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Invalid Input!");
            }
                PreparedStatement ps;

                String quantity_in = qtyss.getText();
                String id_Product_In = pIDs.getText();

                String update_In = "UPDATE inv_products  SET qty = qty + " + quantity_in + " WHERE id = " + id_Product_In;

                try {

                    ps = con.prepareStatement(update_In);
                    ps.execute();
                    TableonStocksdisplay();
                    JOptionPane.showMessageDialog(rootPane, "Stock In Successfully!");
                } catch (Exception e) {

                }
            }
        }

    }//GEN-LAST:event_In_BTNActionPerformed

    private void Out_StockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Out_StockActionPerformed

        float availables = Float.parseFloat(avs.getText());

        String date = ((JTextField) date_out.getDateEditor().getUiComponent()).getText();

        if (date.equals("") && qtys.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please Add Date or Quantity is empty or invalid input!");

        } else if (Float.parseFloat(qtys.getText()) > availables) {
            JOptionPane.showMessageDialog(rootPane, "Out of stocks!");
        } else {
            PreparedStatement psd;
           

            int x = JOptionPane.showConfirmDialog(null, "Stock Out Items", "Stock Out", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION) {
                try {

                    con = Connections.getConnection();
                    
                    PreparedStatement ps = con.prepareStatement("INSERT INTO `inventory`(`id`, `Product_name`, `Category`,`qty`, `Date`, `Stock_In_Out`) VALUES (?,?,?,?,?,?)");
                    float s = Float.parseFloat(qtys.getText());
                    ps.setString(1, product_ID.getText());
                    ps.setString(2, products_name.getText());
                    ps.setString(3, category_product.getText());
                    ps.setFloat(4, s);
                    ps.setString(5, date);
                    ps.setString(6, "Stock Out");

                    ps.executeUpdate();
                    
                    stockOutLogs();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "Invalid Input!");
                
            }
            String quantity_Out = qtys.getText();
            String id_Product_Out = pIDs.getText();
                    
            String update_In = "UPDATE inv_products  SET qty = qty  - " + quantity_Out + " WHERE id = " + id_Product_Out;
            try{
                psd = con.prepareStatement(update_In);
                psd.execute();

                TableonStocksdisplay();
                JOptionPane.showMessageDialog(rootPane, "Stock Out Successfully!");
                StockSuccessClearField();
            } catch (Exception e) {
               
                
            }
        }
            
        }   
    }//GEN-LAST:event_Out_StockActionPerformed

    private void searchInvenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInvenKeyTyped
        SearchTableStock();
    }//GEN-LAST:event_searchInvenKeyTyped

    private void usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseClicked
        int indexs = users.getSelectedRow();
        getInfoUsers(indexs);

    }//GEN-LAST:event_usersMouseClicked

    private void usertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertypeActionPerformed

    }//GEN-LAST:event_usertypeActionPerformed

    private void update_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_userActionPerformed
        String UpdateQuery = null;
        PreparedStatement ps = null;
        con = Connections.getConnection();
        try {
            UpdateQuery = "UPDATE usertype_table SET firstname = ?,middlename = ?,lastname = ?,address = ?,age = ?, user = ? , pass = ? ,gender = ?, usertype = ?  WHERE id = ?";

            ps = con.prepareStatement(UpdateQuery);
            ps.setString(1, fn.getText());
            ps.setString(2, mn.getText());
            ps.setString(3, ln.getText());
            ps.setString(4, ad.getText());
            ps.setString(5, age.getText());
            ps.setString(6, user.getText());
            ps.setString(7, pass.getText());
            ps.setString(8, String.valueOf(gen.getSelectedItem()));
            ps.setString(9, String.valueOf(usertype.getSelectedItem()));

            ps.setInt(10, Integer.parseInt(idtext.getText()));

            ps.executeUpdate();
            UserTable();
            JOptionPane.showMessageDialog(rootPane, "User is updated");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "unable updated");
        }
    }//GEN-LAST:event_update_userActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        salesday();

        String date = ((JTextField) date2.getDateEditor().getUiComponent()).getText();
       daydate.setText(date);
        salesday();
        sumTotaldaily();


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            exportTable(TableDailySales, new File("D:\\tabledata.xls"));
            JOptionPane.showMessageDialog(rootPane, "Has Been Exported to Drive D: ");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        dailyinven();
        sumTotalDailyInven();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void idtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idtextActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        body.removeAll();
        body.add(signupuser);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        String mons = (String) months.getSelectedItem();

        int ye = yearsales.getYear();
        String yea = String.valueOf(ye);

        switch (mons) {
            case "January":
                monthtext.setText("01");
                break;
            case "February":
                monthtext.setText("02");
                break;
            case "March":
                monthtext.setText("03");
                break;
            case "April":
                monthtext.setText("04");
                break;
            case "May":
                monthtext.setText("05");
                break;
            case "June":
                monthtext.setText("06");
                break;
            case "July":
                monthtext.setText("07");
                break;
            case "August":
                monthtext.setText("08");
                break;
            case "September":
                monthtext.setText("09");
                break;
            case "October":
                monthtext.setText("10");
                break;
            case "November":
                monthtext.setText("11");
                break;
            case "December":
                monthtext.setText("12");
                break;
        }

        yeartextsale.setText(yea);
        String data = yeartextsale.getText() + "-" + monthtext.getText() + ",";
        System.out.println(data);
        Statement st;
        ResultSet rs;
        con = Connections.getConnection();

        String sql = "SELECT * FROM `salesreport` WHERE date  LIKE '" + data + "%'";
        try {
            DefaultTableModel model = (DefaultTableModel) monthsaletable.getModel();
            model.setRowCount(0);
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String productcode = rs.getString("pcode");
                String pname = rs.getString("pname");
                String date = rs.getString("date");
                String qty = rs.getString("qty");
                String price = rs.getString("price");
                String totalp = rs.getString("totalp");

                Object[] row = {productcode, pname, date, qty, price, totalp};
                model.addRow(row);
                sumTotalMonthly();
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }


    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        try {
            exportTable(monthsaletable, new File("D:\\tabledata.xls"));
            JOptionPane.showMessageDialog(rootPane, "Has Been Exported to Drive D: ");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        bodyofsales.removeAll();
        bodyofsales.add(Daily);
        bodyofsales.repaint();
        bodyofsales.revalidate();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        bodyofsales.removeAll();
        bodyofsales.add(Monthly);
        bodyofsales.repaint();
        bodyofsales.revalidate();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bodyofsales.removeAll();
        bodyofsales.add(Yearly);
        bodyofsales.repaint();
        bodyofsales.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        try {
            exportTable(monthsaletable, new File("D:\\tabledata.xls"));
            JOptionPane.showMessageDialog(rootPane, "Has Been Exported to Drive D: ");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        int year = selectyear.getYear();
        Statement st;
        ResultSet rs;
        con = Connections.getConnection();

        String sql = "SELECT * FROM `salesreport` WHERE date  LIKE '" + year + "%'";
        try {
            DefaultTableModel model = (DefaultTableModel) yeartablesale.getModel();
            model.setRowCount(0);
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String productcode = rs.getString("pcode");
                String pname = rs.getString("pname");
                String date = rs.getString("date");
                String qty = rs.getString("qty");
                String price = rs.getString("price");
                String totalp = rs.getString("totalp");

                Object[] row = {productcode, pname, date, qty, price, totalp};
                model.addRow(row);
                sumTotalYearlySale();
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }

    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        bodyofinventorylog.removeAll();
        bodyofinventorylog.add(Daily1);
        bodyofinventorylog.repaint();
        bodyofinventorylog.revalidate();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        bodyofinventorylog.removeAll();
        bodyofinventorylog.add(Monthly1);
        bodyofinventorylog.repaint();
        bodyofinventorylog.revalidate();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        bodyofinventorylog.removeAll();
        bodyofinventorylog.add(Yearly1);
        bodyofinventorylog.repaint();
        bodyofinventorylog.revalidate();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        try {
            exportTable(InventoryDaily, new File("D:\\tabledata.xls"));
            JOptionPane.showMessageDialog(rootPane, "Has Been Exported to Drive D: ");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        String monss = (String) monthlyInven.getSelectedItem();

        int ye = yearInven.getYear();
        String yea = String.valueOf(ye);

        switch (monss) {
            case "January":
                textinvenmonthly.setText("01");
                break;
            case "February":
                textinvenmonthly.setText("02");
                break;
            case "March":
                textinvenmonthly.setText("03");
                break;
            case "April":
                monthtext.setText("04");
                break;
            case "May":
                textinvenmonthly.setText("05");
                break;
            case "June":
                textinvenmonthly.setText("06");
                break;
            case "July":
                textinvenmonthly.setText("07");
                break;
            case "August":
                textinvenmonthly.setText("08");
                break;
            case "September":
                textinvenmonthly.setText("09");
                break;
            case "October":
                textinvenmonthly.setText("10");
                break;
            case "November":
                textinvenmonthly.setText("11");
                break;
            case "December":
                textinvenmonthly.setText("12");
                break;
        }
        String datamonthly = yea + "," + textinvenmonthly.getText();
        Statement st;
        ResultSet rs;
        con = Connections.getConnection();

        String select = (String) selectMonthly_In_out.getSelectedItem();

        String sql = "SELECT * FROM `inventory` WHERE Date  LIKE '" + datamonthly + "%' AND Stock_In_Out LIKE '" + select + "%'";
        try {
            DefaultTableModel model = (DefaultTableModel) InvenMonthlyTable.getModel();
            model.setRowCount(0);
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String productcode = rs.getString("id");
                String pname = rs.getString("Product_name");
                String cat = rs.getString("Category");
                String qty = rs.getString("qty");
                String datesa = rs.getString("Date");
                String inorout = rs.getString("Stock_In_Out");
                Object[] row = {productcode, pname, cat, qty, datesa, inorout};
                model.addRow(row);

            }

        } catch (Exception ex) {
            System.out.println(ex);

        }

        PreparedStatement pst = null;
        ResultSet rst = null;
        con = Connections.getConnection();
        try {

            String SQL = "SELECT SUM(qty) FROM `inventory` WHERE Date LIKE '" + datamonthly + "%' AND Stock_In_Out = '" + select + "'";

            pst = con.prepareStatement(SQL);
            rst = pst.executeQuery();
            if (rst.next()) {
                float sum = rst.getFloat("Sum(qty)");
                String data = String.valueOf(sum);
                totalMonthlyIn_out.setText(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        try {
            exportTable(InvenMonthlyTable, new File("D:\\tabledata.xls"));
            JOptionPane.showMessageDialog(rootPane, "Has Been Exported to Drive D: ");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed

        int ye = yearInven.getYear();
        String yea = String.valueOf(ye);

        Statement st;
        ResultSet rs;
        con = Connections.getConnection();

        String select = (String) selectYearly.getSelectedItem();

        String sql = "SELECT * FROM `inventory` WHERE Date  LIKE '" + yea + "%' AND Stock_In_Out LIKE '" + select + "%'";
        try {
            DefaultTableModel model = (DefaultTableModel) InvenYearlytable.getModel();
            model.setRowCount(0);
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String productcode = rs.getString("id");
                String pname = rs.getString("Product_name");
                String cat = rs.getString("Category");
                String qty = rs.getString("qty");
                String datesa = rs.getString("Date");
                String inorout = rs.getString("Stock_In_Out");
                Object[] row = {productcode, pname, cat, qty, datesa, inorout};
                model.addRow(row);

            }

        } catch (Exception ex) {
            System.out.println(ex);

        }

        PreparedStatement pst = null;
        ResultSet rst = null;
        con = Connections.getConnection();
        try {

            String SQL = "SELECT SUM(qty) FROM `inventory` WHERE Date LIKE '" + yea + "%' AND Stock_In_Out = '" + select + "'";

            pst = con.prepareStatement(SQL);
            rst = pst.executeQuery();
            if (rst.next()) {
                float sum = rst.getFloat("Sum(qty)");
                String data = String.valueOf(sum);
                totalYearlySum.setText(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        try {
            exportTable(InvenYearlytable, new File("D:\\tabledata.xls"));
            JOptionPane.showMessageDialog(rootPane, "Has Been Exported to Drive D: ");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void pass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass1ActionPerformed

    private void ClearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearFieldActionPerformed
        resetField();
    }//GEN-LAST:event_ClearFieldActionPerformed

    private void createuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createuserActionPerformed

        CreateAccount();

    }//GEN-LAST:event_createuserActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        UserTable();
        body.removeAll();
        body.add(manageusers);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void showPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPActionPerformed
        if (showP.isSelected()) {
            pass1.setEchoChar((char) 0);
        } else {
            pass1.setEchoChar('*');
        }
    }//GEN-LAST:event_showPActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        body.removeAll();
        body.add(orderprint);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        Toolkit tkp = printTextArea.getToolkit();
        PrintJob pjp = tkp.getPrintJob(this, null, null);
        Graphics g = pjp.getGraphics();
        printTextArea.print(g);
        g.dispose();
        pjp.end();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            TableDailySales.print();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed

        try {
            monthsaletable.print();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
      try{
            yeartablesale.print();
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        try{
            InventoryDaily.print();
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    private void select_stock_in_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_stock_in_outActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_select_stock_in_outActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        try{
            InvenMonthlyTable.print();
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        try{
            InvenYearlytable.print();
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton38ActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if (!idtext.getText().equals("")) {

            try {
                con = Connections.getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM usertype_table WHERE id = ?");
                int id_products = Integer.parseInt(idtext.getText());
                ps.setInt(1, id_products);
                ps.executeUpdate();
                UserTable();

                JOptionPane.showMessageDialog(rootPane, "Has been deleted!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "User Info unable to delete!");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "User Info unable to delete: No ID to delete");
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void casherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casherTableMouseClicked
         
        DefaultTableModel model = (DefaultTableModel) casherTable.getModel();
        int selectedROwIndex = casherTable.getSelectedRow();
        pID.setText(model.getValueAt(selectedROwIndex, 0).toString());
        Pname.setText(model.getValueAt(selectedROwIndex, 1).toString());
        pnamelabel.setText(model.getValueAt(selectedROwIndex, 1).toString());
        availableStocks1.setText(model.getValueAt(selectedROwIndex, 5).toString());
        p_order.setText(model.getValueAt(selectedROwIndex, 3).toString());
        text.setText(model.getValueAt(selectedROwIndex, 4).toString());

        qty.setText("");
        
    }//GEN-LAST:event_casherTableMouseClicked

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        body.removeAll();
        body.add(reports);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_reportActionPerformed

    private void mn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mn1ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        body.removeAll();
        body.add(manageusers);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        body.removeAll();
        body.add(salesreports);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
       
        body.removeAll();
        body.add(inventory_reports);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        body.removeAll();
        body.add(viewlog);
        body.repaint();
        body.revalidate();
        viewlogss();
    }//GEN-LAST:event_jButton9ActionPerformed
///////////////////////////////result/////////////

    public void getResult() {
        try {
            float total = Float.valueOf(sumTotal.getText());
            float amt = Float.valueOf(ammount.getText());

            float result = amt - total;
            String data = String.valueOf(result);
            change.setText(data);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>INVENTORY PRODUCT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void Display_on_Cashering() {
        ArrayList<producttocasher> list = getProductLists();

        DefaultTableModel model = (DefaultTableModel) casherTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        for (int x = 0; x < list.size(); x++) {
            row[0] = list.get(x).getid();
            row[1] = list.get(x).getproductName();
            row[2] = list.get(x).getcate();
            row[3] = list.get(x).getprice();
            row[4] = list.get(x).getServe();
            row[5] = list.get(x).getQTY();

            model.addRow(row);
            

        }
        
    }

    public ArrayList<producttocasher> getProductLists() {
        ArrayList<producttocasher> productlist = new ArrayList<producttocasher>();
        con = Connections.getConnection();
        String query = "SELECT*FROM inv_products";

        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            producttocasher product;
            while (rs.next()) {
                product = new producttocasher(rs.getInt("id"), rs.getString("Product_name"),
                        rs.getString("Category"), rs.getFloat("Price"), rs.getString("Serving"), rs.getInt("qty"));

                productlist.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(inv_products.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productlist;
    }

    public void CashersetItem(int index) {
        pID.setText(Integer.toString(getProductLists().get(index).getid()));
        Pname.setText(getProductLists().get(index).getproductName());
        p_order.setText(Float.toString(getProductLists().get(index).getprice()));
        pnamelabel.setText(getProductLists().get(index).getproductName());

    }

    public void CasheringMoveProduct() {
        ArrayList<gettheproduct> list = getProductListed();

        DefaultTableModel model = (DefaultTableModel) listed.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int x = 0; x < list.size(); x++) {
            row[0] = list.get(x).getidlist();
            row[1] = list.get(x).getPns();
            row[2] = list.get(x).getQTY();
            row[3] = list.get(x).getpric();
            row[4] = list.get(x).getTotal();

            model.addRow(row);

        }

    }

    public ArrayList<gettheproduct> getProductListed() {
        ArrayList<gettheproduct> productlist = new ArrayList<gettheproduct>();
        con = Connections.getConnection();
        String query = "SELECT *FROM `insertedintocart`";

        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            gettheproduct product;
            while (rs.next()) {
                product = new gettheproduct(rs.getInt("id"), rs.getString("Product_name"), rs.getInt("qty"),
                        rs.getFloat("price"), rs.getString("total_product"));
                productlist.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(inv_products.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productlist;
    }

    public void CasherMovedata(int index) {
        idlisted.setText(Integer.toString(getProductListed().get(index).getidlist()));
        Pname.setText(getProductListed().get(index).getPns());
        qty.setText(Integer.toString(getProductListed().get(index).getQTY()));
        p_order.setText(Float.toString(getProductListed().get(index).getpric()));

    }

    public ArrayList<producttocasher> SearchintoCasher(String ValToSearch) {
        ArrayList<producttocasher> productlist = new ArrayList<producttocasher>();

        Statement st;
        ResultSet rs;

        try {
            con = Connections.getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `inv_products` WHERE CONCAT(`id`, `Product_name`, `Category`,`Price`,`qty`) LIKE '%" + ValToSearch + "%'";
            rs = st.executeQuery(searchQuery);

            producttocasher product;

            while (rs.next()) {
                product = new producttocasher(
                        rs.getInt("id"),
                        rs.getString("Product_name"),
                        rs.getString("Category"),
                        rs.getInt("Price"),
                        rs.getString("Serving"),
                        rs.getInt("qty")
                );
                productlist.add(product);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return productlist;
    }

    // function to display data in jtable
    public void SearchintoCasher() {
        ArrayList<producttocasher> product = SearchintoCasher(searching.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Product Code", "Product Name", "Category ", "Price", "Serving", "QTY"});
        Object[] row = new Object[7];

        for (int i = 0; i < product.size(); i++) {
            row[0] = product.get(i).getid();
            row[1] = product.get(i).getproductName();
            row[2] = product.get(i).getcate();
            row[3] = product.get(i).getprice();
            row[4] = product.get(i).getServe();
            row[5] = product.get(i).getQTY();

            model.addRow(row);
        }
        casherTable.setModel(model);
        
    }

    public void addTotal() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        con = Connections.getConnection();
        try {
            String SQL = "SELECT SUM(qty*price) FROM insertedintocart";

            pst = con.prepareStatement(SQL);
            rs = pst.executeQuery();
            if (rs.next()) {
                float sum = rs.getFloat("Sum(qty*price)");
                String data = String.valueOf(sum);
                sumTotal.setText(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Casher;
    private javax.swing.JPanel Cashering;
    private javax.swing.JButton ClearField;
    private javax.swing.JPanel Daily;
    private javax.swing.JPanel Daily1;
    private javax.swing.JButton Delete;
    private javax.swing.JButton In_BTN;
    private javax.swing.JTable InvenMonthlyTable;
    private javax.swing.JTable InvenYearlytable;
    private javax.swing.JTable InventoryDaily;
    private javax.swing.JPanel Monthly;
    private javax.swing.JPanel Monthly1;
    private javax.swing.JButton Out_Stock;
    private javax.swing.JTextField Pname;
    private javax.swing.JTable TableDailySales;
    private javax.swing.JPanel Yearly;
    private javax.swing.JPanel Yearly1;
    private javax.swing.JTextField ad;
    private javax.swing.JTextField ad1;
    private javax.swing.JButton addCart;
    private javax.swing.JTextField age;
    private javax.swing.JTextField age1;
    public javax.swing.JTextField ammount;
    private javax.swing.JTextField availableStocks1;
    private javax.swing.JTextField avs;
    private javax.swing.JPanel body;
    private javax.swing.JPanel bodyofinventorylog;
    private javax.swing.JPanel bodyofsales;
    private javax.swing.JTable casherTable;
    private javax.swing.JTextField cat;
    private javax.swing.JTextField category_product;
    public javax.swing.JTextField change;
    private javax.swing.JButton createuser;
    private javax.swing.JLabel dailysum;
    private static javax.swing.JLabel date;
    private com.toedter.calendar.JDateChooser date2;
    private com.toedter.calendar.JDateChooser date_In;
    private com.toedter.calendar.JDateChooser date_inven_daily;
    private com.toedter.calendar.JDateChooser date_out;
    private javax.swing.JLabel datescashier;
    private javax.swing.JLabel daydate;
    private javax.swing.JButton delete;
    private javax.swing.JTextField fn;
    private javax.swing.JTextField fn1;
    private javax.swing.JPanel footercolor;
    private javax.swing.JComboBox<String> gen;
    private javax.swing.JComboBox<String> gen1;
    private javax.swing.JPanel head;
    private javax.swing.JPanel home;
    private javax.swing.JTextField id;
    private javax.swing.JTextField idlisted;
    private javax.swing.JTextField idtext;
    private javax.swing.JButton insert;
    javax.swing.JButton inven_pro;
    public javax.swing.JButton inven_stock;
    private javax.swing.JTable inven_stock_table;
    private javax.swing.JPanel inventoryProduct;
    private javax.swing.JPanel inventoryStocks;
    private javax.swing.JPanel inventory_reports;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listed;
    private javax.swing.JTextField ln;
    private javax.swing.JTextField ln1;
    public javax.swing.JButton logingout;
    private javax.swing.JPanel manageusers;
    private javax.swing.JTextField mn;
    private javax.swing.JTextField mn1;
    private javax.swing.JComboBox<String> monthlyInven;
    private javax.swing.JLabel monthlysum;
    private javax.swing.JLabel monthlysum1;
    private javax.swing.JComboBox<String> months;
    private javax.swing.JTable monthsaletable;
    private javax.swing.JLabel monthtext;
    private javax.swing.JLabel nameofproduct;
    private javax.swing.JPanel orderprint;
    private javax.swing.JTextField pID;
    private javax.swing.JTextField pIDs;
    private javax.swing.JTextField p_order;
    private javax.swing.JTextField pass;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JTextField pcat;
    private javax.swing.JTextField pn;
    private javax.swing.JLabel pnamelabel;
    private javax.swing.JTextField pnames;
    private javax.swing.JTextField por;
    private javax.swing.JTextField pri;
    private javax.swing.JTextArea printTextArea;
    private javax.swing.JPanel printbg;
    private javax.swing.JTextField product_ID;
    private javax.swing.JTextField productqty;
    private javax.swing.JTextField products_name;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField qtys;
    private javax.swing.JTextField qtyss;
    public javax.swing.JButton report;
    private javax.swing.JPanel reports;
    private javax.swing.JPanel salesreports;
    private javax.swing.JTextField searchInven;
    private javax.swing.JTextField searching;
    private javax.swing.JComboBox<String> selectMonthly_In_out;
    private javax.swing.JComboBox<String> selectYearly;
    private javax.swing.JComboBox<String> select_stock_in_out;
    private javax.swing.JLabel selected;
    private javax.swing.JLabel selected1;
    private javax.swing.JLabel selected2;
    private com.toedter.calendar.JYearChooser selectyear;
    private javax.swing.JTextField ser;
    private javax.swing.JCheckBox showP;
    private javax.swing.JPanel signupuser;
    private javax.swing.JTextField sort;
    private javax.swing.JPanel stockIN_Out;
    private javax.swing.JButton stock_btn_in;
    private javax.swing.JPanel stock_in;
    private javax.swing.JPanel stock_out;
    private javax.swing.JTextField sumTotal;
    private javax.swing.JTable table;
    private javax.swing.JLabel text;
    private javax.swing.JLabel textinvenmonthly;
    public javax.swing.JLabel textlogin;
    private static javax.swing.JLabel times;
    private javax.swing.JLabel totalIn_outText;
    private javax.swing.JLabel totalMonthlyIn_out;
    private javax.swing.JLabel totalYearlySum;
    private javax.swing.JButton update_user;
    private javax.swing.JTextField user;
    private javax.swing.JTextField user1;
    public javax.swing.JLabel userText;
    private javax.swing.JTable users;
    private javax.swing.JComboBox<String> usertype;
    private javax.swing.JComboBox<String> usertype1;
    private javax.swing.JPanel viewlog;
    private javax.swing.JTable viewlogtables;
    private com.toedter.calendar.JYearChooser yearInven;
    private com.toedter.calendar.JYearChooser yearInven1;
    private com.toedter.calendar.JYearChooser yearsales;
    private javax.swing.JTable yeartablesale;
    private javax.swing.JLabel yeartextsale;
    // End of variables declaration//GEN-END:variables
}
