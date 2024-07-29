package com.daou.sabangnetserver.label.enums;

import com.daou.sabangnetserver.label.vo.ShippingLabelInterconnectWorkDetailVo;
import java.util.HashMap;
import lombok.Getter;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.sabangnetserver.label.enums
 * @fileName : Sample
 * @date : 2024. 7. 29.
 */
public interface Sample {

    @Getter
    enum SampleInterconnectWorkDetail {
        CJ {
            @Override
            public ShippingLabelInterconnectWorkDetailVo create() {
                return ShippingLabelInterconnectWorkDetailVo.builder()
                        .shippingCode("123456789011")
                        .sendDataDate("2019-01-01 09:00:00")
                        .interconnectWorkUid(26L)
                        .releaseId(227092L)
                        .buyerName("홍길동")
                        .receiverName("홍길순")
                        .shippingAddress1("경기도 용인시 수지구 디지털벨리로 81")
                        .shippingAddress2("다우디지털스퀘어 6층")
                        .zipcode("16878")
                        .tel1("01012345678")
                        .tel2("0212341234")
                        .shippingMessage("경비실에 맡겨주세요.")
                        .releaseCode("R20190101-00001")
                        .printCnt(1)
                        .memo2("관리메모2")
                        .memo3("관리메모3")
                        .dasNum("DAS1")
                        .build();
            }
        };

        public abstract ShippingLabelInterconnectWorkDetailVo create();
    }

    enum SampleCourierAttributes {
        CJ {
            @Override
            public HashMap<String, String> create() {
                HashMap<String, String> attributeData = new HashMap<>();
                attributeData.put("CAL_DV", "01");
                attributeData.put("FRT_DV", "03");
                attributeData.put("BOX_TYPE", "01");
                attributeData.put("FRT", "");
                attributeData.put("RCPT_DV", "01");
                attributeData.put("WORK_DV_CD", "01");
                attributeData.put("REQ_DV_CD", "01");
                attributeData.put("ERRORCD", "0");
                attributeData.put("ERRORMSG", "정재성공");
                attributeData.put("SNDPRZIPNUM", "10071");
                attributeData.put("SNDPROLDADDR", "경기 김포시 구래동");
                attributeData.put("SNDPROLDADDRDTL", "6882-11번지 폴리프라자 2 701호");
                attributeData.put("SNDPRNEWADDR", "경기 김포시 김포한강9로75번길");
                attributeData.put("SNDPRNEWADDRDTL", "22, 폴리프라자 2 701호");
                attributeData.put("SNDPRSHORTADDR", "김포구래");
                attributeData.put("SNDPRETCADDR", "구래동 6882-11");
                attributeData.put("SNDPRCLSFADDR", "구래 6882-11");
                attributeData.put("SNDPRNEWADDRYN", "Y");
                attributeData.put("GTHPREARRBRANCD", "3929");
                attributeData.put("GTHPREARRBRANNM", "경기김포북부");
                attributeData.put("GTHPREARRBRANSHORTNM", "경기김포북부");
                attributeData.put("GTHPREARREMPNUM", "512376");
                attributeData.put("GTHPREARREMPNM", "석*희");
                attributeData.put("GTHPREARREMPNICKNM", "Y54");
                attributeData.put("GTHCLSFCD", "3S58");
                attributeData.put("GTHSUBCLSFCD", "1c");
                attributeData.put("GTHCLSFNM", "김포Sub");
                attributeData.put("RCVRZIPNUM", "10071");
                attributeData.put("RCVROLDADDR", "경기 김포시 구래동");
                attributeData.put("RCVROLDADDRDTL", "6882-11번지 폴리프라자 2 701호");
                attributeData.put("RCVRNEWADDR", "경기 김포시 김포한강9로75번길");
                attributeData.put("RCVRNEWADDRDTL", "22, 폴리프라자 2 701호");
                attributeData.put("RCVRSHORTADDR", "김포구래");
                attributeData.put("RCVRETCADDR", "구래동 6882-11");
                attributeData.put("RCVRCLSFADDR", "구래 6882-11");
                attributeData.put("RCVRNEWADDRYN", "Y");
                attributeData.put("DLVPREARRBRANCD", "4046");
                attributeData.put("DLVPREARRBRANNM", "경기김포");
                attributeData.put("DLVPREARRBRANSHORTNM", "경기김포");
                attributeData.put("DLVPREARREMPNUM", "470153");
                attributeData.put("DLVPREARREMPNM", "이*혁");
                attributeData.put("DLVPREARREMPNICKNM", "Z51");
                attributeData.put("DLVCLSFCD", "3S58");
                attributeData.put("DLVSUBCLSFCD", "1c");
                attributeData.put("DLVCLSFNM", "김포Sub");
                attributeData.put("BSCFARE", "1700");
                attributeData.put("JEJUFARE", "0");
                attributeData.put("DEALFARE", "0");
                attributeData.put("FERRYFARE", "0");
                return attributeData;
            }
        };

        public abstract HashMap<String, String> create();
    }



}
