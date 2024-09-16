package ru.clevertec.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.domain.Moto;
import ru.clevertec.entity.MotoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MotoMapper {
    List<Moto> toDomains(List<MotoEntity> motoList);

    Moto toDomain(MotoEntity moto);

    MotoEntity toEntity(Moto moto);
}
