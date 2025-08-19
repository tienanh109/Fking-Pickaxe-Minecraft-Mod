package com.tienanh109.ditmecaicuoc;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import java.util.Set;
import com.google.common.collect.Sets;

public class ItemMagicAxe extends ItemTool {

    // Định nghĩa những block có thể đào hiệu quả
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {
            // Đá và các loại đá
            Blocks.STONE, Blocks.COBBLESTONE, Blocks.STONE_STAIRS, Blocks.COBBLESTONE_WALL,
            Blocks.SANDSTONE, Blocks.SANDSTONE_STAIRS, Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE_STAIRS,
            Blocks.MOSSY_COBBLESTONE, Blocks.STONE_SLAB, Blocks.STONE_SLAB2,
            // Ores - quặng
            Blocks.COAL_ORE, Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.DIAMOND_ORE,
            Blocks.EMERALD_ORE, Blocks.LAPIS_ORE, Blocks.REDSTONE_ORE, Blocks.LIT_REDSTONE_ORE,
            // Nether
            Blocks.NETHERRACK, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK_STAIRS,
            // End
            Blocks.END_STONE,
            // Obsidian
            Blocks.OBSIDIAN
    });
    private final double efficiency;

    public ItemMagicAxe() {
        super(Item.ToolMaterial.DIAMOND, EFFECTIVE_ON); // Sử dụng diamond tool material
        setUnlocalizedName("magic_axe");
        setRegistryName("magic_axe");
        setCreativeTab(CreativeTabs.COMBAT);
        setMaxStackSize(1);
        // Tăng tốc độ đào
        this.efficiency = 20.0F; // Nhanh hơn diamond pickaxe (8.0F)
        // Có thể thêm durability tùy chỉnh
        setMaxDamage(5000); // Bền hơn diamond tools (1561)
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        Block block = blockIn.getBlock();

        // Có thể đào tất cả các loại đá
        if (block == Blocks.OBSIDIAN) {
            return true;
        }

        Material material = blockIn.getMaterial();
        return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
    }

    @Override
    public float getStrVsBlock(net.minecraft.item.ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();

        // Siêu nhanh với đá và quặng
        if (material == Material.ROCK) {
            return (float) this.efficiency;
        }

        // Nhanh với các block khác trong danh sách
        if (EFFECTIVE_ON.contains(state.getBlock())) {
            return (float) this.efficiency;
        }

        return super.getStrVsBlock(stack, state);
    }
}