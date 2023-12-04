package com.muktars.datageneratormicroservice.web.mapper;

import com.muktars.datageneratormicroservice.model.Data;
import com.muktars.datageneratormicroservice.web.dto.DataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {
}
