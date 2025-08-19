package com.tienanh109.ditmecaicuoc;

import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerItemModels() {
        ModelLoader.setCustomModelResourceLocation(
                Main.magicAxe, 0,
                new ModelResourceLocation("tienanh109:magic_axe", "inventory")
        );
    }
}