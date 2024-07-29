package com.daou.sabangnetserver.label.controller;

import com.daou.sabangnetserver.label.domain.ShippingLabelData;
import com.daou.sabangnetserver.label.service.ShippingLabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.sabangnetserver.label.controller
 * @fileName : ShippingLabelController
 * @date : 2024. 7. 29.
 */
@Controller
@RequestMapping(path = "/shippingLabel")
@RequiredArgsConstructor
public class ShippingLabelController {


    private final ShippingLabelService shippingLabelService;

    // 타임리프 사용 예시
    @GetMapping(path = "/print/sample/code")
    public String printSample(Model model) {
        ShippingLabelData data = shippingLabelService.createLabelData();
        model.addAttribute("data", data);
        return "shippingLabel/codeSample";
    }

    // 운송장 출력물 예시
    @GetMapping(path = "/print/sample/result")
    public String printSampleResult() {
        return "shippingLabel/sampleResult";
    }

    /*
     * TODO :
     *  templateId 에 해당하는 라벨을 출력합니다.
     *  1번, 2번 예시 메소드를 참고하여 cj_basic.html 에 해당하는 라벨을 출력하세요.
     */
//    @GetMapping(path = "/print/{templateId}")
//    public String printLabel(@PathVariable String templateId) {
//
//            return "템플릿 ID";
//    }


}
