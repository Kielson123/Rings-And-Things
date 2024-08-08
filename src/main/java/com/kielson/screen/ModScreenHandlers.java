package com.kielson.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static com.kielson.KielsonsJewelry.MOD_ID;

public class ModScreenHandlers {
    public static final ScreenHandlerType<JewelryScreenHandler> JEWELRY_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MOD_ID, "jewelry"), new ExtendedScreenHandlerType<>(JewelryScreenHandler::new));
}
