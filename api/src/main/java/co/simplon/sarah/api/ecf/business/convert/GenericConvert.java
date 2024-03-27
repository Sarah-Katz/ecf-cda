package co.simplon.sarah.api.ecf.business.convert;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class GenericConvert {
    private static GenericConvert instance = new GenericConvert();

    /**
     * @return an instance of the GenericConvert class
     */
    public static GenericConvert getInstance() {
        if (instance == null) {
            instance = new GenericConvert();
        }
        return instance;
    }

    public <T1, T2> T2 toDto(final T1 entity, final Class<T2> dtoClass) {
        T2 dto = null;
        try {
            dto = dtoClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e);
        }
        Field[] dtoFields = dto.getClass().getDeclaredFields();
        Field[] entityFields = entity.getClass().getDeclaredFields();
        int i = 0;
        for (Field field : dtoFields) {
            try {
                field.setAccessible(true);
                entityFields[i].setAccessible(true);
                field.set(dto, entityFields[i].get(entity));
                field.setAccessible(false);
                entityFields[i].setAccessible(false);
                i++;
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return dto;
    }
}