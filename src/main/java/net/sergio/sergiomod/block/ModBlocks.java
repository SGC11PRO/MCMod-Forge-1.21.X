package net.sergio.sergiomod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
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
    public static final RegistryObject<Block> MINERAL_LITIO = registerBlock("mineral_litio",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(4f) // tiempo para romperse (Ref. Stone = 4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> BLOQUE_LITIO = registerBlock("bloque_litio",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER)));


    // funciones automatizadas
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

