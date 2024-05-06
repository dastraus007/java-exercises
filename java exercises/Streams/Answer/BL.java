import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class BL implements IBL {
    @Override
    public Product getProductById(long productId) {
        return DataSource.allProducts.stream()
                .filter(allProducts -> allProducts.getProductId()==productId).findFirst().orElse(null);

    }

    @Override
    public Order getOrderById(long orderId) {
        return DataSource.allOrders.stream()
                .filter(allOrders -> allOrders.getOrderId()==orderId).findFirst().orElse(null);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return DataSource.allCustomers.stream()
                .filter(allCustomers -> allCustomers.getId()==customerId).findFirst().orElse(null);

    }


    @Override
    public List<Product> getProducts(ProductCategory cat, double price) {
        List<Product> l= DataSource.allProducts.stream()
                .filter(allProducts -> allProducts.getCategory().equals(cat))
                .collect(toList());

        List<Product> l2= l.stream()
                .filter(allProducts -> allProducts.getPrice()<=price)
                .collect(toList());

        List<Product> sorted= l2.stream()
                .sorted(Comparator.comparing(Product ::getProductId))
                .collect(Collectors.toList());
        return sorted;
    }

    private long getOrderCountForCustomer(Customer customer) {
        return DataSource.allOrders.stream()
                .filter(allOrders -> allOrders.getCustomrId() == customer.getId())
                .count();
    }
    private int getOrderCount(long customerId, List<Order> orders) {
        // Count the number of orders for a specific customer
        return (int) DataSource.allOrders.stream()
                .filter(order -> order.getCustomrId() == customerId)
                .count();
    }
    @Override
    public List<Customer> popularCustomers() {
        List<Customer> popularCustomers = DataSource.allCustomers.stream()
                .filter(customer -> customer.getTier() == 3 && getOrderCount(customer.getId(), DataSource.allOrders) > 10)
                .sorted(Comparator.comparingLong(Customer::getId))
                .collect(Collectors.toList());

        return popularCustomers;
    }

    @Override
    public List<Order> getCustomerOrders(long customerId) {
        List<Order> l= DataSource.allOrders.stream()
                .filter(allOrders -> allOrders.getCustomrId()==customerId)
                .collect(toList());
        return l.stream().sorted(Comparator.comparing(Order::getCustomrId))
                .collect(Collectors.toList());
    }

    @Override
    public long numberOfProductInOrder(long orderId) {
        return DataSource.allOrderProducts.stream()
                .filter(productOrder -> productOrder.getOrderId() == orderId)
                .count();
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        Map<Long, Integer> productQuantityMap = DataSource.allOrderProducts.stream()
                .collect(Collectors.groupingBy(OrderProduct::getProductId, Collectors.summingInt(OrderProduct::getQuantity)));

        // Filter products based on the minimum ordered times and sort them by product identification number
        List<Product> popularProducts = DataSource.allProducts.stream()
                .filter(product -> productQuantityMap.getOrDefault(product.getProductId(), 0) >= orderedtimes)
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(Collectors.toList());

        return popularProducts;
    }

    @Override
    public List<Product> getOrderProducts(long orderId)
    {
        List<OrderProduct> filteredOrderProducts = DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getOrderId() == orderId)
                .collect(Collectors.toList());

        // Get the product codes from the filtered order products
        List<Long> productCodes = filteredOrderProducts.stream()
                .map(OrderProduct::getProductId)
                .collect(Collectors.toList());

        // Filter products based on the product codes and sort them by product identification number
        List<Product> orderedProducts = DataSource.allProducts.stream()
                .filter(product -> productCodes.contains(product.getProductId()))
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(Collectors.toList());

        return orderedProducts;

    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        List<Long> orderIds = DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getProductId() == productId)
                .map(OrderProduct::getOrderId)
                .collect(Collectors.toList());

        // Find customer IDs who placed those orders
        List<Long> customerIds = DataSource.allOrders.stream()
                .filter(order -> orderIds.contains(order.getOrderId()))
                .map(Order::getCustomrId)
                .collect(Collectors.toList());

        // Retrieve customers based on the customer IDs
        List<Customer> orderedCustomers = DataSource.allCustomers.stream()
                .filter(customer -> customerIds.contains(customer.getId()))
                .sorted(Comparator.comparingLong(Customer::getId))
                .collect(Collectors.toList());

        return orderedCustomers;

    }

    @Override
    public Product getMaxOrderedProduct() {
        Map<Long, Long> productCountMap = DataSource.allOrderProducts.stream()
                .collect(groupingBy(OrderProduct::getProductId, counting()));

        long maxOrderedProductCode = productCountMap.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        if (maxOrderedProductCode != 0) {
            return DataSource.allProducts.stream()
                    .filter(product -> product.getProductId()==maxOrderedProductCode)
                    .findFirst()
                    .orElse(null);
        }

        return null;

    }

    private double getProductPrice(OrderProduct orderProduct, long productsid) {
        // Retrieve the price of the product based on the product code
        Product product = DataSource.allProducts.stream()
                .filter(p -> p.getProductId()==productsid)
                .findFirst()
                .orElse(null);

        if (product != null) {
            return product.getPrice();
        } else {
            return 0.0; // Assuming the price is 0 if the product is not found
        }
    }

    @Override
    public double sumOfOrder(long orderID) {
        List<OrderProduct> productsInOrder = DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getOrderId() == orderID)
                .collect(Collectors.toList());

        // Calculate the sum of product prices multiplied by quantities
        double sum = productsInOrder.stream()
                .mapToDouble(orderProduct -> getProductPrice(orderProduct, orderProduct.getProductId()) * orderProduct.getQuantity())
                .sum();

        return sum;
    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
        List<Order> expensiveOrders = DataSource.allOrders.stream()
                .filter(order -> sumOfOrder(order.getOrderId()) > price)
                .collect(Collectors.toList());

        // Sort the expensiveOrders list in ascending order by order identification number
        expensiveOrders.sort(Comparator.comparingLong(Order::getOrderId));

        return expensiveOrders;

    }
    private int countCompleteOrders(Customer customer) {
        return (int) DataSource.allOrders.stream()
                .filter(invitation -> invitation.getCustomrId()==customer.getId())
                .count();
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        List<Customer>a= DataSource.allCustomers.stream()
                .filter(customer -> customer.getTier() == 3)
                .sorted(Comparator.comparingInt(customer -> countCompleteOrders(customer)))
                .collect(Collectors.toList());
        return a.subList(Math.max(a.size() - 3, 0), a.size());
    }


}
