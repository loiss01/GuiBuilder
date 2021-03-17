/*
 * Copyright (c) 2017, Alois Stöckl, All Rights Reserved
 */

package at.loiss01;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;

public class GuiItem {

    private ItemStack itemStack;
    private BiConsumer<Player, ItemStack> biConsumer;

    public GuiItem(ItemStack itemStack, BiConsumer<Player, ItemStack> biConsumer) {
        this.itemStack = itemStack;
        this.biConsumer = biConsumer;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public BiConsumer<Player, ItemStack> getBiConsumer() {
        return biConsumer;
    }
}
