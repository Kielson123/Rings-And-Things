package com.kielson;

import com.kielson.block.ModBlocks;
import com.kielson.item.ModItemGroups;
import com.kielson.item.ModItems;
import com.kielson.util.ModStats;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KielsonsJewelry implements ModInitializer {
	public static final String MOD_ID = "kielsons_jewelry";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModItemGroups.initialize();
		ModStats.initialize();
		ModBlocks.initialize();
	}
}