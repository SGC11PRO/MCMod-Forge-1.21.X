package net.sergio.sergiomod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sergio.sergiomod.SergioMod;

public class ModItems {

    // crear una nueva lista de ITEMS en SergioMod
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SergioMod.MOD_ID);

    // Registrar un nuevo item LITIO en la lista ITEMS, con el nombre "litio" y las propiedades por defecto Item.Properties()
    public static final RegistryObject<Item> LITIO = ITEMS.register("litio", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> BATERIA = ITEMS.register("bateria", () ->
            new Item(new Item.Properties()));


    // Registrar esta lista en Forge
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
