package tomaszjh.quakeadditions.weapons.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityRocket extends AbstractFireballEntity {
    public static DamageSource causeRocketDamage(Entity source, Entity indirectEntity) {
        return (new IndirectEntityDamageSource("rocket", source, indirectEntity).setProjectile());
    }

    public EntityRocket(EntityType<? extends AbstractFireballEntity> type, World world) {
        super(type, world);
    }

    public EntityRocket(EntityType type, World world, double posX, double posY, double posZ, double accelX, double accelY, double accelZ) {
        super(type, posX, posY, posZ, accelX, accelY, accelZ, world);
        double d0 = MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
        this.accelerationX = accelX / d0 * 0.07D;
        this.accelerationY = accelY / d0 * 0.07D;
        this.accelerationZ = accelZ / d0 * 0.07D;
    }

    public EntityRocket(EntityType type, World world, PlayerEntity shooter, double accelX, double accelY, double accelZ) {
        super(type, shooter, accelX, accelY, accelZ, world);
        double d0 = MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
        this.accelerationX = accelX / d0 * 0.07D;
        this.accelerationY = accelY / d0 * 0.07D;
        this.accelerationZ = accelZ / d0 * 0.07D;
    }

    //Just to shutup the IDE from giving an error
    public EntityRocket(World world) {
        super(null, world);
    }

    protected boolean isFireballFiery() {
        return false;
    }

    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if(!this.world.isRemote) {
            this.remove();
        }
        this.world.createExplosion((Entity) null, this.getPosX(), this.getPosY(), this.getPosZ(), 5f, false, Explosion.Mode.NONE);

    }

    public void onEntityHit(EntityRayTraceResult result) {
        super.onEntityHit(result);
        Entity targetEntity = result.getEntity();
        Entity sourceEntity = this.getShooter();
            targetEntity.attackEntityFrom(causeRocketDamage(sourceEntity, targetEntity), 18);

    }

    public void tick() {
        super.tick();

        if(this.ticksExisted > 40) {
            this.remove();
        }
        Vector3d vector3d = this.getMotion();
        if(this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f = MathHelper.sqrt(horizontalMag(vector3d));
            this.rotationYaw = (float)(MathHelper.atan2(vector3d.x, vector3d.z) * (double)(180F / (float)Math.PI));
            this.rotationPitch = (float)(MathHelper.atan2(vector3d.y, (double)f) * (double)(180F / (float)Math.PI));
            this.prevRotationYaw = this.rotationYaw;
            this.prevRotationPitch = this.rotationPitch;
        }



    }

    @Override
    protected void registerData() {

    }
}
