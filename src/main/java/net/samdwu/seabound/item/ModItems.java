package net.samdwu.seabound.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.samdwu.seabound.SeaboundMod;
import net.samdwu.seabound.item.custom.PrismaticArrowItem;
import net.samdwu.seabound.item.custom.RadiantScepterItem;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SeaboundMod.MODID);

    public static final RegistryObject<Item> PRISMATIC_SHARD = ITEMS.register("prismatic_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PRISMATIC_SHARD_RED = ITEMS.register("prismatic_shard_red",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PRISMATIC_SHARD_YELLOW = ITEMS.register("prismatic_shard_yellow",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PRISMATIC_SHARD_BLUE = ITEMS.register("prismatic_shard_blue",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PRISMATIC_SHARD_PURPLE = ITEMS.register("prismatic_shard_purple",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RADIANT_SCEPTER = ITEMS.register("radiant_scepter",
            () -> new RadiantScepterItem(new Item.Properties()));
    public static final RegistryObject<Item> PRISMATIC_ARROW = ITEMS.register("prismatic_arrow",
            () -> new PrismaticArrowItem(new Item.Properties(),4.5f));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
