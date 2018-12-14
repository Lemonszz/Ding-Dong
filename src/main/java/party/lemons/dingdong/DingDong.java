package party.lemons.dingdong;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BellBlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.HitResult;
import net.minecraft.world.World;

public class DingDong implements ModInitializer
{
	public static void doDing(World world, HitResult hit)
	{
		if(hit.entity == null)
		{
			if(world.getBlockState(hit.getBlockPos()).getBlock() == Blocks.BELL)
			{
				BellBlockEntity bell = (BellBlockEntity) world.getBlockEntity(hit.getBlockPos());
				bell.method_17031(hit.side);

				world.playSound(null, hit.getBlockPos(), SoundEvents.BLOCK_BELL_USE, SoundCategory.BLOCK, 1.0F, 1.0F);

			}
		}
	}

	@Override
	public void onInitialize()
	{

	}
}
