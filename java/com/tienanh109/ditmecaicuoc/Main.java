// Made by tienanh109 with MIT LICENSE
// https://github.com/tienanh109

package com.tienanh109.ditmecaicuoc;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "tienanh109";
    public static final String VERSION = "1.0";
    public static Item magicAxe;

    @SidedProxy(clientSide = "com.tienanh109.ditmecaicuoc.ClientProxy",
            serverSide = "com.tienanh109.ditmecaicuoc.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        magicAxe = new ItemMagicAxe();


        GameRegistry.register(magicAxe);

        proxy.registerItemModels();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("tienanh109's mod is loaded to your minecraft 1.9.4 forge!");

        // Công thức chế tạo ditmecaicuoc axe: 1 cục đất = 1 ditmecaicuoc axe
        GameRegistry.addShapelessRecipe(
                new ItemStack(magicAxe, 1),
                new ItemStack(Blocks.DIRT, 1)
        );
    }
}
