package net.skelxton.practicemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.skelxton.practicemod.PracticeMod;


public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroup.builder(new Identifier(PracticeMod.MOD_ID,
            "tanzanite")).icon(() -> new ItemStack(ModItems.TANZANITE)).build();

}
