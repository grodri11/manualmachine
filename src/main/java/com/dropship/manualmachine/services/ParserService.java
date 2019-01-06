package com.dropship.manualmachine.services;

import com.dropship.manualmachine.Parser;
import com.dropship.manualmachine.ParserObject;
import com.dropship.manualmachine.parsers.EbaySoldParser;
import com.dropship.manualmachine.parsers.ShippingParser;
import com.dropship.manualmachine.parsers.WMOrderParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParserService {


@Autowired
ShippingParser shippingParser;

    public List<ParserObject> parseFile(MultipartFile[] files){
        List<ParserObject> parserObjectList = new ArrayList<>();

        for(MultipartFile uploadedFile : files) {

            if(uploadedFile.getOriginalFilename().equals("Email Parsed Shipping Data.xlsx")){
                parserObjectList = shippingParser.parse(uploadedFile);

            }else if(uploadedFile.getOriginalFilename().equals("WM Order Information.xlsx")){
                Parser parser = new WMOrderParser();
                parserObjectList = parser.parse(uploadedFile);

            }else if(uploadedFile.getOriginalFilename().equals("eBay SOLD File Exchange CSV File.csv")){
                Parser parser = new EbaySoldParser();
                parserObjectList = parser.parse(uploadedFile);

            }

        }

        return parserObjectList;
    }
}
