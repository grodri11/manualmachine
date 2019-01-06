package com.dropship.manualmachine.parsers;

import com.dropship.manualmachine.Parser;
import com.dropship.manualmachine.ParserObject;
import com.dropship.manualmachine.models.ShippingModel;
import com.dropship.manualmachine.utils.Utilities;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static com.dropship.manualmachine.utils.Utilities.checkIfRowIsEmpty;

public class ShippingParser implements Parser {

    @Override
    public List<ParserObject> parse(MultipartFile file){

        int FIRST_ROW_TO_GET = 1;
        List<ParserObject> orderModelList = new ArrayList<>();

        try {
            Workbook workbook = WorkbookFactory.create(Utilities.convert(file));
            // Create a DataFormatter to format and get each cell's value as String
            DataFormatter dataFormatter = new DataFormatter();
            Sheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = FIRST_ROW_TO_GET; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {

                Row row = sheet.getRow(rowIndex);
                if(checkIfRowIsEmpty(row)){
                    continue;
                }

                ShippingModel order = new ShippingModel();
                for (int i = 0; i < 5; i++) {
                    order.setOrderedDate(row.getCell(0).toString());
                    order.setOrderId(row.getCell(1).toString());
                    order.setTrackingNumber(row.getCell(2).toString());
                    order.setCourier(row.getCell(3).toString());
                    order.setOrderTotal(row.getCell(4).toString());
                }
                System.out.println(order);
                orderModelList.add(order);
            }


        } catch(Exception e){
            System.out.println(e);
        }


        return orderModelList;
    }
}