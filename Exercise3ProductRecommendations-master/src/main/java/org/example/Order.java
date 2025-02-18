package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {

    //Order Id
    protected int soId;
    //Partner Id
    public int ppnkId;
    //Order number
    public String soCountCode;
    public String name;
    public String mobile;
    public String email;
    public List<String> productList = new ArrayList<>();

    @Override
    public String toString() {
        return "Order{" +
                "soId=" + soId +
                ", ppnkId=" + ppnkId +
                ", soCountCode='" + soCountCode + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", productList=" + productList +
                '}';
    }

    public void SplitProductList(String s) {
        do {
            // take string to "," or i absent full string

            int strLength = s.length();
            if (strLength == 0) {
                return;
            }

            int nextDash = s.indexOf(",");

            if (nextDash > 0) {
                String tempS = s.substring(0, nextDash);
                s = s.substring(nextDash + 1);
                productList.add(tempS);

            } else {
                productList.add(s);
                return;
            }
        }
        while (true);
    }
}
