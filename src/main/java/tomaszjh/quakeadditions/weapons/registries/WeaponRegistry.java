package tomaszjh.quakeadditions.weapons.registries;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tomaszjh.quakeadditions.QuakeAdditions;
import tomaszjh.quakeadditions.weapons.entity.projectile.EntityPlasma;
import tomaszjh.quakeadditions.weapons.entity.projectile.EntityRocket;
import tomaszjh.quakeadditions.weapons.items.ItemAmmo;
import tomaszjh.quakeadditions.weapons.items.ItemPlasmaGun;
import tomaszjh.quakeadditions.weapons.items.ItemRocketLauncher;

import static tomaszjh.quakeadditions.QuakeAdditions.MOD_ID;

public class WeaponRegistry {

    private static final DeferredRegister<net.minecraft.item.Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);
    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);

    public static final RegistryObject<Item> PLASMA_GUN = ITEMS.register("plasma_gun", ItemPlasmaGun::new);
    public static final RegistryObject<Item> ROCKET_LAUNCHER = ITEMS.register("rocket_launcher", ItemRocketLauncher::new);

    public static final RegistryObject<ItemAmmo> BULLETS = ITEMS.register("bullets", ItemAmmo::new);
    public static final RegistryObject<ItemAmmo> SHELLS = ITEMS.register("shells", ItemAmmo::new);
    public static final RegistryObject<ItemAmmo> GRENADES = ITEMS.register("grenades", ItemAmmo::new);
    public static final RegistryObject<ItemAmmo> ROCKETS = ITEMS.register("rockets", ItemAmmo::new);
    public static final RegistryObject<ItemAmmo> LIGHTNING = ITEMS.register("lightning", ItemAmmo::new);
    public static final RegistryObject<ItemAmmo> CELLS = ITEMS.register("cells", ItemAmmo::new);
    public static final RegistryObject<ItemAmmo> SLUGS = ITEMS.register("slugs", ItemAmmo::new);
    public static final RegistryObject<ItemAmmo> BFG_AMMO = ITEMS.register("bfg_ammo", ItemAmmo::new);

    public static final RegistryObject<EntityType<EntityPlasma>> PLASMA = ENTITIES.register("plasma", () -> EntityType.Builder.<EntityPlasma>create(EntityPlasma::new, EntityClassification.MISC).size(0.5f, 0.5f).build(new ResourceLocation(MOD_ID, "plasma").toString()));
    public static final RegistryObject<EntityType<EntityRocket>> ROCKET = ENTITIES.register("rocket", () -> EntityType.Builder.<EntityRocket>create(EntityRocket::new, EntityClassification.MISC).size(0.5f, 0.5f).build(new ResourceLocation(MOD_ID, "rocket").toString()));


    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
