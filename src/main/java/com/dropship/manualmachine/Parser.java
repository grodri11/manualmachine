package com.dropship.manualmachine;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Parser {

    public List<ParserObject> parse(MultipartFile file);
}
