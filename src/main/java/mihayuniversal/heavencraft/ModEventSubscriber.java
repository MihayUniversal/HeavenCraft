package mihayuniversal.heavencraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;
import mihayuniversal.heavencraft.init.ModItemGroups;
import mihayuniversal.heavencraft.util.Reference;


@EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {
	
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				// Add Items
				setup(new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "angel_ingot")
		);
	}
	
	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				// Add Blocks
				setup(new Block(Block.Properties.create(Material.STONE).hardnessAndResistance(3.0F, 3.0F)), "angel_ore")
		);
	}
	
	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(Reference.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}
	
}

