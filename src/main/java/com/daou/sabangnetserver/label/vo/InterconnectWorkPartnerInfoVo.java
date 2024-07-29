package com.daou.sabangnetserver.label.vo;

import lombok.Builder;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.fulfillmentweb.domain.common.dto.shippingLabel
 * @fileName : InterconnectWorkPartnerInfo
 * @date : 2024. 5. 29.
 */
@Builder
public record InterconnectWorkPartnerInfoVo(
        Long memberId,
        String defaultShippingZipcode,
        String defaultShippingName,
        String defaultShippingTel,
        String defaultShippingAddress1,
        String defaultShippingAddress2
) {

}
