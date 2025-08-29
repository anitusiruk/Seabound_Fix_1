package net.samdwu.seabound.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.samdwu.seabound.entity.projectile.PrismaticArrow;
import net.samdwu.seabound.item.ModItems;

public class PrismaticArrowItem extends ArrowItem {
    public final float damage;
    public PrismaticArrowItem(Properties properties, float damage){
        super(properties);
        this.damage = damage;
    }
    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        PrismaticArrow arrow = new PrismaticArrow(pShooter,pLevel, ModItems.PRISMATIC_ARROW.get());
        arrow.setBaseDamage(this.damage);
        return arrow;
    }
    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == PrismaticArrowItem.class;
    }
}
