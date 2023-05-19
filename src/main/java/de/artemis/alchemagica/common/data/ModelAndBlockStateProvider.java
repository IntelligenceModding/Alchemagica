package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.Alchemagica;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModelAndBlockStateProvider extends BlockStateProvider {

    public ModelAndBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Alchemagica.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
