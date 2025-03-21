package net.sergio.sergiomod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sergio.sergiomod.SergioMod;
import net.sergio.sergiomod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    // Registrar los bloques en una nueva lista
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SergioMod.MOD_ID);

    //Registrar un bloque
    public static final RegistryObject<Block> BLOQUE_LITIO = registerBlock("bloque_litio",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(6f) // tiempo para romperse (Ref. Stone = 6f) (see https://mcreator.net/wiki/list-block-resistance-levels)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // crea una funcion para registrar nuevos blockes, con "name" y propiedades por defecto
    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    // registrar la lista en minecraft
    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}

