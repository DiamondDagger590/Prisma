package us.eunoians.prisma;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ColorProvider{
  
  private static Map<Character, RGBWrapper> colorMap = new HashMap<>();
  
  ColorProvider(Prisma prisma){
    
    //Get the colors.yml and load it in
    File file = new File(prisma.getDataFolder(), "colors.yml");
    FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
    
    //Iterate through all colors in the colors.yml
    for(String color : fileConfiguration.getConfigurationSection("ChatColors").getKeys(false)){
      
      //Setup our key for extracting values
      String key = "ChatColors." + color + ".";
      
      //Get the chat color char
      char chatChar = fileConfiguration.getString(key + "ColorCode").charAt(0);
      
      //Setup our RGBWrapper
      RGBWrapper rgbWrapper = null;
      
      //Try to make a wrapper from RGB color format
      if(fileConfiguration.contains(key + "RGB")){
        String[] RGB = fileConfiguration.getString(key + "RGB").split(":");
        int red = Integer.parseInt(RGB[0]);
        int green = Integer.parseInt(RGB[1]);
        int blue = Integer.parseInt(RGB[2]);
        rgbWrapper = new RGBWrapper(red, green, blue);
      }
      colorMap.put(chatChar, rgbWrapper);
    }
  }
  
  /**
   * Gets a RGBWrapper from the provided chat color code
   *
   * @param chatCode The chat color code to get a RGB wrapper for
   * @return The RGBWrapper associated with the chat color code or null if none for that code is present
   */
  public static RGBWrapper getRGBWrapper(char chatCode){
    return colorMap.get(chatCode);
  }
  
  private class RGBWrapper{
    
    private int red;
    private int green;
    private int blue;
    
    public RGBWrapper(int red, int green, int blue){
      this.red = red;
      this.green = green;
      this.blue = blue;
    }
  
    public int getRed(){
      return red;
    }
  
    public int getGreen(){
      return green;
    }
    
    public void setRed(int red){
      this.red = red;
    }
  
    public int getBlue(){
      return blue;
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

    private class RGBWrapper {

        private static final String HEX_REGEX = "/^#?([a-f\\d]{2})([a-f\\d]{2})([a-f\\d]{2})$/i";

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

            // Make sure it's valid hex
            Preconditions.checkArgument(hex.matches(HEX_REGEX), "Invalid hex colour!");

            // SPlit the hex
            String[] hexGroups = hex.split(HEX_REGEX);

            // Make sure the hex is valid
            Preconditions.checkArgument(hexGroups.length == 3, "Invalid hex colour!");

            // Parse the rgb values from the hex
            this.red = Integer.valueOf(hexGroups[0], 16);
            this.blue = Integer.valueOf(hexGroups[1], 16);
            this.green = Integer.valueOf(hexGroups[2], 16));
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