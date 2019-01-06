package com.dropship.manualmachine.parsers;

import com.dropship.manualmachine.Parser;
import com.dropship.manualmachine.ParserObject;
import com.dropship.manualmachine.models.EbaySoldModel;
import com.dropship.manualmachine.models.ShippingModel;
import com.dropship.manualmachine.utils.Utilities;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.dropship.manualmachine.utils.Utilities.checkIfRowIsEmpty;

@Service
public class EbaySoldParser implements Parser {

    @Override
    public List<ParserObject> parse(MultipartFile file){

        List<ParserObject> orderModelList = new ArrayList<>();

        try {
            CSVReader reader = new CSVReader(new FileReader(Utilities.convert(file)));


            List<EbaySoldModel> ebaySoldModelList = new ArrayList<>();
            List<String[]> records = reader.readAll();
            Iterator<String[]> iterator = records.iterator();

            while (iterator.hasNext()) {
                String[] record = iterator.next();
                EbaySoldModel soldModel = new EbaySoldModel();
                
                soldModel.setSalesRecordNumber(record[0]);
                soldModel.setUserId(record[1]);
                soldModel.setBuyerFullName(record[2]);
                soldModel.setBuyerPhoneNumber(record[3]);
                soldModel.setBuyerEmail(record[4]);
                soldModel.setBuyerAddress(record[5]);
                soldModel.setBuyerAddress2(record[6]);
                soldModel.setBuyerCity(record[7]);
                soldModel.setBuyerState(record[8]);
                soldModel.setBuyerZipcode(record[9]);
                soldModel.setBuyerCountry(record[10]);
                soldModel.setOrderId(record[11]);
                soldModel.setItemId(record[12]);
                soldModel.setTransactionId(record[13]);
                soldModel.setItemTitle(record[14]);
                soldModel.setQuantity(record[15]);
                soldModel.setSalePrice(record[16]);
                soldModel.setShippingAndHandling(record[17]);
                soldModel.setSalesTax(record[18]);
                soldModel.setInsurance(record[19]);
                soldModel.setTotalPrice(record[20]);
                soldModel.setPaymentMethod(record[21]);
                soldModel.setPayPalTransactionId(record[22]);
                soldModel.setSaleDate(record[23]);
                soldModel.setCheckoutDate(record[24]);
                soldModel.setPaidOnDate(record[25]);
                soldModel.setShippedOnDate(record[26]);
                soldModel.setShippingService(record[27]);
                soldModel.setFeedbackLeft(record[28]);
                soldModel.setFeedbackReceived(record[29]);
                soldModel.setNotesToYourself(record[30]);
                soldModel.setCustomLabel(record[31]);
                soldModel.setListedOn(record[32]);
                soldModel.setSoldOn(record[33]);
                soldModel.setPrivateNotes(record[34]);
                soldModel.setProductIdType(record[35]);
                soldModel.setProductIdValue(record[36]);
                soldModel.setProductIdValue2(record[37]);
                soldModel.setVariationDetails(record[38]);
                soldModel.setProductReferenceId(record[39]);
                soldModel.setTrackingNumber(record[40]);
                soldModel.setPhone(record[41]);
                ebaySoldModelList.add(soldModel);
                System.out.println(soldModel.toString());
            }


        } catch(Exception e){
            System.out.println(e);
        }


        return orderModelList;
    }


}
