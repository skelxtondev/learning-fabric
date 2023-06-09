package net.skelxton.practicemod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import net.skelxton.practicemod.PracticeMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.skelxton.practicemod.item.custom.EightBallItem;
import net.skelxton.practicemod.item.custom.TntWandItem;


public class ModItems {

    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite", new Item(new FabricItemSettings()));
    public static final Item TANZANITE = registerItem("tanzanite", new Item(new FabricItemSettings()));

    public static final Item EIGHT_BALL = registerItem("eight_ball", new EightBallItem(new FabricItemSettings()));
    public static final Item TNT_WAND = registerItem("tnt_wand", new TntWandItem(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PracticeMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        addtoItemGroup(ModItemGroup.TANZANITE,RAW_TANZANITE);
        addtoItemGroup(ModItemGroup.TANZANITE,TANZANITE);
        addtoItemGroup(ItemGroups.TOOLS,EIGHT_BALL);
        addtoItemGroup(ItemGroups.TOOLS, TNT_WAND);
    }

    public static void addtoItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        PracticeMod.LOGGER.debug("Registering Mod Items for " + PracticeMod.MOD_ID);

        addItemsToItemGroup();

    }
}