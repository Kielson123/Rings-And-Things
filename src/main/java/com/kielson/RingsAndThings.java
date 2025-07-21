package com.kielson;

import com.kielson.block.RingsAndThingsBlocks;
import com.kielson.item.RingsAndThingsItemGroups;
import com.kielson.item.RingsAndThingsItems;
import com.kielson.util.RingsAndThingsStats;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RingsAndThings implements ModInitializer {
	public static final String MOD_ID = "rings_and_things";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		RingsAndThingsItems.initialize();
		RingsAndThingsItemGroups.initialize();
		RingsAndThingsStats.initialize();
		RingsAndThingsBlocks.initialize();
	}
}