package com.clark.springpj.test;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarkRao
 * @date 2019/3/2 14:03
 * @description: 二维码
 */
public class zXingTest {

    public static void main(String[] args) {
        //生成二维码
        WriteQRCode();
        //读取二维码
        ReadQRCode();
    }

    public static void ReadQRCode() {

        try {
            MultiFormatReader reader = new MultiFormatReader();
            File file = Paths.get("C:/Users/BLUEING/Desktop/qrcode.png").toFile();
            BufferedImage image = ImageIO.read(file);

            //定义二维码参数
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");

            //读取二维码的结果
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Result result = reader.decode(binaryBitmap);

            System.out.println("读取二维码： " + result.toString());
            System.out.println("二维码格式： " + result.getBarcodeFormat());
            System.out.println("二维码内容： " + result.getText());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void WriteQRCode() {
        final int width = 300;
        final int height = 300;
        String format = "png";
        String content = "www.clarkrao.top";

        //定义二维码的参数
        HashMap map = new HashMap();
        //设置编码
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置纠错等级
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        map.put(EncodeHintType.MARGIN, 2);
        //生成二维码
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height);
            Path file = new File("C:/Users/BLUEING/Desktop/qrcode.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,format,file);
        } catch (WriterException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
