package com.drmangotea.tfmg.datagen.recipes.values.tfmg;

import com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider;
import com.drmangotea.tfmg.datagen.recipes.builder.VatMachineRecipeBuilder;
import com.drmangotea.tfmg.registry.TFMGFluids;
import com.drmangotea.tfmg.registry.TFMGItems;
import com.drmangotea.tfmg.registry.TFMGTags;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;

import java.util.ArrayList;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.*;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.I.*;
import static com.drmangotea.tfmg.datagen.recipes.builder.VatMachineRecipeBuilder.VatRecipeParams;

public class VatRecipeGen extends TFMGRecipeProvider {
    public VatRecipeGen(PackOutput output) {
        super(output);
    }

    GeneratedRecipe
            CONCRETE = createVatRecipe("concrete", b -> (VatMachineRecipeBuilder) b
                    .require(Blocks.SAND.asItem())
                    .require(Blocks.GRAVEL.asItem())
                    .require(TFMGItems.LIMESAND)
                    .require(Fluids.WATER, 250)
                    .output(TFMGFluids.LIQUID_CONCRETE.get(), 1000)
            , mixing()),
            ARC_FURNACE_STEEL = createVatRecipe("arc_furnace_steel", b -> (VatMachineRecipeBuilder) b
                            .require(crushedRawIron())
                            .require(TFMGTags.TFMGItemTags.FLUX.tag)
                            .require(TFMGItems.COAL_COKE_DUST)
                            .output(0.9f,TFMGItems.COAL_COKE_DUST)
                            .output(TFMGFluids.MOLTEN_STEEL.get(), 144)
                            .output(TFMGFluids.MOLTEN_SLAG.get(), 288)
                            .duration(20)
                    , arcBlasting()),
            NEON = createVatRecipe("neon", b -> (VatMachineRecipeBuilder) b
                            .require(TFMGFluids.AIR.get(), 1000)
                            .output(TFMGFluids.NEON.get(), 1)
                            .duration(10)
                    , centrifuge()),
            SULFURIC_ACID = createVatRecipe("sulfuric_acid", b -> (VatMachineRecipeBuilder) b
                    .require(water(), 1000)
                    .require(sulfurDust())
                    .require(sulfurDust())
                    .require(sulfurDust())
                    .require(nitrateDust())
                    .output(sulfuricAcid(), 500)
            , mixing()),
            BRINE = createVatRecipe("brine", b -> (VatMachineRecipeBuilder) b
                    .require(water(), 1000)
                    .output(brine(), 200)
                    .duration(20)
                    .requiresHeat(HeatCondition.HEATED)
            , new VatRecipeParams()),

            RUBBER = createVatRecipe("rubber", b -> (VatMachineRecipeBuilder) b
                            .require(heavyOil(), 250)
                            .require(sulfurDust())
                            .output(rubber())
                            .requiresHeat(HeatCondition.HEATED)
                    ,mixing()),

            NAPHTHA = createVatRecipe("naphtha", b -> (VatMachineRecipeBuilder) b
                            .require(naphtha(), 500)
                            .output(ethylene(), 250)
                            .output(propylene(), 250)
                            .requiresHeat(HeatCondition.HEATED)
                    ,mixing()),

