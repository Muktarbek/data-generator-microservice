package com.muktars.datageneratormicroservice.web.mapper;

import com.muktars.datageneratormicroservice.model.test.DataTestOptions;
import com.muktars.datageneratormicroservice.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper
        extends Mappable<DataTestOptions, DataTestOptionsDto> {


}
