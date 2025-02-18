package org.example;

import lombok.Data;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderList {
    public List<Order> orderList = new ArrayList<>();

    @Override
    public String toString() {
        return "OrderList{" +
                "orderList=" + orderList +
                '}';
    }

    public void AddOrder(Order o) {
        orderList.add(o);
    }

    //compare products and sum them
    // aka: [name, count]
    public static List<Pair<String, Integer>> ProductSum(List<Order> orderList, int threshold) {
        List<Pair<String, Integer>> productSum = new ArrayList<>();

        //foreach order get product names and add them to counters of (non)existent entries
        for (Order order : orderList) {
            for (String productIn : order.getProductList()) {
                //check if product is in the new tuple
                boolean productExists = false;
                for (int i = 0; i < productSum.size(); i++) {
                    if (productSum.get(i).getValue0().compareTo(productIn) == 0) {
                        productSum.set(i, new Pair<>(productSum.get(i).getValue0(), productSum.get(i).getValue1() + 1));
                        productExists = true;
                        break;
                    }
                }
                if (!productExists) {
                    productSum.add(new Pair<>(productIn, 1));
                }
            }
        }

        for(int i = 0; i < productSum.size(); i++){
            if(productSum.get(i).getValue1() < threshold){
                productSum.remove(i);
                i--;
            }
        }

        return productSum;
    }
}
