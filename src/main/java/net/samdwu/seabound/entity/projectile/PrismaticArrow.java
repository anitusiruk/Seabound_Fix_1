package net.samdwu.seabound.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.samdwu.seabound.entity.ModEntityType;
import net.samdwu.seabound.item.ModItems;

public class PrismaticArrow extends AbstractArrow {
    private final Item referenceItem;

    public PrismaticArrow(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.referenceItem = ModItems.PRISMATIC_ARROW.get();
    }
    public PrismaticArrow( LivingEntity pShooter, Level pLevel, Item referenceItem) {
        super(ModEntityType.PRISMATIC_ARROW.get(), pShooter, pLevel);
        this.referenceItem = referenceItem;
    }
    @Override
    public ItemStack getPickupItem(){
        return new ItemStack(this.referenceItem);
    }

}
