package net.samdwu.seabound.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.samdwu.seabound.SeaboundMod;
import net.samdwu.seabound.entity.projectile.PrismaticArrow;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SeaboundMod.MODID);

    public static final RegistryObject<EntityType<PrismaticArrow>> PRISMATIC_ARROW = ENTITIES.register("prismatic_arrow",
            () -> EntityType.Builder.<PrismaticArrow>of(PrismaticArrow::new, MobCategory.MISC).sized(0.5F, 0.5f).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(SeaboundMod.MODID, "prismatic_arrow").toString()));

    public static void register(IEventBus eventBus){
        ENTITIES.register(eventBus);
    }
}
