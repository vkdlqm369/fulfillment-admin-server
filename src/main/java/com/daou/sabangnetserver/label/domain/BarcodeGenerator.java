package com.daou.sabangnetserver.label.domain;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.OneDimensionalCodeWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.sabangnetserver.label.domain
 * @fileName : BarcodeGenerator
 * @date : 2024. 7. 29.
 */
@Component
public class BarcodeGenerator {
    public Resource getBarcode128(int widthFactor, int totalHeight, String barcodeData)
            throws IOException {
        return generateBarcodeResource(barcodeData, widthFactor, totalHeight,
                BarcodeFormat.CODE_128, null, "PNG");
    }

    public Resource getBarcode128A(int widthFactor, int totalHeight, String barcodeData)
            throws IOException {
        return generateBarcodeResource(barcodeData, widthFactor, totalHeight,
                BarcodeFormat.CODE_128, "A", "PNG");
    }

    public Resource getBarcode128C(int widthFactor, int totalHeight, String barcodeData)
            throws IOException {
        return generateBarcodeResource(barcodeData, widthFactor, totalHeight,
                BarcodeFormat.CODE_128, "C", "PNG");
    }

    public Resource getBarcodePNG128C(int widthFactor, int totalHeight, String barcodeData)
            throws IOException {
        return generateBarcodeResource(barcodeData, widthFactor, totalHeight,
                BarcodeFormat.CODE_128, "C", "PNG");
    }

    public Resource getBarcode39(int widthFactor, int totalHeight, String barcodeData)
            throws IOException {
        return generateBarcodeResource(barcodeData, widthFactor, totalHeight, BarcodeFormat.CODE_39,
                null, "JPG");
    }

    public Resource getBarcodeITF(int widthFactor, int totalHeight, String barcodeData)
            throws IOException {
        return generateBarcodeResource(barcodeData, widthFactor, totalHeight, BarcodeFormat.ITF,
                null, "JPG");
    }

    public Resource getBarcodePNGITF(int widthFactor, int totalHeight, String barcodeData)
            throws IOException {
        return generateBarcodeResource(barcodeData, widthFactor, totalHeight, BarcodeFormat.ITF,
                null, "PNG");
    }

    public Resource getQrCode(String data) throws WriterException, IOException {
        BitMatrix bitMatrix = generateQRCode(data, 68, 68,
                Map.of(EncodeHintType.MARGIN, 0, EncodeHintType.ERROR_CORRECTION, "H"));
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        return convertBufferedImageToResource(bufferedImage, "PNG");
    }

    private Resource generateBarcodeResource(String data, int width, int height,
            BarcodeFormat format, String codeSet, String formatName) throws IOException {
        BitMatrix bitMatrix = generateBarcode(data, width, height, format, codeSet);
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        return convertBufferedImageToResource(bufferedImage, formatName);
    }

    private BitMatrix generateBarcode(String data, int width, int height, BarcodeFormat format,
            String codeSet) {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        if (codeSet != null) {
            hints.put(EncodeHintType.FORCE_CODE_SET, codeSet);
        }
        OneDimensionalCodeWriter barcodeWriter = getBarcodeWriter(format);
        return barcodeWriter.encode(data, format, width, height, hints);
    }

    private OneDimensionalCodeWriter getBarcodeWriter(BarcodeFormat format) {
        switch (format) {
            case CODE_128:
                return new Code128Writer();
            case CODE_39:
                return new Code39Writer();
            case ITF:
                return new ITFWriter();
            default:
                throw new IllegalArgumentException("Unsupported barcode format: " + format);
        }
    }

    private BitMatrix generateQRCode(String data, int width, int height,
            Map<EncodeHintType, ?> hints) throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        return qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, hints);
    }

    private Resource convertBufferedImageToResource(BufferedImage bufferedImage, String formatName)
            throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, formatName, outputStream);
        return new ByteArrayResource(outputStream.toByteArray());
    }
}
