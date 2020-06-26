package us.eunoians.prisma;

import com.google.common.base.Preconditions;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorProvider {

    private static Map<Character, RGBWrapper> colorMap = new HashMap<>();
    private static Set<Character> vanillaCharacters = new HashSet<>(Arrays.asList('9', '8', '7', '6', '5', '4', '3', '2', '1', 'a', 'b', 'c', 'd', 'e', 'f', 'k', 'l', 'm', 'n', 'o', 'r', '&', '§'));

    /**
     * Initialise the {@link ColorProvider} util.
     *
     * @param prisma - the prisma instance that's initialising the {@link ColorProvider}
     */
    protected static void init (Prisma prisma) {
        //Get the colors.yml and load it in
        File file = new File(prisma.getDataFolder(), "colors.yml");
        FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);

        //Iterate through all colors in the colors.yml
        for (String color : fileConfiguration.getConfigurationSection("ChatColors").getKeys(false)) {

            //Setup our key for extracting values
            String key = "ChatColors." + color + ".";

            //Get the chat color char
            char chatChar = fileConfiguration.getString(key + "ColorCode").charAt(0);

            //Setup our RGBWrapper
            RGBWrapper rgbWrapper = null;

            //Try to make a wrapper from RGB color format
            if (fileConfiguration.contains(key + "RGB")) {
                String[] RGB = fileConfiguration.getString(key + "RGB").split(":");
                int red = Integer.parseInt(RGB[0]);
                int green = Integer.parseInt(RGB[1]);
                int blue = Integer.parseInt(RGB[2]);
                rgbWrapper = new RGBWrapper(red, green, blue);
            }
            colorMap.put(chatChar, rgbWrapper);
        }
    }

    public static String translatePrisma(String message) {
        StringBuilder builder = new StringBuilder();
        boolean isColor = false;
        char colorCode = '&';

        // Loop through all the characters in the message
        for (char letter : message.toCharArray()) {

            // If the letter is a colour code append the colour to the message
            if (isColor) {
                isColor = false;

                // Translate the vanilla colours
                if (vanillaCharacters.contains(letter)) {
                    builder.append(colorCode);
                    builder.append(letter);
                    continue;
                }

                // Translate the colours registered in the colour map
                if (colorMap.containsKey(letter)) {

                    // Append the hex colour to the colour map
                    builder.append(colorCode);
                    builder.append(ChatColor.of(colorMap.get(letter).toHex()));
                    continue;
                }



                builder.append(colorCode);
                builder.append(letter);
                continue;
            }

            if (letter == '&' || letter == '§') {
                isColor = true;
                colorCode = letter;
            }
        }

        return builder.toString();
    }

    /**
     * Gets a RGBWrapper from the provided chat color code
     *
     * @param chatCode The chat color code to get a RGB wrapper for
     * @return The RGBWrapper associated with the chat color code or null if none for that code is present
     */
    public static RGBWrapper getRGBWrapper(char chatCode) {
        return colorMap.get(chatCode);
    }

    protected static class RGBWrapper {

        private static final Pattern HEX_PATTERN = Pattern.compile("#?([a-f\\d]{2})([a-f\\d]{2})([a-f\\d]{2})$");

        private int red;
        private int green;
        private int blue;

        /**
         * Construct a new {@link RGBWrapper}.
         *
         * @param red   - the red component
         * @param green - the green component
         * @param blue  - the blue component
         */
        public RGBWrapper(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        /**
         * Construct a new {@link RGBWrapper} that takes a hex colour as input.
         *
         * @param hex - the hex colour code
         */
        public RGBWrapper(String hex) {

            Color color = Color.decode(hex);

            // Get the component
            this.red = color.getRed();
            this.green = color.getGreen();
            this.blue = color.getBlue();
        }

        /**
         * Convert the RGB colour components to a hex colour that can be used in {@link ChatColor#of(String)}.
         *
         * @return - a hexadecimal string representation of the colours in this {@link RGBWrapper}
         */
        public String toHex () {
            return String.format("#%02x%02x%02x", red, green, blue);
        }

        /**
         * Convert the RGB in this {@link RGBWrapper} to a {@link Color} that can be used in {@link ChatColor#of(Color)}.
         *
         * @return - a color objected created using the rgb components of this RGBWrapper
         */
        public Color toColor () {
            return new Color(red, green , blue);
        }

        public int getRed() {
            return red;
        }

        public int getGreen() {
            return green;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getBlue() {
            return blue;
        }

        public void setGreen(int green) {
            this.green = green;
        }

        public void setBlue(int blue) {
            this.blue = blue;
        }
    }
}