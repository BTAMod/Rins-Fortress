package mizurin.shieldmod.item;

import mizurin.shieldmod.IColorable;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.world.World;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;

public class ShieldColored extends ShieldItem implements IColorable {
	public ShieldColored(String name, int id, ToolMaterial toolMaterial) {
		super(name, id, toolMaterial);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		if(itemstack.getData().getBoolean("active")){
			entity.xd *= 0.65D;
			entity.zd *= 0.65D;
			int ticks = itemstack.getData().getInteger("ticks");

			if (ticks > 0){
				itemstack.getData().putInt("ticks", ticks - 1);
			} else {
				itemstack.getData().putBoolean("active", false);
			}
		}
	}

}
