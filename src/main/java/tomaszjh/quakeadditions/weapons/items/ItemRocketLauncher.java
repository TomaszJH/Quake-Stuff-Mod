package tomaszjh.quakeadditions.weapons.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import tomaszjh.quakeadditions.QuakeAdditions;
import tomaszjh.quakeadditions.weapons.entity.projectile.EntityPlasma;
import tomaszjh.quakeadditions.weapons.entity.projectile.EntityRocket;
import tomaszjh.quakeadditions.weapons.registries.SoundRegistry;
import tomaszjh.quakeadditions.weapons.registries.WeaponRegistry;

public class ItemRocketLauncher extends Item {

    public ItemRocketLauncher() {
        super(new Item.Properties().maxStackSize(1).group(QuakeAdditions.TAB));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        EntityRocket rocket = new EntityRocket(WeaponRegistry.ROCKET.get(), world, player, player.getLookVec().x, player.getLookVec().y, player.getLookVec().z);
        world.playSound(null, player.getPosition(), SoundRegistry.PLASMA_GUN_FIRE, SoundCategory.PLAYERS, 1f, 1f);
        player.getCooldownTracker().setCooldown(this, 20);
        if(!world.isRemote) {
            world.playSound(null, player.getPosition(), SoundRegistry.PLASMA_GUN_FIRE, SoundCategory.PLAYERS, 1f, 1f);
            rocket.setPosition(player.getPosX(), player.getPosY()+1, player.getPosZ());
            rocket.setDirectionAndMovement(player, player.rotationPitch, player.rotationYaw, 0.0f, 1.5f, 0.5f);
            world.addEntity(rocket);

        }


        return new ActionResult<>(ActionResultType.SUCCESS, itemStack);
    }

}
