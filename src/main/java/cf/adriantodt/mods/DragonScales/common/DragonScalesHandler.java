package cf.adriantodt.mods.DragonScales.common;

import org.apache.http.impl.conn.tsccm.WaitingThreadAborter;

import cf.adriantodt.mods.DragonScales.DragonScales;
import cf.adriantodt.mods.DragonScales.Lib;
import cf.adriantodt.mods.DragonScales.api.DragonScalesAPI;
import cf.adriantodt.mods.DragonScales.api.DragonScalesAPI.CauldronRecipe;
import cf.adriantodt.mods.DragonScales.common.blocks.*;
import cf.adriantodt.mods.DragonScales.common.blocks.tile.TileCauldronConstruct;
import cf.adriantodt.mods.DragonScales.common.blocks.tile.TileCombiner;
import cf.adriantodt.mods.DragonScales.common.blocks.tile.TileCrystal;
import cf.adriantodt.mods.DragonScales.common.blocks.tile.TileEntityDragonChest;
import cf.adriantodt.mods.DragonScales.common.items.*;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Dragon Scales Main Handler
 */
public class DragonScalesHandler {
	public static final ToolMaterial DRAGONALLOY_TOOL_MATERIAL = 
			EnumHelper.addToolMaterial("DRAGONSCALE", 10, 2000, 50.0F, 15.0F, 35);
	public static final ArmorMaterial DRAGONSCALES_ARMOR_MATERIAL = 
			EnumHelper.addArmorMaterial("DRAGONSCALE", 75, new int[] { 5, 16, 12, 6 }, 35);
	
	// All Items
	public static Item dragonScale, dragonEssenceShard, dragonMetal, dragonEssenceBottle, infusedStick,
		dragonSword, dragonMultiTool, dragonScepter,
		scalesHelm, scalesChestplate, scalesLeggings, scalesBoots;
	
	// All Blocks
	public static Block modCauldron, cauldronConstruct, essenceCombiner ,dragonBricks, dragonChest, dragonScaleBlock, dragonEssenceOre, dragonCrystal;
	
	public static void registerAll()
	{
		registerBlocks();
		registerItems();
		registerEntities();
		GameRegistry.registerWorldGenerator(new DragonScalesWorldGenerator(), 1);
	}

	private static void registerBlocks()
	{
		//Define ModBlock pattern
		ModBlock.set(DragonScales.tabDragonScales, Lib.MODID, Material.rock);
		
		dragonBricks = new ModBlock("dragonBricks").setHardness(2.0F).setResistance(10.0F).setStepSound(dragonBricks.soundTypePiston);
		GameRegistry.registerBlock(dragonBricks, "dragonBricks");
		
		dragonScaleBlock = new ModBlock("dragonScaleBlock").setHardness(0.8F).setStepSound(dragonScaleBlock.soundTypeCloth);
		GameRegistry.registerBlock(dragonScaleBlock, "dragonScaleBlock");
		
		//dragonEssenceOre = ModBlock.process(new BlockDragonEssenceOre().setHardness(3.0F).setResistance(5.0F).setStepSound(dragonBricks.soundTypePiston), "dragonEssenceOre");
		//GameRegistry.registerBlock(dragonEssenceOre, "dragonEssenceOre");
		
		modCauldron = new BlockModCauldron();
		GameRegistry.registerBlock(modCauldron, "modCauldron");
		
		cauldronConstruct = new BlockCauldronConstruct();
		GameRegistry.registerBlock(cauldronConstruct, "cauldronConstruct");
		GameRegistry.registerTileEntity(TileCauldronConstruct.class, "Tile"+Lib.MODID+"ModelCauldronConstruct");
		
		essenceCombiner = new BlockCombiner();
		GameRegistry.registerBlock(essenceCombiner, "essenceCombiner");
		GameRegistry.registerTileEntity(TileCombiner.class, "Tile"+Lib.MODID+"Combiner");
		
		//dragonChest = ModBlock.process(new BlockDragonChest(), "dragonChest");
		//GameRegistry.registerBlock(dragonChest, ItemBlock.class, "dragonChest");
		//GameRegistry.registerTileEntity(TileEntityDragonChest.class, "dragonchestTileEntity");
		
		dragonCrystal = ModBlock.process(new BlockDragonCrystal(), "dragonCrystal");
		GameRegistry.registerBlock(dragonCrystal, "dragonCrystal");
		GameRegistry.registerTileEntity(TileCrystal.class, "Tile"+Lib.MODID+"DragonCrystal");
	}
	
