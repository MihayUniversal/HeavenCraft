package mihayuniversal.heavencraft;

import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mihayuniversal.heavencraft.util.Reference;

@Mod(Reference.MODID)
public final class HeavenCraft {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	public HeavenCraft() {
		LOGGER.debug("Hello from HeavenCraft");
	}
	
}
