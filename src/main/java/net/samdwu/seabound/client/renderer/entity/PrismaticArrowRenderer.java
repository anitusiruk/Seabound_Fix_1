package net.samdwu.seabound.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.samdwu.seabound.SeaboundMod;
import net.samdwu.seabound.entity.projectile.PrismaticArrow;


@OnlyIn(Dist.CLIENT)
public class PrismaticArrowRenderer extends ArrowRenderer<PrismaticArrow> {
    public PrismaticArrowRenderer(EntityRendererProvider.Context context){
        super(context);

    }

    @Override
    public ResourceLocation getTextureLocation(PrismaticArrow pEntity) {
        Item referenceItem = pEntity.getPickupItem().getItem();
        return new ResourceLocation(SeaboundMod.MODID, "textures/entity/projectiles/prismatic_arrow.png");
    }

}
