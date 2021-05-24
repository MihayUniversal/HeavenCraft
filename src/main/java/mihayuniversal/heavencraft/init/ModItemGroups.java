package mihayuniversal.heavencraft.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import mihayuniversal.heavencraft.util.Reference;
import java.util.function.Supplier;

public class ModItemGroups {
	
	public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(Reference.MODID, () -> new ItemStack(ModItems.ANGEL_INGOT));
	
	public static class ModItemGroup extends ItemGroup {
		
		private final Supplier<ItemStack> iconSupplier;
		
		public ModItemGroup (String name, Supplier<ItemStack> iconSupplier) {
			super(name);
			this.iconSupplier = iconSupplier;
		}
		
		@Override
		public ItemStack makeIcon() {
			return iconSupplier.get();
		}

		
	}
	
}
