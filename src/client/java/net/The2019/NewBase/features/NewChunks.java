package net.The2019.NewBase.features;

import net.minecraft.client.MinecraftClient;
import net.minecraft.fluid.FluidState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.WorldChunk;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NewChunks {
    private static final MinecraftClient MC = MinecraftClient.getInstance();

    private static final Set<ChunkPos> newChunks = Collections.synchronizedSet(new HashSet<>());
    private static final Set<ChunkPos> oldChunks = Collections.synchronizedSet(new HashSet<>());
    private static final Set<ChunkPos> dontCheckAgain = Collections.synchronizedSet(new HashSet<>());
    private static final Set<BlockPos> newChunkReasons = Collections.synchronizedSet(new HashSet<>());
    private static final Set<BlockPos> oldChunkReasons = Collections.synchronizedSet(new HashSet<>());


    public static void checkLoadedChunk(WorldChunk chunk) {
        ChunkPos chunkPos = chunk.getPos();
        if(newChunks.contains(chunkPos) || oldChunks.contains(chunkPos) || dontCheckAgain.contains(chunkPos))
            return;

        int minX = chunkPos.getStartX();
        int minY = chunk.getBottomY();
        int minZ = chunkPos.getStartZ();
        int maxX = chunkPos.getEndX();
        int maxY = chunk.getHighestNonEmptySection() + 16;
        int maxZ = chunkPos.getEndZ();

        for(int x = minX; x <= maxX; x++)
            for(int y = minY; y <= maxY; y++)
                for(int z = minZ; z <= maxZ; z++) {

                    BlockPos pos = new BlockPos(x, y, z);
                    FluidState fluidState = chunk.getFluidState(pos);

                    if(fluidState.isEmpty() || fluidState.isStill())
                        continue;


                    oldChunks.add(chunkPos);
                    oldChunkReasons.add(pos);
                    if (MC.player != null) {
                        MC.player.sendMessage(Text.of("old chunk at " + chunkPos), false);
                    }
                }

        dontCheckAgain.add(chunkPos);
    }
    public static void clearChunks() {
        newChunks.clear();
        oldChunks.clear();
        newChunkReasons.clear();
        oldChunkReasons.clear();
    }
}

