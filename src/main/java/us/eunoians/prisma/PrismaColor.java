package us.eunoians.prisma;

import net.md_5.bungee.api.ChatColor;

public enum PrismaColor {

    LIGHT_SALMON("#FFA07A"),
    SALMON("#FA8072"),
    DARK_SALMON("#E9967A"),
    LIGHT_CORAL("#F08080"),
    INDIAN_RED("#CD5C5C"),
    CRIMSON("#DC143C"),
    FIREBRICK("#B22222"),
    RED("#FF0000"),
    DARK_RED("#8B0000"),
    CORAL("#FF7F50"),
    TOMATO("#FF6347"),
    ORANGE_RED("#FF4500"),
    GOLD("#FFD700"),
    ORANGE("#FFA500"),
    DARK_ORANGE("#FF8C00"),
    LIGHT_YELLOW("#FFFFE0"),
    LEMON_CHIFFON("#FFFACD"),
    LIGHT_GOLDEN_ROD_YELLOW("#FAFAD2"),
    PAPAYA_WHIP("#FFEFD5"),
    MOCCASIN("#FFE4B5"),
    PEACH_PUFF("#FFDAB9"),
    PALE_GOLDEN_ROD("#EEE8AA"),
    KHAKI("#F0E68C"),
    DARK_KHAKI("#BDB76B"),
    YELLOW("#FFFF00"),
    LAWN_GREEN("#7CFC00"),
    CHARTREUSE("#7FFF00"),
    LIME_GREEN("#32CD32"),
    LIME("#00FF00"),
    FOREST_GREEN("#228B22"),
    GREEN("#008000"),
    DARK_GREEN("#006400"),
    GREEN_YELLOW("#ADFF2F"),
    YELLOW_GREEN("#9ACD32"),
    SPRING_GREEN("#00FF7F"),
    MEDIUM_SPRING_GREEN("#00FA9A"),
    LIGHT_GREEN("#90EE90"),
    PALE_GREEN("#98FB98"),
    DARK_SEA_GREEN("#8FBC8F"),
    MEDIUM_SEAG_REEN("#3CB371"),
    SEAG_REEN("#2E8B57"),
    OLIVE("#808000"),
    DARK_OLIVE_GREEN("#556B2F"),
    OLIVE_DRAB("#6B8E23"),
    LIGHT_CYAN("#E0FFFF"),
    CYAN("#00FFFF"),
    AQUA("#00FFFF"),
    AQUAMARINE("#7FFFD4"),
    MEDIUM_AQUAMARINE("#66CDAA"),
    PALE_TURQUOISE("#AFEEEE"),
    TURQUOISE("#40E0D0"),
    MEDIUM_TURQUOISE("#48D1CC"),
    DARK_TURQUOISE("#00CED1"),
    LIGHT_SEA_GREEN("#20B2AA"),
    CADET_BLUE("#5F9EA0"),
    DARK_CYAN("#008B8B"),
    TEAL("#008080"),
    POWDER_BLUE("#B0E0E6"),
    LIGHT_BLUE("#ADD8E6"),
    LIGHT_SKY_BLUE("#87CEFA"),
    SKY_BLUE("#87CEEB"),
    DEEP_SKY_BLUE("#00BFFF"),
    LIGHT_STEEL_BLUE("#B0C4DE"),
    DODGER_BLUE("#1E90FF"),
    CORNFLOWER_BLUE("#6495ED"),
    STEEL_BLUE("#4682B4"),
    ROYAL_BLUE("#4169E1"),
    BLUE("#0000FF"),
    MEDIUM_BLUE("#0000CD"),
    DARK_BLUE("#00008B"),
    NAVY("#000080"),
    MIDNIGHT_BLUE("#191970"),
    MEDIUM_SLATE_BLUE("#7B68EE"),
    SLATE_BLUE("#6A5ACD"),
    DARK_SLATE_BLUE("#483D8B"),
    LAVENDER("#E6E6FA"),
    THISTLE("#D8BFD8"),
    PLUM("#DDA0DD"),
    VIOLET("#EE82EE"),
    ORCHID("#DA70D6"),
    FUCHSIA("#FF00FF"),
    MAGENTA("#FF00FF"),
    MEDIUM_ORCHID("#BA55D3"),
    MEDIUM_PURPLE("#9370DB"),
    BLUE_VIOLET("#8A2BE2"),
    DARK_VIOLET("#9400D3"),
    DARK_ORCHID("#9932CC"),
    DARK_MAGENTA("#8B008B"),
    PURPLE("#800080"),
    INDIGO("#4B0082"),
    PINK("#FFC0CB"),
    LIGHT_PINK("#FFB6C1"),
    HOT_PINK("#FF69B4"),
    DEEP_PINK("#FF1493"),
    PALE_VIOLET_RED("#DB7093"),
    MEDIUM_VIOLET_RED("#C71585"),
    WHITE("#FFFFFF"),
    SNOW("#FFFAFA"),
    HONEYDEW("#F0FFF0"),
    MINT_CREAM("#F5FFFA"),
    AZURE("#F0FFFF"),
    ALICEBLUE("#F0F8FF"),
    GHOST_WHITE("#F8F8FF"),
    WHITE_SMOKE("#F5F5F5"),
    SEASHELL("#FFF5EE"),
    BEIGE("#F5F5DC"),
    OLD_LACE("#FDF5E6"),
    FLORAL_WHITE("#FFFAF0"),
    IVORY("#FFFFF0"),
    ANTIQUE_WHITE("#FAEBD7"),
    LINEN("#FAF0E6"),
    LAVENDER_BLUSH("#FFF0F5"),
    MISTY_ROSE("#FFE4E1"),
    GAINSBORO("#DCDCDC"),
    LIGHT_GRAY("#D3D3D3"),
    SILVER("#C0C0C0"),
    DARK_GRAY("#A9A9A9"),
    GRAY("#808080"),
    DIMGRAY("#696969"),
    LIGHT_SLATE_GRAY("#778899"),
    SLATE_GRAY("#708090"),
    DARK_SLATE_GRAY("#2F4F4F"),
    BLACK("#000000"),
    CORN_SILK("#FFF8DC"),
    BLANCHED_ALMOND("#FFEBCD"),
    BISQUE("#FFE4C4"),
    NAVAJO_WHITE("#FFDEAD"),
    WHEAT("#F5DEB3"),
    BURLY_WOOD("#DEB887"),
    TAN("#D2B48C"),
    ROSY_BROWN("#BC8F8F"),
    SANDY_BROWN("#F4A460"),
    GOLDEN_ROD("#DAA520"),
    PERU("#CD853F"),
    CHOCOLATE("#D2691E"),
    SADDLE_BROWN("#8B4513"),
    SIENNA("#A0522D"),
    BROWN("#A52A2A"),
    MAROON("#800000");

    /** Hex colour of the prisma colour */
    private final String hex;

    /**
     * Get the Hex code of the {@link PrismaColor}.
     *
     * @return The Hex code ie '#A52A2A'
     */
    public String getHex() {
        return hex;
    }

    /**
     * Construct a new {@link PrismaColor}.
     *
     * @param hex - the hex of the colour
     */
    PrismaColor(String hex) {
        this.hex = hex;
    }

    @Override
    public String toString() {
        return ChatColor.of(hex) + "";
    }
}
