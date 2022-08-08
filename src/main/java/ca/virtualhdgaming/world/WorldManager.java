package ca.virtualhdgaming.world;

import net.minecraft.world.level.levelgen.GeneratorSettings;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

public class WorldManager {

    /**
     * Creates a new normal world.
     * @param name The name of the world.
     * @param environment The environment of the world.
     * @return The created world.
     */
    public World normal(String name, World.Environment environment) {
        return create(name, environment, WorldType.NORMAL);
    }

    /**
     * Creates a new normal world.
     * @param name The name of the world.
     * @param environment The environment of the world.
     * @param settings The settings of the world.
     * @return The created world.
     */
    public World normal(String name, World.Environment environment, GeneratorSettings settings) {
        return create(name, environment, WorldType.NORMAL, settings);
    }

    /**
     * Creates a new flat world.
     * @param name The name of the world.
     * @param environment The environment of the world.
     * @return The created world.
     */
    public World flat(String name, World.Environment environment){
        return create(name, environment, WorldType.FLAT);
    }

    /**
     * Creates a new flat world.
     * @param name The name of the world.
     * @param environment The environment of the world.
     * @param settings The settings of the world.
     * @return The created world.
     */
    public World flat(String name, World.Environment environment, GeneratorSettings settings){
        return create(name, environment, WorldType.FLAT, settings);
    }

    /**
     * Creates a world with the given name , environment and world type.
     * @param name The name of the world.
     * @param environment The environment of the world.
     * @param type The world type of the world.
     * @return The created world.
     */
    public World create(String name, World.Environment environment, WorldType type) {
        WorldCreator worldCreator = new WorldCreator(name);
        worldCreator.environment(environment);
        worldCreator.type(type);
        return worldCreator.createWorld();
    }

    /**
     * Creates a world with the given name , environment , type, and generator settings.
     * @param name The name of the world.
     * @param environment The environment of the world.
     * @param type The world type of the world.
     * @param settings The generator settings of the world.
     * @return The created world.
     */
    public World create(String name, World.Environment environment, WorldType type, GeneratorSettings settings) {
        WorldCreator worldCreator = new WorldCreator(name);
        worldCreator.environment(environment);
        worldCreator.type(type);
        worldCreator.generatorSettings(String.valueOf(settings));
        return worldCreator.createWorld();
    }

    /**
     * Creates a world with the given name , environment , type, and string generator settings.
     * @param name The name of the world.
     * @param environment The environment of the world.
     * @param type The world type of the world.
     * @param generatorSettings The string generator settings of the world.
     * @return The created world.
     */
    public World create(String name, World.Environment environment, WorldType type, String generatorSettings) {
        WorldCreator worldCreator = new WorldCreator(name);
        worldCreator.environment(environment);
        worldCreator.type(type);
        worldCreator.generatorSettings(generatorSettings);
        return worldCreator.createWorld();
    }

    /**
     * Unloads a world with the given name.
     * @param worldName The name of the world.
     */
    public void unload(String worldName) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            Bukkit.unloadWorld(world, false);
        }
    }

    /**
     * Removes a world with the given name.
     * @param worldName The name of the world.
     */
    public void remove(String worldName) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            Bukkit.unloadWorld(world, true);
        }
    }

}
