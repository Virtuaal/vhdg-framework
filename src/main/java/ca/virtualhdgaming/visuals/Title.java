package ca.virtualhdgaming.visuals;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Title {

    private final String topMessage, bottomMessage;
    private final TextColor topColor, bottomColor;
    private final int fadeIn, stay, fadeOut;

    /**
     * Creates a new Title.
     * @param builder The builder to use.
     */
    private Title(TitleBuilder builder){
        this.topMessage = builder.topMessage;
        this.bottomMessage = builder.bottomMessage;
        this.fadeIn = builder.fadeIn;
        this.stay = builder.stay;
        this.fadeOut = builder.fadeOut;
        this.topColor = builder.topColor;
        this.bottomColor = builder.bottomColor;
    }

    /**
     * Send a title to a player using the player's name.
     * @param player The player to send the title to.
     */
    public void send(String player){
        if(player == null) return;
        if(Bukkit.getPlayer(player) == null) {
            Bukkit.getLogger().warning("The specified player for the title with topMessage " + topMessage
                                        + " and bottomMessage " + bottomMessage + " is not online");
            return;
        }
        send(Objects.requireNonNull(Bukkit.getPlayer(player)));
    }

    /**
     * Send the title to the player.
     * @param player The player to send the title to.
     */
    public void send(Player player){
        final Component tMessage = Component.text(topMessage, topColor);
        final Component bMessage = Component.text(bottomMessage, bottomColor);
        final net.kyori.adventure.title.Title.Times times = net.kyori.adventure.title.Title.Times.times(Duration.ofSeconds(fadeIn), Duration.ofSeconds(stay), Duration.ofSeconds(fadeOut));
        final net.kyori.adventure.title.Title newTitle = net.kyori.adventure.title.Title.title(tMessage, bMessage, times);
        player.showTitle(newTitle);
    }

    /**
     * Send the title to an array of players.
     * @param players The players to send the title to.
     */
    public void send(ArrayList<Player> players){
        for(Player player : players){
            send(player);
        }
    }

    /**
     * Send the title to a collection of players.
     * @param players The players to send the title to.
     */
    public void send(Collection<Player> players){
        for(Player player : players){
            send(player);
        }
    }


    /**
     * Builder for the Title class
     */
    public static class TitleBuilder{
        private final String topMessage;
        private final String bottomMessage;
        private int fadeIn;
        private int stay;
        private int fadeOut;
        private TextColor topColor;
        private TextColor bottomColor;

        /**
         * Create a new TitleBuilder
         * @param topMessage The top message of the title
         * @param bottomMessage The bottom message of the title
         */
        public TitleBuilder(String topMessage, String bottomMessage){
            this.topMessage = topMessage;
            this.bottomMessage = bottomMessage;
            this.fadeIn = 0;
            this.stay = 5;
            this.fadeOut = 0;
        }

        /**
         * Set the time the title takes to fade in
         * @param fadeIn The time in seconds
         * @return The builder
         */
        public TitleBuilder fadeIn(int fadeIn){
            this.fadeIn = fadeIn;
            return this;
        }

        /**
         * Set the time the title stays on screen
         * @param stay The time in seconds
         * @return The builder
         */
        public TitleBuilder stay(int stay){
            this.stay = stay;
            return this;
        }

        /**
         * Set the fade out time
         * @param fadeOut The time in seconds
         * @return The builder
         */
        public TitleBuilder fadeOut(int fadeOut){
            this.fadeOut = fadeOut;
            return this;
        }

        /**
         * Set the top message color
         * @param topColor The color
         * @return The builder
         */
        public TitleBuilder topColor(TextColor topColor){
            this.topColor = topColor;
            return this;
        }

        /**
         * Set the bottom message color
         * @param bottomColor The color
         * @return The builder
         */
        public TitleBuilder bottomColor(TextColor bottomColor){
            this.bottomColor = bottomColor;
            return this;
        }

        /**
         * Build method of the builder
         * @return The built title
         */
        public Title build(){
            Title newTitle = new Title(this);
            validateTitleObject(newTitle);
            return newTitle;
        }

        /**
         * Validate title object and throw an exception if it is not valid.
         * @param title The title object to validate
         */
        private void validateTitleObject(Title title){
            if(title == null){ throw new IllegalArgumentException("Title object cannot be null"); }
        }

    }

}
