package us.eunoians.prisma;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RGBWrapperTest {

    @Test
    public void rgbToHex() {

        // Make sure the colour gets converted to hex properly
        assertEquals("#ffba59", new ColorProvider.RGBWrapper(255, 186, 89).toHex());
    }

    @Test
    public void hexToRGB() {

        // Create the RGBWrapper instance
        ColorProvider.RGBWrapper rgbWrapper = new ColorProvider.RGBWrapper("#ffba59");

        // Make sure all the rgb components match
        assertEquals(255, rgbWrapper.getRed());
        assertEquals(186, rgbWrapper.getGreen());
        assertEquals(89, rgbWrapper.getBlue());
    }

    @Test
    public void rgbToColor() {

        // Create the colour instance
        Color color = new ColorProvider.RGBWrapper("#ffba59").toColor();

        // Make sure all the rgb components match
        assertEquals(255, color.getRed());
        assertEquals(186, color.getGreen());
        assertEquals(89, color.getBlue());
    }
}
