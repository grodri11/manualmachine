package com.dropship.manualmachine.controllers;


import com.dropship.manualmachine.repo.ShippingDataRepository;
import com.dropship.manualmachine.services.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
public class CSVController {

    @Autowired
    ParserService parserService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String uploadPage( Model model) {
        return "csv";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public String uploadingPost(@RequestParam("files") MultipartFile[] files){

        parserService.parseFile(files);


        return "redirect:/";
    }

}
