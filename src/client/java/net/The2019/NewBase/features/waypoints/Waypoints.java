package net.The2019.NewBase.features.waypoints;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;

import static net.The2019.NewBase.render.waypoints.WaypointRender.renderWaypoint;

public class Waypoints {
    public static HashMap<BlockPos, String> waypoints = new HashMap<>();

    public static void init() {
        addWaypoint(new BlockPos(0, 70, 0), "Test");
    }

    public static void addWaypoint(BlockPos pos, String name) {
        waypoints.put(pos, name);
    }

    public static void renderWaypoints() {
        WorldRenderEvents.END.register(context -> {
            for (BlockPos pos : waypoints.keySet()) {
                renderWaypoint(context, pos, waypoints.get(pos));
            }
        });
    }
}