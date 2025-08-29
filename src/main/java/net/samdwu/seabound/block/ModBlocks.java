package net.samdwu.seabound.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.samdwu.seabound.SeaboundMod;
import net.samdwu.seabound.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SeaboundMod.MODID);

    public static final RegistryObject<Block> ARCHAIC_SHELL = registerBlock("archaic_shell",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ARCHAIC_SHELL_SMOOTH = registerBlock("archaic_shell_smooth",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ARCHAIC_SHELL_BRICKS = registerBlock("archaic_shell_bricks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ARCHAIC_SHELL_BRICKS_MOSS = registerBlock("archaic_shell_bricks_moss",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> PRISMATIC_GEM = registerBlock("prismatic_gem",
            ()-> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> PRISMATIC_GEM_RED = registerBlock("prismatic_gem_red",
            ()-> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.AMETHYST).strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PRISMATIC_GEM_BLUE = registerBlock("prismatic_gem_blue",
            ()-> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.AMETHYST).strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PRISMATIC_GEM_YELLOW = registerBlock("prismatic_gem_yellow",
            ()-> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.AMETHYST).strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PRISMATIC_GEM_PURPLE = registerBlock("prismatic_gem_purple",
            ()-> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.AMETHYST).strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANCIENT_PEARL = registerBlock("ancient_pearl",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OCHRE_FROGLIGHT).lightLevel(state -> 15).strength(2f).requiresCorrectToolForDrops()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
