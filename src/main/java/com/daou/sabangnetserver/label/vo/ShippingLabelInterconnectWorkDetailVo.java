package com.daou.sabangnetserver.label.vo;

import lombok.Builder;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.fulfillmentweb.domain.common.dto.shippingLabel
 * @fileName : ShippingLabelInterconnectWorkDetail
 * @date : 2024. 5. 30.
 */
@Builder
public record ShippingLabelInterconnectWorkDetailVo(
        Long interconnectWorkDetailUid,
        Long interconnectWorkUid,
        Long releaseId,
        Integer addressValidateFlag,
        String addressValidateDate,
        Integer sendDataFlag,
        String sendDataDate,
        Integer status,
        Integer cancelFlag,
        String cancelDate,
        Integer printCnt,
        Integer returnFlag,
        Long releaseReturnId,
        Integer reconnect,
        Long createId,
        Long companyInterconnectCourierUid,
        Long memberId,
        String releaseCode,
        Long orderId,
        Integer releaseStatus,
        String shippingCode,
        Long shippingOrderInfoId,
        Integer shippingMethodId,
        String etc1,
        String etc2,
        String etc3,
        String etc4,
        String etc5,
        String orderCode,
        String companyOrderCode,
        String orderCreateDate,
        String buyerName,
        String receiverName,
        String shippingAddress1,
        String shippingAddress2,
        String zipcode,
        String tel1,
        String tel2,
        String shippingMessage,
        String memo1,
        String memo2,
        String memo3,
        String memo4,
        String memo5,
        String deliveryStatusCode,
        String addFee,
        String dasNum

) {

}
