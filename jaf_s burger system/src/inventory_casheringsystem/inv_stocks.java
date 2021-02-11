package inventory_casheringsystem;

public class inv_stocks {

    private int id;
    private String Productname;
    private String Category;
    private String Portion;
    private String Serving;
    private double price;
    private double qty;
   

    public inv_stocks(int id, String Productname, String Category, double price,double qty) {
        this.id = id;
        this.Productname = Productname;
        this.Category = Category;
        this.price = price;
        this.qty = qty;
        
    }

    public int getID() {
        return id;
    }

    public String getProductname() {
        return Productname;
    }

    public String getCategory() {
        return Category;
    }

    public double getprice() {
        return price;
    }
    public double getQty(){
        return qty;
    }
    
    
}
