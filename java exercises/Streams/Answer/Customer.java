import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.Long.*;
import static java.lang.Long.parseLong;

public class Customer {
    private long id;
    private String name;
    private int tier;

public Customer(String customerInfo) {
    // Split the input string into key-value pairs and create a map
    String[] infoArray = customerInfo.split("\\s+");
    this.setId(Long.parseLong(infoArray[1]));
    this.setName(infoArray[3]);
    this.setTier(Integer.valueOf(infoArray[5]));
}

    public Customer(long Cid,String Cname, int Ctier)
    {
        setId(Cid);
        setName(Cname);
        setTier(Ctier);
    }

    public String toString()
    {
        return "customer: "+ getId() + " name: "+ getName() +" tier: "+ getTier()+"\n";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}