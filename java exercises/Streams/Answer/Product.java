import static java.lang.Long.parseLong;

public class Product
{
    private long ProductId;
    private String name;
    private ProductCategory category;
    private double price;

    public Product(String orderInfo)
    {
        //To Do
        String[] infoArray = orderInfo.split("\\s+");
        this.setProductId(Long.parseLong(infoArray[1]));
        this.setName(infoArray[2]);
        this.setCategory(ProductCategory.valueOf(infoArray[4]));
        this.setPrice(Double.valueOf(infoArray[6]));
    }

    public Product(long PId, String Pname, ProductCategory Pcategory, double Pprice)
    {
        setProductId(PId);
        setName(Pname);
        setCategory(Pcategory);
        setPrice(Pprice);

    }


    public String toString()
    {
        return "Product: "+ getProductId() + " "+ getName() +" category: "+ getCategory() + " price: "+ getPrice()+"\n";
    }

    public long getProductId() {
        return ProductId;
    }

    public void setProductId(long productId) {
        ProductId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}