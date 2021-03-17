/*
 * Copyright (c) 2017, Alois Stöckl, All Rights Reserved
 */

package at.loiss01;

import net.minecraft.server.v1_8_R3.Item;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class GuiBuilder {

    private Inventory inv;
    private List<GuiItem> items;

    public GuiBuilder(Integer slots, String title) {
        inv = Bukkit.createInventory(null,slots, title);
        items = new ArrayList<GuiItem>();
//        Main.guimmanager.add
    }


    public GuiBuilder withGuiItem(ItemStack itemStack, int slot, BiConsumer<Player, ItemStack> biConsumer){
        inv.setItem(slot, itemStack);
        items.add(new GuiItem(itemStack, biConsumer));
        return this;
    }

    public GuiBuilder withGuiItem(ItemStack itemStack, BiConsumer<Player, ItemStack> biConsumer){
        inv.addItem(itemStack);
        items.add(new GuiItem(itemStack, biConsumer));
        return this;
    }

    public GuiBuilder clear(){
        inv.clear();
        return this;
    }

    public List<GuiItem> getItems() {
        return items;
    }

    public Inventory getInventory() {
        return inv;
    }
}
