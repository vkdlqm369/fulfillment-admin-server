package com.daou.sabangnetserver.label.domain;

import com.daou.sabangnetserver.label.vo.InterconnectWorkPartnerInfoVo;
import com.daou.sabangnetserver.label.vo.ShippingLabelInterconnectWorkDetailVo;
import com.daou.sabangnetserver.label.vo.ShippingLabelReleaseItemVo;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.sabangnetserver.label.domain
 * @fileName : ShippingLabelData
 * @date : 2024. 7. 29.
 */
@Getter
@Builder
public class ShippingLabelData {
    // ShippingLabelInterconnectWorkDetail ($interconnect_work_deteil_result)
    private ShippingLabelInterconnectWorkDetailVo detail;

    // courierAttribute ($courier_attribute)
    private Map<String, Map<String, String>> courierAttribute;

    // partnerInfo ($partner_info)
    private InterconnectWorkPartnerInfoVo partnerInfo;

    // ShippingOrderInfo ($shipping_order_info)
    private String shippingDate; // ShippingOrderInfo.getOrderDate()
    private Integer shippingSeq; // ShippingOrderInfo.getOrderSeq()

    // List<ShippingLabelReleaseItem>
    private List<ShippingLabelReleaseItemVo> shippingItems;
    // shippingItems.size()
    private Integer totalShippingItemCount;

    // workAttributes ($work_attributes) + releaseAttributes ($release_attributes)
    private Map<String, String> attribute;

    // totalPage ($total_page)
    private Integer totalPage;

    // currentPage ($current_page)
    private Integer currentPage;

    private Integer addressTotal; // 1
    private Integer addressNow; // 1
}
