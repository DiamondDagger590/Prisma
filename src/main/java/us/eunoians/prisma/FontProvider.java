package us.eunoians.prisma;

import us.eunoians.prisma.component.PrismaComponent;

import java.util.Arrays;

//Likely wont even need to use this
public enum FontProvider{
  
  BOLD('l', (prismaComponent) -> {
    prismaComponent.setBold(true);
  }),
  MAGIC('k', (prismaComponent) -> {
    prismaComponent.setObfuscated(true);
  }),
  BOLD('k', (prismaComponent) -> {
    prismaComponent.setBold(true);
  }),
  BOLD('k', (prismaComponent) -> {
    prismaComponent.setBold(true);
  });
  
  private char character;
  private FontFunction fontFunction;
  
  FontProvider(Character character, FontFunction fontFunction){
    this.character = character;
    this.fontFunction = fontFunction;
  }
  
  public static FontProvider getFromChar(Character character){
    return Arrays.stream(values()).filter(fontProvider -> fontProvider.character == character).findFirst().orElse(null);
  }
  
  private interface FontFunction{
    void applyFont(PrismaComponent prismaComponent);
  }
}