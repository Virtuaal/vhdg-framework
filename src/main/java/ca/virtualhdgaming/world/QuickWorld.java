package ca.virtualhdgaming.world;

import org.bukkit.Location;
import org.bukkit.Material;

public class QuickWorld {

    /**
     * Generates a sphere of blocks.
     *
     * @param location The location to generate the sphere at.
     * @param material The material to generate the sphere with.
     * @param radius   The radius of the sphere.
     */
    public static void sphere(Location location, Material material, int radius) {
        if (location == null) return;
        if (radius < 1) return;
        if (material == null) return;
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    if (x * x + y * y + z * z <= radius * radius) {
                        location.getBlock().getRelative(x, y, z).setType(material);
                    }
                }
            }
        }
    }

    /**
     * Generates a cube at the given location using the given material and size.
     *
     * @param location The location to generate the cube at.
     * @param material The material to use for the cube.
     * @param size     The size of the cube.
     */
    public static void cube(Location location, Material material, int size) {
        for (int x = location.getBlockX(); x <= size; x++) {
            for (int y = location.getBlockY(); y <= size; y++) {
                for (int z = location.getBlockZ(); z <= size; z++) {
                    location.getWorld().getBlockAt(x, y, z).setType(material);
                }
            }
        }
    }

    /**
     * Generates a pyramid at the given location using the given material and size.
     *
     * @param location The location to generate the pyramid at.
     * @param material The material to use for the pyramid.
     * @param size     The size of the pyramid.
     */
    public static void pyramid(Location location, Material material, int size) {
        for (int x = location.getBlockX(); x <= size; x++) {
            for (int y = location.getBlockY(); y <= size; y++) {
                for (int z = location.getBlockZ(); z <= size; z++) {
                    if (x * x + z * z <= size * size) {
                        location.getWorld().getBlockAt(x, y, z).setType(material);
                    }
                }
            }
        }
    }

    /**
     * Generates a cylinder at the given location using the given material and size.
     * @param location The location to generate the cylinder at.
     * @param material The material to use for the cylinder.
     * @param radius  The radius of the cylinder.
     * @param height The height of the cylinder.
     */
    public void cylinder(Location location, Material material, int radius, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = -radius; x < radius; x++) {
                for (int z = -radius; z < radius; z++) {
                    location.getBlock().getRelative(x, y, z).setType(material);
                }
            }
        }
    }


}
