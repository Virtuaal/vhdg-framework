package ca.virtualhdgaming.visuals;

import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;

public class QuickVisuals {

    //region Title

    /**
     * Send a title to a player
     * @param player The player to send the title to
     * @param topMessage The top message of the title
     * @param bottomMessage The bottom message of the title
     * @param fadeIn The fade in time of the title
     * @param stay The stay time of the title
     * @param fadeOut The fade out time of the title
     * @param topColor The top color of the title
     * @param bottomColor The bottom color of the title
     */
    public static void fullTitle(Player player, String topMessage, String bottomMessage, int fadeIn, int stay, int fadeOut, TextColor topColor, TextColor bottomColor) {
        Title newTitle = new Title.TitleBuilder(topMessage, bottomMessage)
                        .fadeIn(fadeIn)
                        .stay(stay)
                        .fadeOut(fadeOut)
                        .topColor(topColor)
                        .bottomColor(bottomColor)
                        .build();

        newTitle.send("VirtualHDGaming");
    }

    /**
     * Send a title to a player
     * @param player The player to send the title to
     * @param topMessage The top message of the title
     * @param bottomMessage The bottom message of the title
     * @param fadeIn The fade in time of the title
     * @param stay The stay time of the title
     * @param fadeOut The fade out time of the title
     */
    public static void fullTitle(Player player, String topMessage, String bottomMessage, int fadeIn, int stay, int fadeOut) {
        Title newTitle = new Title.TitleBuilder(topMessage, bottomMessage)
                        .fadeIn(fadeIn)
                        .stay(stay)
                        .fadeOut(fadeOut)
                        .topColor(NamedTextColor.WHITE)
                        .bottomColor(NamedTextColor.WHITE)
                        .build();

        newTitle.send(player);
    }

    /**
     * Send a title to a player
     * @param player The player to send the title to
     * @param topMessage The top message of the title
     * @param bottomMessage The bottom message of the title
     * @param fadeIn The fade in time of the title
     * @param stay The stay time of the title
     * @param fadeOut The fade out time of the title
     * @param topColor The top color of the title
     * @param bottomColor The bottom color of the title
     */
    public static void fullTitle(String player, String topMessage, String bottomMessage, int fadeIn, int stay, int fadeOut, TextColor topColor, TextColor bottomColor) {
        Title newTitle = new Title.TitleBuilder(topMessage, bottomMessage)
                        .fadeIn(fadeIn)
                        .stay(stay)
                        .fadeOut(fadeOut)
                        .topColor(topColor)
                        .bottomColor(bottomColor)
                        .build();

        newTitle.send(player);
    }

    /**
     * Send a title to a player
     * @param player The player to send the title to
     * @param topMessage The top message of the title
     * @param bottomMessage The bottom message of the title
     * @param fadeIn The fade in time of the title
     * @param stay The stay time of the title
     * @param fadeOut The fade out time of the title
     */
    public static void fullTitle(String player, String topMessage, String bottomMessage, int fadeIn, int stay, int fadeOut) {
        Title newTitle = new Title.TitleBuilder(topMessage, bottomMessage)
                        .fadeIn(fadeIn)
                        .stay(stay)
                        .fadeOut(fadeOut)
                        .topColor(NamedTextColor.WHITE)
                        .bottomColor(NamedTextColor.WHITE)
                        .build();

        newTitle.send(player);
    }

    /**
     * Send a title to a player
     * @param player The player to send the title to
     * @param topMessage The top message of the title
     * @param fadeIn The fade in time of the title
     * @param stay The stay time of the title
     * @param fadeOut The fade out time of the title
     * @param topColor The top color of the title
     */
    public static void titleTop(Player player, String topMessage, int fadeIn, int stay, int fadeOut, TextColor topColor) {
        Title newTitle = new Title.TitleBuilder(topMessage, "")
                        .fadeIn(fadeIn)
                        .stay(stay)
                        .fadeOut(fadeOut)
                        .topColor(topColor)
                        .bottomColor(NamedTextColor.WHITE)
                        .build();

        newTitle.send(player);
    }

    /**
     * Send a title to a player
     * @param player The player to send the title to
     * @param bottomMessage The bottom message of the title
     * @param fadeIn The fade in time of the title
     * @param stay The stay time of the title
     * @param fadeOut The fade out time of the title
     * @param bottomColor The bottom color of the title
     */
    public static void titleBottom(Player player, String bottomMessage, int fadeIn, int stay, int fadeOut, TextColor bottomColor) {
        Title newTitle = new Title.TitleBuilder("", bottomMessage)
                        .fadeIn(fadeIn)
                        .stay(stay)
                        .fadeOut(fadeOut)
                        .topColor(NamedTextColor.WHITE)
                        .bottomColor(bottomColor)
                        .build();

        newTitle.send(player);
    }

    //endregion

    //region ActionBar
    //endregion

}
