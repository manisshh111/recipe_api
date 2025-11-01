package com.manish.recipes_api.util;

import com.manish.recipes_api.service.DataDumpService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppRunner {

    @Autowired
    DataDumpService dataDumpService;

    @PostConstruct
    public void init(){
        dataDumpService.dumpDataIntoDb();
    }

}
