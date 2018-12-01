package com.github.voxelfriend.dyntreescuisine;

import java.util.ArrayList;
import java.util.Collections;

import com.ferreusveritas.dynamictrees.api.TreeBuilder;
import com.ferreusveritas.dynamictrees.systems.dropcreators.DropCreatorHarvest;
import com.ferreusveritas.dynamictrees.trees.TreeFamily;
import com.ferreusveritas.dynamictrees.trees.Species;
import com.github.voxelfriend.dyntreescuisine.trees.TreeCitrus;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModTrees {

	//Sometimes it helps to cache a few blockstates
	public static final IBlockState acaciaLeaves = Blocks.LEAVES2.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.ACACIA);
	public static ArrayList<TreeFamily> citrusTrees = new ArrayList<TreeFamily>();
	
	public static void preInit() {
		
		//Method 1: Create the tree manually
		TreeFamily citrusTree = new TreeCitrus();//All of the heavy lifting is done in the TreeOrange class
		
		//Register all of the trees
		Collections.addAll(citrusTrees, citrusTree);
		citrusTrees.forEach(tree -> tree.registerSpecies(Species.REGISTRY));
	}
	
}
