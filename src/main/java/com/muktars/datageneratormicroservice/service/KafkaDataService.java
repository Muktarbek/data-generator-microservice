package com.muktars.datageneratormicroservice.service;

import com.muktars.datageneratormicroservice.model.Data;

public interface KafkaDataService {
    void send(Data data);
}
