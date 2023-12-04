package com.muktars.datageneratormicroservice.service;

import com.muktars.datageneratormicroservice.model.test.DataTestOptions;

public interface TestDataService {
    void sendMessages(DataTestOptions testOptions);
}
