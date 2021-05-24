package mihayuniversal.heavencraft.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import mihayuniversal.heavencraft.util.Reference;
import java.util.function.Supplier;

import javax.annotation.Nonnull;

public final class ModItemGroups {

	public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(Reference.MODID, () -> new ItemStack(ModItems.ANGEL_INGOT));

	public static final class ModItemGroup extends ItemGroup {

		@Nonnull
		private final Supplier<ItemStack> iconSupplier;

		public ModItemGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) {
			super(name);
			this.iconSupplier = iconSupplier;
		}

		@Override
		@Nonnull
		public ItemStack makeIcon() {
			return iconSupplier.get();
		}

	}

}
