package net.The2019.NewBase.render.waypoints;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;

public class WaypointRender {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void renderWaypoint(MatrixStack matrixStack, BlockPos pos, String name) {
        Vec3d camera = mc.gameRenderer.getCamera().getPos();

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();

        double x = pos.getX() - camera.x;
        double y = pos.getY() - camera.y;
        double z = pos.getZ() - camera.z;

        matrixStack.push();
        matrixStack.translate(x, y, z);

        Matrix4f positionMatrix = matrixStack.peek().getPositionMatrix();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);

        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        buffer.vertex(positionMatrix, 0, 1, 0).color(1.0f, 1.0f, 1.0f, 1.0f).next();
        // Add more vertices for your shape as needed

        tessellator.draw();

        matrixStack.pop();

        // Render text
        TextRenderer textRenderer = mc.textRenderer;
        float textX = (float) (pos.getX() - camera.x);
        float textY = (float) (pos.getY() - camera.y);
        textRenderer.draw(Text.literal(name), textX, textY, 1, false, positionMatrix, mc.getBufferBuilders().getOutlineVertexConsumers(), TextRenderer.TextLayerType.NORMAL, 1, 1);

        RenderSystem.disableBlend();
    }
}