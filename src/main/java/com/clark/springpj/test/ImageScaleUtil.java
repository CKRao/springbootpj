package com.clark.springpj.test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author ClarkRao
 * @date 2019/6/3 10:08
 * @description:
 */
public class ImageScaleUtil {

    public static void main(String[] args) {
        BufferedImage image = resize("C:\\Users\\BLUEING\\Downloads\\imacpro\\timg.jpg", 0.1);
        writeToFile("./super_mini.png",image);
    }

    public static void writeToFile(String file, BufferedImage image) {
        try {
            Path path = Paths.get(file);
            // 输出到文件流
            FileOutputStream out = new FileOutputStream(path.toFile());
            ImageIO.write(image, "png", out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 强制压缩/放大图片到固定的大小.
     *
     * @param fileName        压缩文件("d:\\1.png")
     * @param compressPercent 压缩比例(压缩为原来一半传0.5)
     * @return BufferedImage bufferImage
     */
    public static BufferedImage resize(String fileName, double compressPercent) {
        //原图
        BufferedImage img = null;
        //压缩后图
        BufferedImage compressImg = null;
        int width;
        int height;
        try {
            Path path = Paths.get(fileName);
            img = ImageIO.read(path.toFile());
            width = (int) (img.getWidth() * compressPercent);
            height = (int) (img.getHeight() * compressPercent);
            compressImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            // 绘制缩小后的图
            compressImg.getGraphics().drawImage(img, 0, 0, width, height, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compressImg;
    }
}
