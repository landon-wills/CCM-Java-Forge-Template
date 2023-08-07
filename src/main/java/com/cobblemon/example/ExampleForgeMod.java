package com.cobblemon.example;

import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Species;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("cobblemon_forge_mdk")
public final class ExampleForgeMod {

    public ExampleForgeMod() {}

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static final class Registration {

        @SubscribeEvent
        public static void onCommandRegistration(final RegisterCommandsEvent event) {
            event.getDispatcher().register(Commands.literal("test")
                    .executes(context -> {
                        Species species = PokemonSpecies.INSTANCE.getByIdentifier(ResourceLocation.of("cobblemon:bidoof", ':'));
                        context.getSource().sendSystemMessage(
                                Component.literal("Got species: ")
                                        .withStyle(Style.EMPTY.withColor(0x03e3fc))
                                        .append(species.getTranslatedName())
                        );
                        return 0;
                    })
            );
        }

    }

}
