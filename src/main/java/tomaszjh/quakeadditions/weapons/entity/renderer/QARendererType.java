package tomaszjh.quakeadditions.weapons.entity.renderer;

import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class QARendererType extends RenderType {

    public QARendererType(String nameIn, VertexFormat formatIn, int drawModeIn, int bufferSizeIn, boolean useDelegateIn, boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
        super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
    }

    public static RenderType projectile_render(ResourceLocation resourceLocation) {
        RenderType.State state = RenderType.State.getBuilder().texture(new RenderState.TextureState(resourceLocation, false, false))
                .lightmap(LIGHTMAP_DISABLED)
                .alpha(new RenderState.AlphaState(0.6f))
                .build(true);
        return makeType("plasma_renderer", DefaultVertexFormats.POSITION_TEX, GL11.GL_QUADS, 256, true, false, state);

    }
}