	private static void registerItems()
	{
		ModItem.set(DragonScales.tabDragonScales, Lib.MODID);

		dragonScale = new ModItemDragonScale("dragonScale", new ItemStack(Items.leather));
		GameRegistry.registerItem(dragonScale, "dragonScale");
		dragonEssenceShard = new ModItemDragonScale("dragonEssenceShard", null);
		GameRegistry.registerItem(dragonEssenceShard, "dragonEssenceShard");
		dragonMetal = new ModItemDragonScale("dragonMetal", new ItemStack(Items.iron_ingot));
		GameRegistry.registerItem(dragonMetal, "dragonMetal");
		dragonEssenceBottle = new ModItemEssenceBottle("dragonEssenceBottle");
		GameRegistry.registerItem(dragonEssenceBottle, "dragonEssenceBottle");
		infusedStick = new ModItem("infusedStick");
		GameRegistry.registerItem(infusedStick, "infusedStick");
		
		dragonSword = ModItem.process(new ItemDragonSword(DRAGONALLOY_TOOL_MATERIAL), "dragonSword");
		GameRegistry.registerItem(dragonSword, "dragonSword");
		dragonMultiTool = ModItem.process(new ItemDragonMulti(DRAGONALLOY_TOOL_MATERIAL), "dragonMultiTool");
		GameRegistry.registerItem(dragonMultiTool, "dragonMultiTool");
		dragonScepter = ModItem.process(new ItemDragonScepter(), "dragonScepter");
		GameRegistry.registerItem(dragonScepter, "dragonScepter");
		
		scalesHelm = ModItem.process(new ItemDragonArmor(DRAGONSCALES_ARMOR_MATERIAL, 0, "scalesHelm"), "scalesHelm");
		GameRegistry.registerItem(scalesHelm, "scalesHelm");
		scalesChestplate = ModItem.process(new ItemDragonArmor(DRAGONSCALES_ARMOR_MATERIAL, 1, "scalesChestplate"), "scalesChestplate");
		GameRegistry.registerItem(scalesChestplate, "scalesChestplate");
		scalesLeggings = ModItem.process(new ItemDragonArmor(DRAGONSCALES_ARMOR_MATERIAL, 2, "scalesLeggings"), "scalesLeggings");
		GameRegistry.registerItem(scalesLeggings, "scalesLeggings");
		scalesBoots = ModItem.process(new ItemDragonArmor(DRAGONSCALES_ARMOR_MATERIAL, 3, "scalesBoots"), "scalesBoots");
		GameRegistry.registerItem(scalesBoots, "scalesBoots");
	}
	
	private static void registerEntities()
	{
		//int entityID = EntityRegistry.findGlobalUniqueEntityId();
		
		//EntityRegistry.registerGlobalEntityID(EntityModDragon.class, "ModDragon", entityID);
		//EntityRegistry.registerModEntity(EntityModDragon.class, "ModDragon", entityID, Lib.MODID, 1, 1, 1);
		//EntityRegistry.addSpawn(EntityModDragon.class, 2, 1, 2, EnumCreatureType.creature, BiomeGenBase.extremeHills);
		//EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, 0x000000, 0x000000));
	}
	
