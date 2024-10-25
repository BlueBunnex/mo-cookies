package com.redderblanket.lbk;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BURGER = register(
            new Item(
                new Item.Settings()
                    .maxCount(64)
                    .food(
                        new FoodComponent.Builder()
                            .nutrition(8)
                            .saturationModifier(8)
                            .alwaysEdible()
                            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 6 * 20, 1), 1.0f)
                            .build()
                    )
            ),
            "burger"
    );

    public static void init() {

        // Add food items to food group (in creative menu).
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> {

            itemGroup.add(BURGER);
        });
    }

    public static Item register(Item item, String stringID) {

        // Create the identifier for the item.
        Identifier itemID = Identifier.of(EntrypointMain.MOD_ID, stringID);

        // Register and return newly registered item.
        return Registry.register(Registries.ITEM, itemID, item);
    }

}