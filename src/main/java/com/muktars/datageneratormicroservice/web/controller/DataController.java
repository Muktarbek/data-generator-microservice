package com.muktars.datageneratormicroservice.web.controller;

import com.muktars.datageneratormicroservice.model.Data;
import com.muktars.datageneratormicroservice.model.test.DataTestOptions;
import com.muktars.datageneratormicroservice.service.KafkaDataService;
import com.muktars.datageneratormicroservice.service.TestDataService;
import com.muktars.datageneratormicroservice.web.dto.DataDto;
import com.muktars.datageneratormicroservice.web.dto.DataTestOptionsDto;
import com.muktars.datageneratormicroservice.web.mapper.DataMapper;
import com.muktars.datageneratormicroservice.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;
    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;

    @PostMapping("/send")
    public void send(@RequestBody DataDto dto) {
        Data data = dataMapper.toEntity(dto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionDto);
        testDataService.sendMessages(testOptions);
    }

}
