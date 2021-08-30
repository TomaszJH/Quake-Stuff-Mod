package tomaszjh.quakeadditions.weapons.entity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import tomaszjh.quakeadditions.weapons.entity.projectile.EntityPlasma;

public class EntityPlasmaRenderer extends EntityRenderer<EntityPlasma> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation("quake_additions:textures/entities/plasma_ball.png");



    public EntityPlasmaRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);

    }

    public void render(EntityPlasma entity, float entityYaw, float partialTicks, MatrixStack matrix, IRenderTypeBuffer buffer, int packedLight) {
        matrix.push();
        matrix.rotate(renderManager.getCameraOrientation());
        matrix.scale(0.5f, 0.5f, 0.5f);
        matrix.scale(0.5F, 0.5F, 0.5F);
        IVertexBuilder builder = buffer.getBuffer(QARendererType.projectile_render(getEntityTexture(entity)));
        Matrix4f matrix4f = matrix.getLast().getMatrix();
        builder.pos(matrix4f, -1, -1, 0).tex(1, 1).endVertex();
        builder.pos(matrix4f, -1, 1, 0).tex(1, 0).endVertex();
        builder.pos(matrix4f, 1, 1, 0).tex(0, 0).endVertex();
        builder.pos(matrix4f, 1, -1, 0).tex(0, 1).endVertex();
        matrix.pop();
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPlasma entity) {
        return TEXTURE;
    }
}