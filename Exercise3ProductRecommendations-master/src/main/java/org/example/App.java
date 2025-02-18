package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Product recommendation
 */
public class App {
    public static void main(String[] args) {

        /*
        1. get name of the file (and location?)
        1.a. get threshold
        2. read file, ignore lines that don't start with number (id of product)
            -- #soId|ppnkId|soCountCode|name|mobile|email|productList
        3. save products as class object
        ... combine products based on id, and num of sold products
         */

        // number of common purchases
        int threshold = 1;

        List<Order> orderList = new ArrayList<>();

        // get input
        String line = "";
        try {
            String filename = "example1_in_data.txt";
            String fileLocation = new java.io.File(".").getCanonicalPath() + "\\Exercise3ProductRecommendations-master\\test_files\\";

            BufferedReader reader = new BufferedReader(new FileReader(fileLocation + filename));
            while ((line = reader.readLine()) != null) {
                Order orderNew = new Order();

                if (Character.isDigit(line.charAt(0))) {
                    // parse product in class object
                    int nextI;

                    for (int counter = 0; counter < 7; counter++) {
                        nextI = line.indexOf("|");
                        String dataString = "";
                        if(nextI>0) {
                            dataString = line.substring(0, nextI);
                            line = line.substring(nextI + 1);
                        }

                        int dataInt = 0;
                        if (counter <= 1) {
                            dataInt = Integer.valueOf(dataString);
                        }

                        switch (counter) {
                            case 0:
                                //soId
                                orderNew.setSoId(dataInt);
                                break;
                            case 1:
                                //ppnkId
                                orderNew.setPpnkId(dataInt);
                                break;
                            case 2:
                                //soCountCode
                                orderNew.setSoCountCode(dataString);
                                break;
                            case 3:
                                //name
                                orderNew.setName(dataString);
                                break;
                            case 4:
                                //mobile
                                orderNew.setMobile(dataString);
                                break;
                            case 5:
                                //email
                                orderNew.setEmail(dataString);
                                break;
                            case 6:
                                //productList
                                orderNew.SplitProductList(line);
                                break;
                        }
                    }
                    orderList.add(orderNew);
                }
            }

            OrderList.ProductSum(orderList, threshold);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
