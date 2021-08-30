package tomaszjh.quakeadditions;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tomaszjh.quakeadditions.weapons.entity.renderer.EntityPlasmaRenderer;
import tomaszjh.quakeadditions.weapons.entity.renderer.EntityRocketRenderer;
import tomaszjh.quakeadditions.weapons.registries.WeaponRegistry;

import static tomaszjh.quakeadditions.weapons.registries.WeaponRegistry.PLASMA_GUN;

@Mod(QuakeAdditions.MOD_ID)
@Mod.EventBusSubscriber(modid = QuakeAdditions.MOD_ID)
public class QuakeAdditions {

    public static final String MOD_ID = "quake_additions";
    public static final String MOD_NAME = "Quake Additions";
    public static final String VERSION = "$version";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
    public static ItemGroup TAB = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(PLASMA_GUN.get());
        }
    };

    public QuakeAdditions() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupComplete);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        WeaponRegistry.init();
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(WeaponRegistry.PLASMA.get(), EntityPlasmaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(WeaponRegistry.ROCKET.get(), EntityRocketRenderer::new);
    }

    private void setupComplete(final FMLLoadCompleteEvent event) {
        LOGGER.info("Quake Additions is present, have fun!");
    }
}
