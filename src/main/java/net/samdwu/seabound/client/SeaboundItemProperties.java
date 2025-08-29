package net.samdwu.seabound.client;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.samdwu.seabound.SeaboundMod;
import net.samdwu.seabound.item.ModItems;
import net.samdwu.seabound.item.custom.RadiantScepterItem;


public class SeaboundItemProperties {
    public static void clientInit(){
        ItemProperties.register(
                ModItems.RADIANT_SCEPTER.get(), // Your item
                new ResourceLocation(SeaboundMod.MODID, "light"), // Predicate name used in model override JSON
                (ItemStack stack, ClientLevel level, LivingEntity entity, int seed) -> {
                    if (RadiantScepterItem.getIlluminationMode(stack)) {
                        return 0.0F;
                    }
                    else {
                        return 1.0F;
                    }
                }
        );
        ItemProperties.register(
                Items.BOW,
                new ResourceLocation(SeaboundMod.MODID,"prismaticarrow"), ((pStack, pLevel, pEntity, pSeed) -> {
                    if (pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem()==pStack){
                        boolean hasPrismatic = pEntity.getProjectile(pStack).getItem() == ModItems.PRISMATIC_ARROW.get();
                        if(hasPrismatic){
                            return 1.0F;
                        }
                        else return 0.0F;

                    }
                    return 0.0F;
                }
                )



        );
    }
}
