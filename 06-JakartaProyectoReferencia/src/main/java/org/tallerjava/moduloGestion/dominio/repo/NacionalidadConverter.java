package org.tallerjava.moduloGestion.dominio.repo;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.tallerjava.moduloGestion.dominio.Nacionalidad;

//la manera correcta de manejar enums con jpa
@Converter(autoApply = true)
public class NacionalidadConverter implements AttributeConverter<Nacionalidad, Integer> {


    @Override
    public Integer convertToDatabaseColumn(Nacionalidad attribute) {
        return attribute.getId();
    }

    @Override
    public Nacionalidad convertToEntityAttribute(Integer dbData) {
        return Nacionalidad.getById(dbData);
    }
}
