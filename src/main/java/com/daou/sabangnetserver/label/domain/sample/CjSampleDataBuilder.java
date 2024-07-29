package com.daou.sabangnetserver.label.domain.sample;

import com.daou.sabangnetserver.label.vo.InterconnectWorkPartnerInfoVo;
import com.daou.sabangnetserver.label.domain.ShippingLabelData;
import com.daou.sabangnetserver.label.vo.ShippingLabelInterconnectWorkDetailVo;
import com.daou.sabangnetserver.label.vo.ShippingLabelReleaseItemVo;
import com.daou.sabangnetserver.label.enums.Release.BoxType;
import com.daou.sabangnetserver.label.enums.Sample.SampleCourierAttributes;
import com.daou.sabangnetserver.label.enums.Sample.SampleInterconnectWorkDetail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.sabangnetserver.label.service
 * @fileName : ShippingLabelDataFactory
 * @date : 2024. 7. 29.
 */
public class CjSampleDataBuilder implements SampleDataBuilder {

    public ShippingLabelData build() {
        return ShippingLabelData.builder()
                .detail(createSampleDetail())
                .courierAttribute(createSampleCourierAttribute())
                .partnerInfo(createSamplePartnerInfo())
                .shippingDate("20240729")
                .shippingSeq(1)
                .shippingItems(createSampleShippingItems())
                .totalShippingItemCount(2)
                .attribute(createSampleAttribute())
                .totalPage(1)
                .currentPage(1)
                .addressTotal(1)
                .addressNow(1)
                .build();
    }

    private static ShippingLabelInterconnectWorkDetailVo createSampleDetail() {
        return SampleInterconnectWorkDetail.CJ.create();
    }

    private static Map<String, Map<String, String>> createSampleCourierAttribute() {
        Map<String, Map<String, String>> courierAttributes = new HashMap<>();
        Map<String, String> boxType = Arrays.stream(BoxType.values())
                .collect(HashMap::new, (map, box) -> map.put(box.getCode(), box.getText()), HashMap::putAll);
        courierAttributes.put("BOX_TYPE", boxType);
        return courierAttributes;
    }

    private static InterconnectWorkPartnerInfoVo createSamplePartnerInfo() {
        return InterconnectWorkPartnerInfoVo.builder()
                .defaultShippingName("노스노스")
                .defaultShippingTel("1899-0846")
                .defaultShippingAddress1("경기도 김포시 김포한강9로75번길 22")
                .defaultShippingAddress2("폴리프라자2 701호")
                .defaultShippingZipcode("10071")
                .build();
    }

    private static List<ShippingLabelReleaseItemVo> createSampleShippingItems() {
        List<ShippingLabelReleaseItemVo> items = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            ShippingLabelReleaseItemVo item = ShippingLabelReleaseItemVo.builder()
                    .memo3("관리메모3")
                    .memo5("관리메모5")
                    .defaultLocationName("대표로케이션")
                    .upc("8801234512344")
                    .productCode("A2021030400001")
                    .productName("LG전자 2019 그램 15ZD990-VX50K (기본)")
                    .manageCode1("테스트 키워드1")
                    .manageCode3("테스트 키워드3")
                    .quantity(1).build();
            items.add(item);
        }
        return items;
    }

    private static Map<String, String> createSampleAttribute() {
        return SampleCourierAttributes.CJ.create();
    }
}