            PLASTIC_FROM_ETHYLENE = createVatRecipe("plastic_from_ethylene", b -> (VatMachineRecipeBuilder) b
                            .require(ethylene(), 500)
                            .output(liquidPlastic(), 500)
                            .requiresHeat(HeatCondition.HEATED)
                    ,mixing()),
            PLASTIC_FROM_PROPYLENE = createVatRecipe("plastic_from_propylene", b -> (VatMachineRecipeBuilder) b
                            .require(propylene(), 500)
                            .output(liquidPlastic(), 500)
                            .requiresHeat(HeatCondition.HEATED)
                    ,mixing()),
            PLASTIC_POLYVINYL_CHLORIDE = createVatRecipe("plastic_from_ethylene_chlorine", b -> (VatMachineRecipeBuilder) b
                            .require(ethylene(), 250)
                            .require(chlorine(), 250)
                            .output(liquidPlastic(), 500)
                            .requiresHeat(HeatCondition.HEATED)
                            ,mixing()),
            ETCHED_CIRCUIT_BOARD = createVatRecipe("etched_circuit_board", b -> (VatMachineRecipeBuilder) b
                            .require(TFMGItems.COATED_CIRCUIT_BOARD)
                            .require(TFMGFluids.SULFURIC_ACID.getSource(), 250)
                            .output(TFMGItems.ETCHED_CIRCUIT_BOARD)
                            .duration(100)
                    , new VatRecipeParams()),
            ALUMINA = createVatRecipe("alumina", b -> (VatMachineRecipeBuilder) b
                            .require(TFMGItems.BAUXITE_POWDER)
                            .require(TFMGItems.BAUXITE_POWDER)
                            .require(TFMGItems.BAUXITE_POWDER)
                            .require(sodiumHydroxide(), 1000)
                            .output(TFMGItems.ALUMINA_POWDER, 2)
                            .output(.5f, TFMGItems.ALUMINA_POWDER)
                            .output(TFMGFluids.RED_MUD.get(), 500)
                            .duration(100)
                            .requiresHeat(HeatCondition.HEATED)
                            ,mixing()),
            RED_MUD_RECYCLING = createVatRecipe("red_mud_recycling", b -> (VatMachineRecipeBuilder) b
                            .require(redMud(), 1000)
                            .output(.35f, Items.IRON_NUGGET)
                            .output(.075f, AllItems.COPPER_NUGGET)
                            .output(.05f, AllItems.ZINC_NUGGET)
                            .output(.01f, Items.GOLD_NUGGET)
                            .duration(40)
                    , mixing()),
            ALUMINUM = createVatRecipe("aluminum", b -> (VatMachineRecipeBuilder) b
                            .require(TFMGItems.ALUMINA_POWDER)
                            .require(TFMGItems.ALUMINA_POWDER)
                            .output(TFMGFluids.MOLTEN_ALUMINUM.get(), 288)
                            .output(TFMGFluids.CARBON_DIOXIDE.get(), 500)
                            .duration(100)
                            .requiresHeat(HeatCondition.HEATED)
                    , electrolysis()),
            SODIUM_HYDROXIDE = createVatRecipe("sodium_hydroxide", b -> (VatMachineRecipeBuilder) b
                            .require(brine(), 1000)
                            .output(chlorine(), 100)
                            .output(sodiumHydroxide(), 100)
                            .duration(20)
                    , electrolysis())
            //DEBUG_5 = createVatRecipe("debug_5", b -> (VatMachineRecipeBuilder) b
            //                .require(Blocks.GOLD_BLOCK.asItem())
            //                .require(Blocks.DIAMOND_BLOCK.asItem())
            //                .require(Blocks.IRON_BLOCK.asItem())
            //                .require(Blocks.COAL_BLOCK.asItem())
            //                .require(TFMGFluids.LIQUID_CONCRETE.getSource(), 1)
            //                .require(TFMGFluids.HEAVY_OIL.getSource(), 1)
            //                .require(TFMGFluids.COOLING_FLUID.getSource(), 1)
            //                .require(TFMGFluids.CRUDE_OIL.getSource(), 1)
            //                .output(TFMGFluids.LIQUID_CONCRETE.get(), 1)
            //                .output(TFMGFluids.HEAVY_OIL.get(), 1)
            //                .output(TFMGFluids.COOLING_FLUID.get(), 1)
            //                .output(TFMGFluids.CRUDE_OIL.get(), 1)
            //                .output(Items.EGG)
            //                .output(Items.ARROW)
            //                .output(Items.DIAMOND)
            //                .output(Items.STRING)
            //        , mixing());
;

    /// ////
    public VatRecipeParams electrolysis() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:electrode");
        params.machines.add("tfmg:electrode");
        params.allowedVatTypes = new ArrayList<>();
        params.allowedVatTypes.add("tfmg:steel_vat");
        params.allowedVatTypes.add("tfmg:firebrick_lined_vat");
        return params;
    }

    public VatRecipeParams mixing() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:mixing");
        params.allowedVatTypes = new ArrayList<>();
        params.allowedVatTypes.add("tfmg:steel_vat");
        params.allowedVatTypes.add("tfmg:firebrick_lined_vat");
        return params;
    }

    public VatRecipeParams centrifuge() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:centrifuge");
        return params;
    }

    public VatRecipeParams freezing() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:freezing");
        return params;
    }

    public VatRecipeParams intenseFreezing() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:freezing");
        params.machines.add("tfmg:freezing");
        params.machines.add("tfmg:freezing");
        return params;
    }

    public VatRecipeParams arcBlasting() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:graphite_electrode");
        params.machines.add("tfmg:graphite_electrode");
        params.machines.add("tfmg:graphite_electrode");
        params.minSize = 9;
        params.allowedVatTypes = new ArrayList<>();
        params.allowedVatTypes.add("tfmg:firebrick_lined_vat");
        return params;
    }
}
