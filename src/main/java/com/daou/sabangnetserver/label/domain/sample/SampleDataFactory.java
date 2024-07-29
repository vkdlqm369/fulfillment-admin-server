package com.daou.sabangnetserver.label.domain.sample;

import com.daou.sabangnetserver.label.domain.ShippingLabelData;
import com.daou.sabangnetserver.label.enums.Release.ModuleCode;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.sabangnetserver.label.service
 * @fileName : SampleDataFactory
 * @date : 2024. 7. 29.
 */
@Component
public class SampleDataFactory {

    public ShippingLabelData createSampleData(ModuleCode moduleCode){
        SampleDataBuilder builder =  switch (moduleCode) {
            case CJ -> new CjSampleDataBuilder();
            default -> throw new NoSuchElementException("No such module code");
        };

        return builder.build();
    }

}
