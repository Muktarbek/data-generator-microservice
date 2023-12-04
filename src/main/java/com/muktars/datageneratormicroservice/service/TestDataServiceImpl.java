package com.muktars.datageneratormicroservice.service;

import com.muktars.datageneratormicroservice.model.Data;
import com.muktars.datageneratormicroservice.model.test.DataTestOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestDataServiceImpl implements TestDataService {

    private final ScheduledExecutorService executorService
            = Executors.newSingleThreadScheduledExecutor();
    private final KafkaDataService kafkaDataService;

    @Override
    public void sendMessages(DataTestOptions testOptions) {
        if (testOptions.getMeasurementTypes().length > 0) {
            executorService.scheduleAtFixedRate(
                    () -> {
                        Data data = new Data();
                        data.setSensorId(
                                getRandomNumber(1, 10)
                        );
                        data.setMeasurement(
                                getRandomNumber(15, 100)
                        );
                        data.setMeasurementType(
                                getMeasurementType(
                                        testOptions.getMeasurementTypes()
                                )
                        );
                        data.setTimestamp(
                                LocalDateTime.now()
                        );
                        kafkaDataService.send(data);
                    },
                    0,
                    testOptions.getDelayInSeconds(),
                    TimeUnit.SECONDS);
        }
    }

    private double getRandomNumber(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    private Data.MeasurementType getMeasurementType(
            Data.MeasurementType[] measurementTypes
    ) {
        int random = (int) (Math.random() * measurementTypes.length);
        return measurementTypes[random];
    }

}
