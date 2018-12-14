package party.lemons.dingdong.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import party.lemons.dingdong.DingDong;

@Mixin(ProjectileEntity.class)
public abstract class ProjectileMixin extends Entity
{
	public ProjectileMixin()
	{
		super(null, null);
	}

	@Inject(at = @At(value = "RETURN"), method = "method_7457")
	public void onProjectileHit(HitResult hit, CallbackInfo info)
	{
		DingDong.doDing(world, hit);
	}
}
