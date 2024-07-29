package com.daou.sabangnetserver.label.service;

import com.daou.sabangnetserver.label.domain.ShippingLabelData;
import com.daou.sabangnetserver.label.domain.sample.SampleDataFactory;
import com.daou.sabangnetserver.label.enums.Release.ModuleCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.sabangnetserver.label.service
 * @fileName : ShippingLabelService
 * @date : 2024. 7. 29.
 */
@Service
@RequiredArgsConstructor
public class ShippingLabelService implements LabelService<ShippingLabelData> {

    private final SampleDataFactory sampleDataFactory;

    @Override
    public ShippingLabelData createLabelData() {
        return sampleDataFactory.createSampleData(ModuleCode.CJ);
    }

}
