package net.sergio.sergiomod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sergio.sergiomod.SergioMod;
import net.sergio.sergiomod.block.ModBlocks;

public class ModCreativeModeTabs {

    // Registrar una nueva lista de CreativeModeTabs
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SergioMod.MOD_ID);

    // Duplicar esta funcion para crear nuevas pestañas
    public static final RegistryObject<CreativeModeTab> MINING_EXPANSION_TAB = CREATIVE_MODE_TABS.register("mining_expansion_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BATERIA.get())) // usa el icono de BATERIA
                    .title(Component.translatable("creativetab.sergiomod.mining_expansion")) // nombre de la pestaña (El nombre que se muestra se cambia en /lang

                    .displayItems((pParameters, pOutput) -> { // items a incluir
                        pOutput.accept(ModItems.LITIO.get());
                        pOutput.accept(ModItems.BATERIA.get());
                        pOutput.accept(ModBlocks.BLOQUE_LITIO.get());
                        pOutput.accept(ModBlocks.MINERAL_LITIO.get());
                    })
                    .build());


    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
