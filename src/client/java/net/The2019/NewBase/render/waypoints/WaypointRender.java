package net.The2019.NewBase.render.waypoints;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

public class WaypointRender {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void renderWaypoint(WorldRenderContext context, BlockPos pos, String name) {
        Camera camera = context.camera();

        Vec3d targetPosition = new Vec3d(0, 100, 0);
        Vec3d transformedPosition = targetPosition.subtract(camera.getPos());
        MatrixStack matrixStack = context.matrixStack();

        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(camera.getPitch()));
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(camera.getYaw() + 180.0F));
        matrixStack.translate(transformedPosition.x, transformedPosition.y, transformedPosition.z);

        Matrix4f positionMatrix = matrixStack.peek().getPositionMatrix();

        RenderSystem.depthFunc(GL11.GL_ALWAYS);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);


        // Render text
        TextRenderer textRenderer = mc.textRenderer;
        float textX = (float) (pos.getX() - camera.getBlockPos().getX());
        float textY = (float) (pos.getY() - camera.getBlockPos().getY());
        textRenderer.draw(Text.literal(name), textX, textY, 1, false, positionMatrix, mc.getBufferBuilders().getOutlineVertexConsumers(), TextRenderer.TextLayerType.SEE_THROUGH, 1, 1);

        RenderSystem.disableBlend();
        RenderSystem.depthFunc(GL11.GL_LEQUAL);
        RenderSystem.enableCull();
    }
}