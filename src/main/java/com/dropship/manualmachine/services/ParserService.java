package com.dropship.manualmachine.services;

import com.dropship.manualmachine.Parser;
import com.dropship.manualmachine.ParserObject;
import com.dropship.manualmachine.parsers.ShippingParser;
import com.dropship.manualmachine.parsers.WMOrderParser;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class ParserService {


    public List<ParserObject> parseFile(MultipartFile[] files){

        List<ParserObject> parserObjectList = new ArrayList<>();

        for(MultipartFile uploadedFile : files) {

            if(uploadedFile.getOriginalFilename().equals("Email Parsed Shipping Data.xlsx")){
                Parser parser = new ShippingParser();
                parserObjectList = parser.parse(uploadedFile);

            }else if(uploadedFile.getOriginalFilename().equals("WM Order Information.xlsx")){
                Parser parser = new WMOrderParser();
                parserObjectList = parser.parse(uploadedFile);
            }
        }

        return parserObjectList;
    }
}
