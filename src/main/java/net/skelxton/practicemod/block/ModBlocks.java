package net.skelxton.practicemod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.skelxton.practicemod.PracticeMod;
import net.skelxton.practicemod.item.ModItemGroup;
import net.skelxton.practicemod.item.ModItems;
import net.minecraft.block.ExperienceDroppingBlock;



public class ModBlocks {
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block", new Block(FabricBlockSettings.of(Material.METAL)
            .strength(4f).requiresTool()), ModItemGroup.TANZANITE);

    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
            .strength(4f).requiresTool(), UniformIntProvider.create(3,7)), ModItemGroup.TANZANITE);

    public static final Block ENDSTONE_TANZANITE_ORE = registerBlock("endstone_tanzanite_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
            .strength(4f).requiresTool().luminance(5), UniformIntProvider.create(3,7)), ModItemGroup.TANZANITE);

    public static final Block NETHERRACK_TANZANITE_ORE = registerBlock("netherrack_tanzanite_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
            .strength(4f).requiresTool(), UniformIntProvider.create(3,7)), ModItemGroup.TANZANITE);

    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
            .strength(4f).requiresTool(), UniformIntProvider.create(3,7)), ModItemGroup.TANZANITE);
    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(PracticeMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        Item item = Registry.register(Registries.ITEM, new Identifier(PracticeMod.MOD_ID, name), new BlockItem(block
                , new FabricItemSettings()));
        blockItemToGroup(item, tab);
        return item;


    }

    private static void blockItemToGroup(Item item, ItemGroup tab){
        ModItems.addtoItemGroup(tab, item);
    }





    public static void registerModBlocks() {
        PracticeMod.LOGGER.debug("Registering ModBlocks for " + PracticeMod.MOD_ID);

    }

}
