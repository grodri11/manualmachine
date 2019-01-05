package com.dropship.manualmachine.parsers;

import com.dropship.manualmachine.Parser;
import com.dropship.manualmachine.ParserObject;
import com.dropship.manualmachine.models.ShippingModel;
import com.dropship.manualmachine.utils.Utilities;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class EbaySoldParser implements Parser {

    @Override
    public List<ParserObject> parse(MultipartFile file){

        try (Reader reader = new FileReader(Utilities.convert(file))) {
            CsvToBean<ShippingModel> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ShippingModel.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<ShippingModel> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                ShippingModel orderModel = csvUserIterator.next();
                System.out.println("Ordered Date : " + orderModel.getOrderedDate().toString());
                System.out.println("Order ID : " + orderModel.getOrderId());
                System.out.println("Courier : " + orderModel.getCourier());
                System.out.println("Tracking Number : " + orderModel.getTrackingNumber());
                System.out.println("Order total : " + orderModel.getOrderTotal());
                System.out.println("==========================");
            }

        } catch (IOException e){
            System.out.println(e);
        }
        return null;
    }
}
