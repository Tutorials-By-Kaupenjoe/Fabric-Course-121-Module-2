package net.kaupenjoe.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.item.custom.ChainsawItem;
import net.kaupenjoe.mccourse.item.custom.HammerItem;
import net.kaupenjoe.mccourse.item.custom.ModEffectSwordItem;
import net.kaupenjoe.mccourse.item.custom.PaxelItem;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item FLUORITE = registerItem("fluorite", new Item(new Item.Settings()));
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", new Item(new Item.Settings()));

    public static final Item CHAINSAW = registerItem("chainsaw", new ChainsawItem(new Item.Settings().maxDamage(32)));
    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.mccourse.strawberry.tooltip.1"));

            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item FLUORITE_SWORD = registerItem("fluorite_sword",
            new ModEffectSwordItem(ModToolMaterials.FLUORITE, new Item.Settings(), StatusEffects.LEVITATION));
    public static final Item FLUORITE_PICKAXE = registerItem("fluorite_pickaxe",
            new PickaxeItem(ModToolMaterials.FLUORITE, new Item.Settings()));
    public static final Item FLUORITE_SHOVEL = registerItem("fluorite_shovel",
            new ShovelItem(ModToolMaterials.FLUORITE, new Item.Settings()));
    public static final Item FLUORITE_AXE = registerItem("fluorite_axe",
            new AxeItem(ModToolMaterials.FLUORITE, new Item.Settings()));
    public static final Item FLUORITE_HOE = registerItem("fluorite_hoe",
            new HoeItem(ModToolMaterials.FLUORITE, new Item.Settings()));

    public static final Item FLUORITE_PAXEL = registerItem("fluorite_paxel",
            new PaxelItem(ModToolMaterials.FLUORITE, new Item.Settings()));
    public static final Item FLUORITE_HAMMER = registerItem("fluorite_hammer",
            new HammerItem(ModToolMaterials.FLUORITE, new Item.Settings()));

    public static final Item FLUORITE_HELMET = registerItem("fluorite_helmet",
            new ArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(18))));
    public static final Item FLUORITE_CHESTPLATE = registerItem("fluorite_chestplate",
            new ArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(18))));
    public static final Item FLUORITE_LEGGINGS = registerItem("fluorite_leggings",
            new ArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(18))));
    public static final Item FLUORITE_BOOTS = registerItem("fluorite_boots",
            new ArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(18))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID, name), item);
    }

    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(FLUORITE);
        entries.add(RAW_FLUORITE);
    }

    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    }
}
