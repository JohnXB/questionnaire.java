package com.johnxb.questionnaire.utils;


import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class BeanMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.create().build();

    public static Mapper getMapper() {
        return mapper;
    }

    /**
     * ????Dozer????????????.
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    /**
     * ????Dozer???Collection?ж????????.
     */
    @SuppressWarnings("rawtypes")
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        if (null == sourceList)
            return null;
        List<T> destinationList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            T destinationObject = mapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * ????Dozer??????A?????????????B??.
     */
    public static void copy(Object source, Object destinationObject) {
        mapper.map(source, destinationObject);
    }
}