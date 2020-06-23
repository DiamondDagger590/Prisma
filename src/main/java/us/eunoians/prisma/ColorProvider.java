package us.eunoians.prisma;

import java.util.HashMap;
import java.util.Map;

public class ColorProvider{
  
  private static Map<Character, RGBWrapper> colorMap = new HashMap<>();
  
  ColorProvider(Prisma prisma){
  
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
    
    public void setGreen(int green){
      this.green = green;
    }
  
    public void setBlue(int blue){
      this.blue = blue;
    }
  }
}