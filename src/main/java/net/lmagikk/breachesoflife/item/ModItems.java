package net.lmagikk.breachesoflife.item;

import net.lmagikk.breachesoflife.BreachesOfLife;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BreachesOfLife.MOD_ID);


    public static final DeferredItem<Item> ODD_SCRAPS = ITEMS.registerSimpleItem("odd_scraps");
    public static final DeferredItem<Item> ODD_BAR = ITEMS.registerItem("odd_bar", Item::new, new Item.Properties());


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
