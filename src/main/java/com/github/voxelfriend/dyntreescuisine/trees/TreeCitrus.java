package com.github.voxelfriend.dyntreescuisine.trees;

import java.util.List;
import java.util.Random;

import com.ferreusveritas.dynamictrees.blocks.BlockDynamicSapling;
import com.ferreusveritas.dynamictrees.blocks.BlockFruit;
import com.ferreusveritas.dynamictrees.systems.dropcreators.DropCreatorSeed;
import com.ferreusveritas.dynamictrees.systems.featuregen.FeatureGenFruit;
import com.ferreusveritas.dynamictrees.trees.TreeFamily;
import com.ferreusveritas.dynamictrees.trees.Species;
import com.github.voxelfriend.dyntreescuisine.ModBlocks;
import com.github.voxelfriend.dyntreescuisine.ModConstants;

import snownee.cuisine.CuisineRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.registries.IForgeRegistry;

public class TreeCitrus extends TreeFamily {
	
	//Species need not be created as a nested class.  They can be created after the tree has already been constructed.
	
//////////////////////////////////////////////////////////////////////////////
	public class TreeCitrusSpecies extends Species {
		
		private static final String speciesName = "citrus";		
		
		public TreeCitrusSpecies(TreeFamily treeFamily) {
			super(new ResourceLocation(treeFamily.getName().getResourceDomain(), speciesName), treeFamily, ModBlocks.citrusLeavesProperties);
			
			setBasicGrowingParameters(0.4f, 10.0f, 1, 4, 0.7f);
			
			envFactor(Type.COLD, 0.75f);
			envFactor(Type.HOT, 0.75f);
			envFactor(Type.DRY, 0.25f);
			envFactor(Type.FOREST, 1.05f);
			
			setupStandardSeedDropping();
			
			generateSeed();
			

		}
		
		@Override
		public boolean isBiomePerfect(Biome biome) {
			return isOneOfBiomes(biome, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MUTATED_JUNGLE, Biomes.MUTATED_JUNGLE_EDGE );
		}
		
		@Override
		public boolean isThick() {
			return false;
		}
		
    }
//////////////////////////////////////////////////////////////////////////////	
	public class TreeOrangeSpecies extends Species {
		
		private static final String speciesName = "orange";
		public final IBlockState unripeFruit;
		public final IBlockState ripeFruit;
		
		public TreeOrangeSpecies(TreeFamily treeFamily) {
			super(new ResourceLocation(treeFamily.getName().getResourceDomain(), speciesName), treeFamily, ModBlocks.citrusLeavesProperties);
			
			//A bit stockier, smaller and slower than your basic oak
			setBasicGrowingParameters(0.4f, 10.0f, 1, 4, 0.7f);
			
			envFactor(Type.COLD, 0.75f);
			envFactor(Type.HOT, 0.75f);
			envFactor(Type.DRY, 0.25f);
			envFactor(Type.FOREST, 1.05f);
			
			setupStandardSeedDropping();
			
			generateSeed();
			
			ripeFruit = ModBlocks.blockFruit.getDefaultState().withProperty(BlockFruit.AGE, 3);
			unripeFruit = ModBlocks.blockFruit.getDefaultState().withProperty(BlockFruit.AGE, 0);
			addGenFeature(new FeatureGenFruit(this, unripeFruit, ripeFruit).setRayDistance(4));
		}
		
		@Override
		public boolean isBiomePerfect(Biome biome) {
			return isOneOfBiomes(biome, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MUTATED_JUNGLE, Biomes.MUTATED_JUNGLE_EDGE );
		}		
    }	
//////////////////////////////////////////////////////////////////////////////
		
	Species orangeSpecies;
	Species limeSpecies;
	
	public TreeCitrus() {
		super(new ResourceLocation(ModConstants.MODID, "citrus"));
		
		//Set up primitive log. This controls what is dropped on harvest.
		setPrimitiveLog(CuisineRegistry.LOG.getDefaultState());

		ModBlocks.citrusLeavesProperties.setTree(this);
	}

	
	@Override
    public void createSpecies() {
        setCommonSpecies(new TreeCitrusSpecies(this));
        orangeSpecies = new TreeOrangeSpecies(this);
        limeSpecies = new TreeOrangeSpecies(this);
    }
	@Override
	public void registerSpecies(IForgeRegistry<Species> speciesRegistry) {
		super.registerSpecies(speciesRegistry);
		speciesRegistry.register(orangeSpecies);
		speciesRegistry.register(limeSpecies);
}

	
}