	public static void registerRecipes()
	{
		DragonScalesAPI.cauldronRecipes.add(new CauldronRecipe(new ItemStack(Items.leather), 3, new ItemStack(dragonScale)));
		DragonScalesAPI.cauldronRecipes.add(new CauldronRecipe(new ItemStack(Items.gold_ingot), 3, new ItemStack(dragonMetal)));
		DragonScalesAPI.cauldronRecipes.add(new CauldronRecipe(new ItemStack(Items.emerald), 3, new ItemStack(dragonCrystal)));
		DragonScalesAPI.cauldronRecipes.add(new CauldronRecipe(new ItemStack(Items.glass_bottle), 1, new ItemStack(dragonEssenceBottle)));
		DragonScalesAPI.cauldronRecipes.add(new CauldronRecipe(new ItemStack(Items.stick), 0, new ItemStack(infusedStick)));
		DragonScalesAPI.cauldronRecipes.add(
			new CauldronRecipe(new ItemStack(Blocks.brick_block), 1, new ItemStack(dragonBricks)) {
				public ItemStack getOutput(ItemStack input, int essentiaLevel) {
					ItemStack output = super.getOutput(input, essentiaLevel);
					output.stackSize = input.stackSize;
					return output;
				}
				
				public int getEssentiaCost(ItemStack input, int essentiaLevel)
				{
					return MathHelper.clamp_int((int)((float)(input.stackSize / 64) * 3)+1, 1, 3);
				}
				
				public int getItemCost(ItemStack input, int essentiaLevel)
				{
					return input.stackSize;
				}
			}
		);
		DragonScalesAPI.cauldronRecipes.add(
				new CauldronRecipe(new ItemStack(Blocks.soul_sand), 1, new ItemStack(Blocks.end_stone)) {
					public ItemStack getOutput(ItemStack input, int essentiaLevel) {
						ItemStack output = super.getOutput(input, essentiaLevel);
						output.stackSize = MathHelper.clamp_int(input.stackSize,0,16);
						return output;
					}
					
					public int getEssentiaCost(ItemStack input, int essentiaLevel)
					{
						return MathHelper.clamp_int((int)((float)(input.stackSize / 16) * 3)+1, 1, 3);
					}
					
					public int getItemCost(ItemStack input, int essentiaLevel)
					{
						return MathHelper.clamp_int(input.stackSize,0,16);
					}
				}
			);
		
		GameRegistry.addShapelessRecipe(new ItemStack(dragonEssenceBottle), new ItemStack(Items.potionitem,1,0), new ItemStack(dragonEssenceShard));
		
		GameRegistry.addShapedRecipe(
				new ItemStack(dragonScaleBlock,1),
				"DDD","DDD","DDD",
				'D', dragonScale
		);
		
		GameRegistry.addShapelessRecipe(new ItemStack(dragonScale,9), dragonScaleBlock);
		
		GameRegistry.addShapedRecipe(
				new ItemStack(dragonMultiTool,1),
				"MMM","MSM","DSD",
				'M', dragonMetal,
				'S', infusedStick,
				'D', dragonScale
		);
		
		GameRegistry.addShapedRecipe(
				new ItemStack(dragonSword,1), 
				" M "," MD","DS ",
				'M', dragonMetal,
				'S', infusedStick,
				'D', dragonScale
		);
		
		GameRegistry.addShapedRecipe(
				new ItemStack(scalesHelm,1), 
				"DDD","DED","   ",
				'D', dragonScale,
				'E', dragonEssenceBottle.setContainerItem(Items.glass_bottle)
		);
		
		GameRegistry.addShapedRecipe(
				new ItemStack(scalesChestplate,1), 
				"DED","DDD","DDD",
				'D', dragonScale,
				'E', dragonEssenceBottle.setContainerItem(Items.glass_bottle)
		);
		
		GameRegistry.addShapedRecipe(
				new ItemStack(scalesLeggings,1), 
				"DDD","DED","D D",
				'D', dragonScale,
				'E', dragonEssenceBottle.setContainerItem(Items.glass_bottle)
		);
		
		GameRegistry.addShapedRecipe(
				new ItemStack(scalesBoots,1), 
				"E E","D D","D D",
				'D', dragonScale,
				'E', dragonEssenceBottle.setContainerItem(Items.glass_bottle)
		);
		
		GameRegistry.addShapedRecipe(
				new ItemStack(dragonScepter,1), 
				"MMD"," SD","DSE",
				'D', dragonScale,
				'M', dragonMetal,
				'S', infusedStick,
				'E', dragonEssenceBottle.setContainerItem(Items.glass_bottle)
		);
	}
}
