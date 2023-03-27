package net.skelxton.practicemod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class TntWandItem extends Item {
    public TntWandItem(Settings settings) {
        super(settings);
    }

//    @Override
//    public ActionResult useOnBlock(ItemUsageContext context) {
//        World world = context.getWorld();
//        Block block = world.getBlockState(context.getBlockPos()).getBlock();
//        PlayerEntity player = context.getPlayer();
//
//        if (block == Blocks.GRASS_BLOCK) {
//            if (!world.isClient) {
//                world.setBlockState(context.getBlockPos(), Blocks.TNT.getDefaultState());
//
//                player.getStackInHand(context.getHand()).decrement(1);
//            } else {
//                player.playSound(SoundEvents.BLOCK_GRASS_BREAK, 1.0f, 1.0f);
//            }
//        }
//
//        return super.useOnBlock(context);
//
//    }

//    @Override
//    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
//
//        World world = user.getWorld();
//
//        if (entity.getType() == EntityType.CREEPER) {
//            if(!world.isClient()){
//                CreeperEntity creeperEntity = (CreeperEntity) entity;
//                creeperEntity.clearGoalsAndTasks();
//                creeperEntity.setFuseSpeed(-1);
//                creeperEntity.ignite();
//            }
//        }
//
//        return super.useOnEntity(stack, user, entity, hand);
//    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            double velocityMultiplier =  1f;
            if (user.getOffHandStack().getItem() == Items.GUNPOWDER) {
                user.getOffHandStack().decrement(1);
                velocityMultiplier = 3f;
            }


            Vec3d lookVec = user.getRotationVec(1.0F).multiply(velocityMultiplier);
            TntEntity tntEntity = new TntEntity(
                    world,
                    user.getX(),
                    user.getY() + user.getStandingEyeHeight(),
                    user.getZ(),
                    user);
            tntEntity.setVelocity(lookVec);
            world.spawnEntity(tntEntity);
        }

        return super.use(world, user, hand);
    }
}
