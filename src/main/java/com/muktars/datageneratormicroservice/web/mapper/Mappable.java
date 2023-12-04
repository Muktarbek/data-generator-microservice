package com.muktars.datageneratormicroservice.web.mapper;

public interface Mappable<E, D> {

    E toEntity(D dto);

    D toDto(E entity);
}