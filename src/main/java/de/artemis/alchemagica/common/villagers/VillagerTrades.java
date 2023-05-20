package de.artemis.alchemagica.common.villagers;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.registration.ModItems;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Alchemagica.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VillagerTrades {

    @SubscribeEvent
    public static void onWanderingTrader(WandererTradesEvent event) {
        event.getGenericTrades().add(new VillagerTrade(VillagerTrade.Type.ITEM_FOR_EMERALD).setItem(ModItems.ARCANE_BLOSSOM_SEED.get()).setEmeraldPrice(8));
    }
}
