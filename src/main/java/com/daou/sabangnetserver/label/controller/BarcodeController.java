package com.daou.sabangnetserver.label.controller;

import com.daou.sabangnetserver.label.domain.BarcodeGenerator;
import com.google.zxing.WriterException;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.sabangnetserver.label.controller
 * @fileName : BarcodeController
 * @date : 2024. 7. 29.
 */
@RequestMapping(path = "/barcode")
@RestController
@RequiredArgsConstructor
public class BarcodeController {

    private final BarcodeGenerator barcodeGenerator;

    @GetMapping(path = "/getBarcode128/{withFactor}/{totalHeight}/{barcodeData}")
    public ResponseEntity<Resource> getBarcodeType128(@PathVariable int withFactor,
            @PathVariable int totalHeight, @PathVariable String barcodeData)
            throws IOException {
        Resource barcode128C = barcodeGenerator.getBarcode128C(withFactor, totalHeight,
                barcodeData);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(barcode128C);
    }

    @GetMapping(path = "/getBarcode128A/{withFactor}/{totalHeight}/{barcodeData}")
    public ResponseEntity<Resource> getBarcodeType128A(@PathVariable int withFactor,
            @PathVariable int totalHeight, @PathVariable String barcodeData)
            throws IOException {
        Resource barcode = barcodeGenerator.getBarcode128A(withFactor, totalHeight,
                barcodeData);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(barcode);
    }

    @GetMapping(path = "/getBarcodePNG128C/{withFactor}/{totalHeight}/{barcodeData}")
    public ResponseEntity<Resource> getBarcodeType128C(@PathVariable int withFactor,
            @PathVariable int totalHeight, @PathVariable String barcodeData)
            throws IOException {
        Resource barcode = barcodeGenerator.getBarcodePNG128C(withFactor, totalHeight,
                barcodeData);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(barcode);
    }

    @GetMapping(path = "/getBarcode39/{withFactor}/{totalHeight}/{barcodeData}")
    public ResponseEntity<Resource> getBarcodeType39(@PathVariable int withFactor,
            @PathVariable int totalHeight, @PathVariable String barcodeData)
            throws IOException {
        Resource barcode = barcodeGenerator.getBarcode39(withFactor, totalHeight,
                barcodeData);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(barcode);
    }

    @GetMapping(path = "/getBarcodeInter25/{withFactor}/{totalHeight}/{barcodeData}")
    public ResponseEntity<Resource> getBarcodeInter25(@PathVariable int withFactor,
            @PathVariable int totalHeight, @PathVariable String barcodeData)
            throws IOException {
        Resource barcode128C = barcodeGenerator.getBarcodeITF(withFactor, totalHeight,
                barcodeData);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(barcode128C);
    }

    @GetMapping(path = "/getBarcodePNGInter25/{withFactor}/{totalHeight}/{barcodeData}")
    public ResponseEntity<Resource> getBarcodePNGInter25(@PathVariable int withFactor,
            @PathVariable int totalHeight, @PathVariable String barcodeData)
            throws IOException {
        Resource barcode128C = barcodeGenerator.getBarcodePNGITF(withFactor, totalHeight,
                barcodeData);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(barcode128C);
    }

    @GetMapping(path = "/qrcode/{data}")
    public ResponseEntity<Resource> getQrCode(@PathVariable String data)
            throws IOException, WriterException {
        Resource qrCode = barcodeGenerator.getQrCode(data);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(qrCode);
    }

}
