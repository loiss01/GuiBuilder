/*
 * Copyright (c) 2017, Alois Stöckl, All Rights Reserved
 */

package at.loiss01;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;

public class GuiManager implements Listener {

    public static ArrayList<GuiBuilder> builders;

    public GuiManager() {
        builders = new ArrayList<>();
    }

    @EventHandler
    public void onclick(InventoryClickEvent e){


        for (GuiBuilder builders: builders) {
            if(builders.getInventory().getTitle().equalsIgnoreCase(e.getInventory().getTitle())){
                for (GuiItem guiItem : builders.getItems()){
                    if(guiItem.equals(e.getCurrentItem())){
                        e.setCancelled(true);
                        if(guiItem.getBiConsumer() == null){
                            guiItem.getBiConsumer().accept((Player) e.getWhoClicked(), e.getCurrentItem());
                        }
                        break;
                    }
                }
                break;
            }
        }

    }

}
