package net.samdwu.seabound.entity;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.samdwu.seabound.SeaboundMod;
import net.samdwu.seabound.client.renderer.entity.PrismaticArrowRenderer;

@Mod.EventBusSubscriber(modid = SeaboundMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntityType.PRISMATIC_ARROW.get(), PrismaticArrowRenderer::new);
    }
}
