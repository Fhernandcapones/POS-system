package inventory_casheringsystem;

public class salesgetdata {

    private int id;
    private String Productname;
    private int qty;
    private float price;
    private float totalp;
    private String date;

    public salesgetdata(int id, String Productname, String date, int qty, float price, float totalp) {
        this.id = id;
        this.Productname = Productname;
        this.date = date;
        this.qty = qty;
        this.price = price;
        this.totalp = totalp;

    }

    public int getProductCode() {
        return id;
    }

    public String getProductname() {
        return Productname;
    }
    public String getDate(){
        return date;
    }
    public int getQuality(){
        return qty;
    }
    public float getPrice(){
        return price;
    }
    public float getTotalPrice(){
        return totalp;
    }
}
