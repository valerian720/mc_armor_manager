package ru.mrv.ArmorManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum BlockedItems {
	v20("FURNACE"),
    v21("CHEST"),
    v22("TRAPPED_CHEST"),
    v23("BEACON"),
    v24("DISPENSER"),
    v25("DROPPER"),
    v26("HOPPER"),
    v27("WORKBENCH"), 
    v29w("ENCHANTMENT_TABLE"),
    v29q("ENDER_CHEST"),
    v2q("ANVIL"),
    v2w("BED_BLOCK"),
    v2e("FENCE_GATE"),
    v2r("SPRUCE_FENCE_GATE"),
    v2t("BIRCH_FENCE_GATE"),
    v2y("ACACIA_FENCE_GATE"),
    v2u("JUNGLE_FENCE_GATE"),
    v2i("DARK_OAK_FENCE_GATE"),
    v2o("IRON_DOOR_BLOCK"),
    v2p("WOODEN_DOOR"),
    v2l("SPRUCE_DOOR"),
    v2k("BIRCH_DOOR"),
    v2j("JUNGLE_DOOR"),
    v2h("ACACIA_DOOR"),
    v2g("DARK_OAK_DOOR"),
    v2f("WOOD_BUTTON"),
    v2d("STONE_BUTTON"),
    v2sq("TRAP_DOOR"),
    v2sw("IRON_TRAPDOOR"),
    v2ae("DIODE_BLOCK_OFF"),
    v2ar("DIODE_BLOCK_ON"),
    v2z("REDSTONE_COMPARATOR_OFF"),
    v2x("REDSTONE_COMPARATOR_ON"),
    v2c("FENCE"),
    v2v("SPRUCE_FENCE"),
    v2b("BIRCH_FENCE"),
    v2n("JUNGLE_FENCE"),
    v2m("DARK_OAK_FENCE"),
    v2qq("ACACIA_FENCE"),
    v2ww("NETHER_FENCE"),
    v2ee("BREWING_STAND"),
    v2sd("CAULDRON"),
    v2fg("SIGN_POST"),
    v2gh("WALL_SIGN"),
    v2hj("SIGN"),
    v2wj("LEVER"),
    v2yr("BLACK_SHULKER_BOX"),
    v2wd("BLUE_SHULKER_BOX"),
    v2ed("BROWN_SHULKER_BOX"),
    v2ds("CYAN_SHULKER_BOX"),
    v2eda("GRAY_SHULKER_BOX"),
    v2zas("GREEN_SHULKER_BOX"),
    v2zx("LIGHT_BLUE_SHULKER_BOX"),
    v2zxc("LIME_SHULKER_BOX"),
    v2zzx("MAGENTA_SHULKER_BOX"),
    v2sdd("ORANGE_SHULKER_BOX"),
    v2sx("PINK_SHULKER_BOX"),
    vxzs2("PURPLE_SHULKER_BOX"),
    vs2("RED_SHULKER_BOX"),
    vxs2("SILVER_SHULKER_BOX"),
    vx2("WHITE_SHULKER_BOX"),
    vz2("YELLOW_SHULKER_BOX"),
	;
	
	///////////////////////////
	private static final List<String> Values;
	
	private final String value;
	
	static {
		Values = new ArrayList<>();
		for (BlockedItems BlockedItems : BlockedItems.values()) {
			Values.add(BlockedItems.value);
		} 
	}
	
	private BlockedItems(String value) { 
		this.value = value;
	}
	
	
	public static List<String> getValues() {
		return Collections.unmodifiableList(Values);
	}
	
}
