/* * Copyright 2017 Mario Contreras <marioc@nazul.net>. * * Licensed under the Apache License, Version 2.0 (the "License"); * you may not use this file except in compliance with the License. * You may obtain a copy of the License at * *      http://www.apache.org/licenses/LICENSE-2.0 * * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. * See the License for the specific language governing permissions and * limitations under the License. */package mx.iteso.desi.vision;import java.awt.image.BufferedImage;import java.io.ByteArrayInputStream;import java.io.InputStream;import javax.imageio.ImageIO;import javax.swing.ImageIcon;import javax.swing.JLabel;import org.opencv.core.Mat;import org.opencv.core.MatOfByte;import org.opencv.imgcodecs.Imgcodecs;/** * * @author parres */public class ImagesMatUtils {    public static JLabel MatToJLabel(Mat mat) {        JLabel ret = null;        if (mat.empty()) {            return null;        }        BufferedImage bufImage = null;        try {            InputStream in = MatToInputStream(mat);            bufImage = ImageIO.read(in);            ret = new JLabel(new ImageIcon(bufImage));        } catch (Exception e) {            e.printStackTrace();        }        return ret;    }    public static ImageIcon MatToImageIcon(Mat mat) {        ImageIcon ret = null;        BufferedImage bufImage = null;        try {            InputStream in = MatToInputStream(mat);            bufImage = ImageIO.read(in);            ret = new ImageIcon(bufImage);        } catch (Exception e) {            e.printStackTrace();        }        return ret;    }    public static InputStream MatToInputStream(Mat mat) {        InputStream ret = null;        MatOfByte matOfByte = new MatOfByte();        Imgcodecs.imencode(".jpg", mat, matOfByte);        byte[] byteArray = matOfByte.toArray();        ret = new ByteArrayInputStream(byteArray);        return ret;    }}