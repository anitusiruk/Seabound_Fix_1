package net.samdwu.seabound;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.samdwu.seabound.block.ModBlocks;
import net.samdwu.seabound.client.SeaboundItemProperties;
import net.samdwu.seabound.entity.ModEntityType;
import net.samdwu.seabound.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SeaboundMod.MODID)
public class SeaboundMod
    //test
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "seabound";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);


    public SeaboundMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntityType.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.PRISMATIC_SHARD);
            event.accept(ModItems.PRISMATIC_SHARD_RED);
            event.accept(ModItems.PRISMATIC_SHARD_BLUE);
            event.accept(ModItems.PRISMATIC_SHARD_YELLOW);
            event.accept(ModItems.PRISMATIC_SHARD_PURPLE);
            event.accept(ModBlocks.ARCHAIC_SHELL);
            event.accept(ModBlocks.ARCHAIC_SHELL_SMOOTH);
            event.accept(ModBlocks.ARCHAIC_SHELL_BRICKS);
            event.accept(ModBlocks.ARCHAIC_SHELL_BRICKS_MOSS);
            event.accept(ModBlocks.PRISMATIC_GEM);
            event.accept(ModBlocks.ANCIENT_PEARL);
            event.accept(ModBlocks.PRISMATIC_GEM_BLUE);
            event.accept(ModBlocks.PRISMATIC_GEM_RED);
            event.accept(ModBlocks.PRISMATIC_GEM_YELLOW);
            event.accept(ModBlocks.PRISMATIC_GEM_PURPLE);
            event.accept(ModItems.RADIANT_SCEPTER);
            event.accept(ModItems.PRISMATIC_ARROW);


        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            event.enqueueWork(SeaboundItemProperties::clientInit);


        }
    }
}
