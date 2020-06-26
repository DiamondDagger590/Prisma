# Prisma

### Purpose
Prisma is a new plugin that allows for developers to easily hook in and use custom color codes
provided from the colors.yml.

The idea behind Prisma is to allow for server owners to easily define new color codes using
RGB and Hex codes that they can then use on things such as plugin's language files, provided
they hook into prisma

### Server Owner Usage
To use Prisma, simply put the jar in your plugins folder, run the server once to generate the
colors.yml, and then you are free to add your custom color codes.

This will only work with plugins that hook into Prisma.

You will not be able to assign custom color codes that are currently used by vanilla, such as b, a, 4, l, etc.

At the moment, Prisma only works with chat messages, but we are looking to move that into action bars and other formats in the future.

### Developer Implementation
Adding support for Prisma is amazingly easy. All you need to do is place this method in a util
class such as a Methods class, and change your player.sendMessage()s to run through this method.
This method would provide vanilla and custom color code implementation, and if Prisma is absent,
would not break and just use vanilla coloring.

```java
public static void sendMessage(Player player, String message) {

    // Probably want to move this to onEnable and cache the result
    if (Bukkit.getPluginManager().isPluginEnabled("Prisma")) {
        message = ColorProvider.translatePrisma(message, false);
    }
    
    // Send the message to the player
    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
}
```
       
Prisma also provides over 130 colors in an enum called PrismaColor you can use as easily as so

```java
player.sendMessage(PrismaColor.SALMON + "SALMON");
```
