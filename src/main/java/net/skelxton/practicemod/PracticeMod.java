package net.skelxton.practicemod;

import net.fabricmc.api.ModInitializer;
import net.skelxton.practicemod.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.skelxton.practicemod.item.ModItems;

public class PracticeMod implements ModInitializer {

	public static final String MOD_ID = "practicemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello Fabric world!");
	}
}
