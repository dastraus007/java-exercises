import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Long.parseLong;

public class Order {

    private long orderId;
    private Date orderDate;
    private Date deliveryDate;
    private OrderStatus status;

    private long customrId;
public Order(String orderInfo)  {
    //To Do
    String[] infoArray = orderInfo.split("\\s+");
    this.setOrderId(Long.parseLong(infoArray[1]));
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    try {
        Date date = sdf.parse(infoArray[4]);
        Date date1 = sdf.parse(infoArray[7]);
        this.setOrderDate(date);
        this.setDeliveryDate(date1);
    }
    catch (ParseException e) {
        e.printStackTrace(); // Handle the parsing exception
    }
    this.setStatus(OrderStatus.valueOf( infoArray[9]));
    this.setCustomrId(Long.parseLong(infoArray[12]));

}


    public Order(long Oid, Date OorderDate, Date OdeliveryDate, OrderStatus Ostatus, long OcustomrId)
    {
        setOrderId(Oid);
        setOrderDate(OorderDate);
        setDeliveryDate(OdeliveryDate);
        setStatus(Ostatus);
        setCustomrId(OcustomrId);
    }



    public String toString()
    {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        return "order: "+ getOrderId() + " order date: "+ ft.format(getOrderDate()) +" delivery date: "+ ft.format(getDeliveryDate()) + " status: "+ getStatus() + " customr id: "+ getCustomrId()+"\n";
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getCustomrId() {
        return customrId;
    }

    public void setCustomrId(long customrId) {
        this.customrId = customrId;
    }
}