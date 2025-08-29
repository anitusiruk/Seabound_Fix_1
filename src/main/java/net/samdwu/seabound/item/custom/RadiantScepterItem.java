package net.samdwu.seabound.item.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.samdwu.seabound.common.helper.ItemNBTHelper;
import org.jetbrains.annotations.NotNull;

public class RadiantScepterItem extends Item {

    private static final String LIGHT_MODE = "light";

    public RadiantScepterItem(Properties pProperties){
        super(pProperties);
    }
    public static boolean getIlluminationMode(ItemStack stack) {
        return ItemNBTHelper.getBoolean(stack, LIGHT_MODE, true);
    }

    public static void setIlluminationMode(ItemStack stack, boolean mode) {
        ItemNBTHelper.setBoolean(stack, LIGHT_MODE, mode);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.isSecondaryUseActive()) {
            if (!world.isClientSide) {
                setIlluminationMode(stack, !getIlluminationMode(stack));
            }
        }

        if (!world.isClientSide) {
            player.setItemInHand(hand, stack);
        }

        return InteractionResultHolder.success(stack);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            BlockPos posClicked = pContext.getClickedPos();
            Level level = pContext.getLevel();
            Direction clickedFace = pContext.getClickedFace();
            Player player = pContext.getPlayer();
            ItemStack stack = pContext.getItemInHand();

            BlockPos placeLoc = null;

            if(getIlluminationMode(stack)==true){
                if (clickedFace == Direction.DOWN){
                    placeLoc = posClicked.below();
                    if(level.isEmptyBlock(placeLoc)) level.setBlock(placeLoc, Blocks.LIGHT.defaultBlockState(), 1);
                }
                if (clickedFace == Direction.UP){
                    placeLoc = posClicked.above();
                    if(level.isEmptyBlock(placeLoc)) level.setBlock(placeLoc, Blocks.LIGHT.defaultBlockState(), 1);
                }
                if (clickedFace == Direction.EAST){
                    placeLoc = posClicked.east();
                    if(level.isEmptyBlock(placeLoc)) level.setBlock(placeLoc, Blocks.LIGHT.defaultBlockState(), 1);
                }
                if (clickedFace == Direction.WEST){
                    placeLoc = posClicked.west();
                    if(level.isEmptyBlock(placeLoc)) level.setBlock(placeLoc, Blocks.LIGHT.defaultBlockState(), 1);
                }
                if (clickedFace == Direction.NORTH){
                    placeLoc = posClicked.north();
                    if(level.isEmptyBlock(placeLoc)) level.setBlock(placeLoc, Blocks.LIGHT.defaultBlockState(), 1);
                }
                if (clickedFace == Direction.SOUTH){
                    placeLoc = posClicked.south();
                    if(level.isEmptyBlock(placeLoc)) level.setBlock(placeLoc, Blocks.LIGHT.defaultBlockState(), 1);
                }
            }
            else{
                if (clickedFace == Direction.DOWN){
                    placeLoc = posClicked.below();
                    BlockState blockState = level.getBlockState(placeLoc);
                    if(blockState.is(Blocks.LIGHT)) level.setBlock(placeLoc, Blocks.AIR.defaultBlockState(), 1);
                }
                if (clickedFace == Direction.UP){
                    placeLoc = posClicked.above();
                    BlockState blockState = level.getBlockState(placeLoc);
                    if(blockState.is(Blocks.LIGHT)) level.setBlock(placeLoc, Blocks.AIR.defaultBlockState(), 1);
                }
                if (clickedFace == Direction.EAST){
                    placeLoc = posClicked.east();
                    BlockState blockState = level.getBlockState(placeLoc);
                    if(blockState.is(Blocks.LIGHT)) level.setBlock(placeLoc, Blocks.AIR.defaultBlockState(), 1);
                }
                if (clickedFace == Direction.WEST){
                    placeLoc = posClicked.west();
                    BlockState blockState = level.getBlockState(placeLoc);
                    if(blockState.is(Blocks.LIGHT)) level.setBlock(placeLoc, Blocks.AIR.defaultBlockState(), 1);
                }
                if (clickedFace == Direction.NORTH){
                    placeLoc = posClicked.north();
                    BlockState blockState = level.getBlockState(placeLoc);
                    if(blockState.is(Blocks.LIGHT)) level.setBlock(placeLoc, Blocks.AIR.defaultBlockState(), 1);
                }
                if (clickedFace == Direction.SOUTH){
                    placeLoc = posClicked.south();
                    BlockState blockState = level.getBlockState(placeLoc);
                    if(blockState.is(Blocks.LIGHT)) level.setBlock(placeLoc, Blocks.AIR.defaultBlockState(), 1);
                }

            }
        }
        return InteractionResult.SUCCESS;
    }
}
