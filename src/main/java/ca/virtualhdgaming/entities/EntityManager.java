package ca.virtualhdgaming.entities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    //region Add

    /**
     * Adds an entity to the world using default world and a location.
     *
     * @param entity   The entity to add.
     * @param location The location to add the entity to.
     */
    public void add(Entity entity, Location location) {
        if (entity == null) return;
        if (location == null) return;

        World world = location.getWorld();
        world.spawnEntity(location, entity.getType());
    }

    /**
     * Adds an entity to the world using a specified world and a location.
     *
     * @param entity The entity to add.
     * @param world  The world to add the entity to.
     * @param x      The x coordinate to add the entity to.
     * @param y      The y coordinate to add the entity to.
     * @param z      The z coordinate to add the entity to.
     */
    public void add(Entity entity, World world, double x, double y, double z) {
        if (entity == null) return;
        if (world == null) return;

        world.spawnEntity(new Location(world, x, y, z), entity.getType());
    }

    /**
     * Adds a random entity to the world using a specified world and a location.
     *
     * @param location The location to add the entity to.
     */
    public void addRandom(Location location) {
        if (location == null) return;
        location.getWorld().spawnEntity(location, EntityType.valueOf(EntityType.values()[(int) (Math.random() * EntityType.values().length)].name()));
    }

    /**
     * Add an amount of specific entities to the given location's world.
     *
     * @param location The location to add the entities to.
     * @param type     The entity type to add.
     * @param amount   The amount of entities to add.
     */
    public void addAmount(Location location, EntityType type, int amount) {
        if (location == null) return;
        for (int i = 0; i < amount; i++) {
            location.getWorld().spawnEntity(location, type);
        }
    }

    /**
     * Add an amount of specific entities to the given location's world using a dispatch radius.
     *
     * @param location The location to add the entities to.
     * @param type     The entity type to add.
     * @param amount   The amount of entities to add.
     * @param radius   The radius to dispatch the entities from.
     */
    public void addAmountDispatchedRadius(Location location, EntityType type, int amount, int radius) {
        if (location == null) return;
        if (radius < 1) return;
        for (int i = 0; i < amount; i++) {
            location.getWorld().spawnEntity(location.clone().add(Math.random() * radius, Math.random() * radius, Math.random() * radius), type);
        }
    }
    //endregion

    //region Remove

    /**
     * Removes an entity from the world using default world.
     *
     * @param entity The entity to remove.
     */
    public void remove(Entity entity) {
        if (entity == null) return;
        World world = Bukkit.getWorlds().get(0);
        if (world.getEntities().isEmpty()) return;
        for (org.bukkit.entity.Entity e : world.getEntities()) {
            if (e.getType().equals(entity.getType())) {
                e.remove();
            }
        }
    }

    /**
     * Removes an entity from the world using a specified world.
     *
     * @param entity The entity to remove.
     * @param world  The world to remove the entity from.
     */
    public void remove(Entity entity, World world) {
        if (entity == null) return;
        if (world.getEntities().isEmpty()) return;
        for (org.bukkit.entity.Entity e : world.getEntities()) {
            if (e.getType().equals(entity.getType())) {
                e.remove();
            }
        }
    }

    /**
     * Removes all entities from the world using a specified world , location and radius.
     *
     * @param location The location to remove the entities from.
     * @param radius   The radius to remove the entities from.
     */
    public void removeRadius(Location location, int radius) {
        if (location == null) return;
        if (radius < 1) return;
        for (Entity entity : location.getWorld().getEntities()) {
            if (entity.getLocation().distance(location) <= radius) {
                entity.remove();
            }
        }
    }

    /**
     * Removes all entities of specific type from the world using a location and radius.
     *
     * @param location   The location to remove the entities from.
     * @param radius     The radius to remove the entities from.
     * @param entityType The entity type to remove.
     */
    public void removeRadiusSpecific(Location location, int radius, EntityType entityType) {
        if (location == null) return;
        if (radius < 1) return;
        if (entityType == null) return;
        for (Entity entity : location.getWorld().getEntities()) {
            if (entity.getLocation().distance(location) <= radius && entity.getType().equals(entityType)) {
                entity.remove();
            }
        }
    }

    /**
     * Removes all entities of a random type from the world using a specified world.
     *
     * @param world The world to remove the entities from.
     */
    public void removeRandom(World world) {
        if (world == null) return;
        for (Entity e : world.getEntities()) {
            if (e.getType().equals(EntityType.valueOf(EntityType.values()[(int) (Math.random() * EntityType.values().length)].name()))) {
                e.remove();
            }
        }
    }
    //endregion

    //region Glow

    /**
     * Sets an entity to glow in a specific radius.
     *
     * @param location The location to set the entity to glow.
     * @param radius   The radius to set the entity to glow.
     * @param glow     bool to set the entity to glow.
     */
    public void glowInRadius(Location location, int radius, boolean glow) {
        if (location == null) return;
        if (radius < 1) return;
        for (Entity entity : location.getWorld().getEntities()) {
            if (entity.getLocation().distance(location) <= radius) {
                entity.setGlowing(glow);
            }
        }
    }

    /**
     * Sets a specific entity to glow in a specific radius.
     *
     * @param location   The location to set the entity to glow.
     * @param radius     The radius to set the entity to glow.
     * @param entityType The entity type to set the glow to.
     * @param glow       bool to set the glow to.
     */
    public void glowSpecificInRadius(Location location, int radius, EntityType entityType, boolean glow) {
        if (location == null) return;
        if (radius < 1) return;
        if (entityType == null) return;
        for (Entity entity : location.getWorld().getEntities()) {
            if (entity.getLocation().distance(location) <= radius && entity.getType().equals(entityType)) {
                entity.setGlowing(glow);
            }
        }
    }

    //endregion

    //region Get

    /**
     * Gets all entities of a specific type from a specified world.
     *
     * @param world      The world to get the entities from.
     * @param entityType The entity type to get.
     * @return A list of entities of the specified type.
     */
    public List<Entity> getAll(World world, EntityType entityType) {
        if (world == null) return null;
        if (entityType == null) return null;
        List<Entity> entities = new ArrayList<>();
        for (Entity entity : world.getEntities()) {
            if (entity.getType().equals(entityType)) {
                entities.add(entity);
            }
        }
        return entities;
    }

    /**
     * Gets all entities of a specific world in a list.
     *
     * @param world The world to get the entities from.
     * @return A list of entities of the specified world.
     */
    public List<Entity> getAll(World world) {
        if (world == null) return null;
        return new ArrayList<>(world.getEntities());
    }

    /**
     * Get all entities within a specific radius of a location.
     *
     * @param location The location to get the entities from.
     * @param radius   The radius to get the entities from.
     * @return A list of entities within the radius.
     */
    public List<Entity> getNearby(Location location, int radius) {
        if (location == null) return null;
        if (radius < 1) return null;
        List<Entity> entities = new ArrayList<>();
        for (Entity entity : location.getWorld().getEntities()) {
            if (entity.getLocation().distance(location) <= radius) {
                entities.add(entity);
            }
        }
        return entities;
    }

    /**
     * Get all entities of a specific type within a specific radius of a location.
     *
     * @param location   The location to get the entities from.
     * @param radius     The radius to get the entities from.
     * @param entityType The entity type to get.
     * @return A list of entities of the specified type within the radius.
     */
    public List<Entity> getNearby(Location location, int radius, EntityType entityType) {
        if (location == null) return null;
        if (radius < 1) return null;
        if (entityType == null) return null;
        List<Entity> entities = new ArrayList<>();
        for (Entity entity : location.getWorld().getEntities()) {
            if (entity.getLocation().distance(location) <= radius && entity.getType().equals(entityType)) {
                entities.add(entity);
            }
        }
        return entities;
    }

    //endregion

}
