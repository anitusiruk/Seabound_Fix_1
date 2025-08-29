package net.samdwu.seabound.common.helper;


import net.minecraft.world.item.ItemStack;


public final class ItemNBTHelper {
    public static void setBoolean(ItemStack stack, String tag, boolean b) {
        stack.getOrCreateTag().putBoolean(tag, b);
    }
    public static boolean verifyExistance(ItemStack stack, String tag) {
        return !stack.isEmpty() && stack.hasTag() && stack.getOrCreateTag().contains(tag);
    }
    public static boolean getBoolean(ItemStack stack, String tag, boolean defaultExpected) {
        return verifyExistance(stack, tag) ? stack.getOrCreateTag().getBoolean(tag) : defaultExpected;
    }


}