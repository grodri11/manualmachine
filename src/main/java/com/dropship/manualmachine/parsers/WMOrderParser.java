package com.dropship.manualmachine.parsers;

import com.dropship.manualmachine.Parser;
import com.dropship.manualmachine.ParserObject;
import com.dropship.manualmachine.models.WMOrderModel;
import com.dropship.manualmachine.utils.Utilities;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static com.dropship.manualmachine.utils.Utilities.checkIfRowIsEmpty;

@Service
public class WMOrderParser implements Parser{

    @Override
    public List<ParserObject> parse(MultipartFile file) {
        int FIRST_ROW_TO_GET = 1;
        List<ParserObject> orderModelList = new ArrayList<>();

        try {
            Workbook workbook = WorkbookFactory.create(Utilities.convert(file));
            Sheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = FIRST_ROW_TO_GET; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {

                Row row = sheet.getRow(rowIndex);
                if(checkIfRowIsEmpty(row)){
                    continue;
                }

                WMOrderModel order = new WMOrderModel();
                for (int i = 0; i < 5; i++) {
                    order.setDate(row.getCell(0).toString());
                    order.setOrderNumber(row.getCell(1).toString());
                    order.setNameAddress(row.getCell(2).toString());
                    order.setBasePrice(row.getCell(3).toString());
                    order.setShipping(row.getCell(4).toString());
                    order.setOrderTotal(row.getCell(5).toString());
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
