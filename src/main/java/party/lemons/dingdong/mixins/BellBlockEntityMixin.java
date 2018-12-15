package party.lemons.dingdong.mixins;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BellBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BellBlockEntity.class)
public abstract class BellBlockEntityMixin extends BlockEntity implements Tickable
{
	@Shadow
	public int field_17095;
	@Shadow
	public boolean field_17096;
	@Shadow
	public Direction field_17097;


	@Inject(at = @At(value = "HEAD"), method = "tick")
	public void onTick(CallbackInfo info)
	{
		if(field_17096)
		{
			if(field_17095 == 0 || field_17095 == 49)
			{
				world.updateHorizontalAdjacent(pos, Blocks.BELL);
			}
		}
	}

	public BellBlockEntityMixin(BlockEntityType<?> var1)
	{
		super(null);
	}
}
