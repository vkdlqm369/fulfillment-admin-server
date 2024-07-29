package com.daou.sabangnetserver.label.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.fulfillmentweb.domain.common.dto.shippingLabel
 * @fileName : ShippingLabelReleaseItem
 * @date : 2024. 5. 30.
 */
@Getter
@NoArgsConstructor
public class ShippingLabelReleaseItemVo {

    private Long releaseItemId;
    private Long releaseId;
    private Long shippingProductId;
    private Integer quantity;
    private Integer releaseQuantity;
    private Long memberId;
    private Integer releaseStatus;
    private String shippingCode;
    private Long shippingOrderInfoId;
    private Integer workingFlag;
    private String productCode;
    private String productName;
    private String upc;
    private String manageCode1;
    private Long locationId;
    private String manageCode3;
    private Long orderId;
    private String defaultLocationName;
    private String memo1;
    private String memo2;
    private String memo3;
    private String memo5;
    private String supplyCompanyName;
    private String categoryName;

    @Builder
    public ShippingLabelReleaseItemVo(Long releaseItemId, Long releaseId, Long shippingProductId,
            Integer quantity, Integer releaseQuantity, Long memberId, Integer releaseStatus,
            String shippingCode, Long shippingOrderInfoId, Integer workingFlag, String productCode,
            String productName, String upc, String manageCode1, Long locationId, String manageCode3,
            Long orderId, String defaultLocationName, String memo1, String memo2, String memo3,
            String memo5, String supplyCompanyName, String categoryName) {
        this.releaseItemId = releaseItemId;
        this.releaseId = releaseId;
        this.shippingProductId = shippingProductId;
        this.quantity = quantity;
        this.releaseQuantity = releaseQuantity;
        this.memberId = memberId;
        this.releaseStatus = releaseStatus;
        this.shippingCode = shippingCode;
        this.shippingOrderInfoId = shippingOrderInfoId;
        this.workingFlag = workingFlag;
        this.productCode = productCode;
        this.productName = productName;
        this.upc = upc;
        this.manageCode1 = manageCode1;
        this.locationId = locationId;
        this.manageCode3 = manageCode3;
        this.orderId = orderId;
        this.defaultLocationName = defaultLocationName;
        this.memo1 = memo1;
        this.memo2 = memo2;
        this.memo3 = memo3;
        this.memo5 = memo5;
        this.supplyCompanyName = supplyCompanyName;
        this.categoryName = categoryName;
    }
}
