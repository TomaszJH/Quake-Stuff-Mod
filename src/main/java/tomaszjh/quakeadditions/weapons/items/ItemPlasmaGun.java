package tomaszjh.quakeadditions.weapons.items;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import tomaszjh.quakeadditions.QuakeAdditions;
import tomaszjh.quakeadditions.weapons.entity.projectile.EntityPlasma;
import tomaszjh.quakeadditions.weapons.registries.SoundRegistry;
import tomaszjh.quakeadditions.weapons.registries.WeaponRegistry;

public class ItemPlasmaGun extends Item {


    public ItemPlasmaGun() {
        super(new Properties().maxStackSize(1).group(QuakeAdditions.TAB));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        EntityPlasma plasma = new EntityPlasma(WeaponRegistry.PLASMA.get(), world, player, player.getLookVec().x, player.getLookVec().y, player.getLookVec().z);
        world.playSound(null, player.getPosition(), SoundRegistry.PLASMA_GUN_FIRE, SoundCategory.PLAYERS, 1f, 1f);
        if(!world.isRemote) {
            plasma.setPosition(player.getPosX(), player.getPosY()+1, player.getPosZ());
            plasma.setDirectionAndMovement(player, player.rotationPitch, player.rotationYaw, 0.0f, 2.0f, 1.0f);
            world.addEntity(plasma);

        }


        return new ActionResult<>(ActionResultType.SUCCESS, itemStack);
    }

}
