package party.lemons.dingdong.mixins;

import net.minecraft.block.BellBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BellBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BellBlock.class)
public abstract class BellMixin extends Block
{
	public BellMixin()
	{
		super(null);
	}

	@Override
	public boolean hasComparatorOutput(BlockState var1) {
		return true;
	}

	@Override
	public int getComparatorOutput(BlockState state, World world, BlockPos pos)
	{
		BellBlockEntity bell = (BellBlockEntity) world.getBlockEntity(pos);

		if(bell.field_17096 && bell.field_17095 < 49)
			return 1;

		return 0;
	}
}
