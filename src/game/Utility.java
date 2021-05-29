package game;

import java.awt.Image;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Utility {

    public static final JLabel grass = new JLabel(new ImageIcon(Utility.getImage("grass.png")));
    public static final BufferedImage newton = Utility.getImage("newton.png");
    public static final BufferedImage leibniz = Utility.getImage("leibniz.png");
    public static final BufferedImage startingBackgroundImage = Utility.getImage("background.png");

    public static final Font font = Utility.getFont("A.ttf", 60);
    public static final Font typeFont = Utility.getFont("tI-83-plus-large.ttf", 60);

    public static void pause(int length) {

        try {
            Thread.sleep(length);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg); // transform it back
    }

    public static BufferedImage getImage(String fileName) {
        try {
            return ImageIO.read(Utility.class.getClassLoader().getResourceAsStream(fileName));

        } catch (Exception e) {
            System.out.println("Image Error");
            e.printStackTrace();
            return null;
        }
    }

    public static Font getFont(String fileName, float fontsize) {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(
                    Font.createFont(Font.TRUETYPE_FONT, Utility.class.getClassLoader().getResourceAsStream(fileName)));

            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    Utility.class.getClassLoader().getResourceAsStream(fileName));
            return font.deriveFont(fontsize);
        } catch (Exception e) {
            System.out.println("Font Error");
            return null;
        }
    }

    public static Clip makeClip(String fileName) throws Exception {
        AudioInputStream audioInputStream = null;
        try {

            audioInputStream = AudioSystem
                    .getAudioInputStream(new BufferedInputStream(Utility.class.getClassLoader().getResourceAsStream(fileName)));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error finding audio file");
        }

        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-18);
        if (Game.muted) {
            volume.setValue(-80);
        }

        return clip;
    }

    public static Clip addVolume(Clip clip, int add) {
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        if (Game.muted) {
            volume.setValue(-80);
        } else {
            volume.setValue(volume.getValue() + add);
        }
        return clip;
    }

    public static Clip setVolume(Clip clip, int vol) {
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(vol);
        if (Game.muted) {
            volume.setValue(-80);
        }
        return clip;
    }
}
