package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageScaler {

    public static
    /**
     * Credit SO: https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
     */
    ImageIcon getScaledImage(Image srcs, int width, int height){
        BufferedImage buffImg = new BufferedImage(width,height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = buffImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcs, 0,0,width,height,null);
        g2.dispose();

        return new ImageIcon(buffImg);
    }
    /*
    *@param height - height of desired image
     */
    public static ImageIcon getScaledImageByHeight(Image srcs, int height){
        System.out.println(srcs.getHeight(null));

        double ratio = (double)srcs.getWidth(null)/(double)srcs.getHeight(null);
        System.out.println("ratio = " + ratio);
        int width = (int)(height*ratio);
        BufferedImage buffImg = new BufferedImage(width,height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = buffImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcs, 0,0,width,height,null);
        g2.dispose();

        return new ImageIcon(buffImg);
    }
}
