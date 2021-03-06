package org.mineacademy.boss.command;

import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.mineacademy.boss.settings.Localization;
import org.mineacademy.fo.ItemUtil;
import org.mineacademy.fo.model.Replacer;

public final class BiomeCommand extends AbstractBossSubcommand {

	public BiomeCommand() {
		super("biome");

		setDescription("Find biome at your location.");
	}

	@Override
	protected void onCommand() {
		checkConsole();

		final Location loc = getPlayer().getLocation();
		final Biome biome = getPlayer().getWorld().getBiome(loc.getBlockX(), loc.getBlockZ());

		tell(Replacer.of(Localization.Commands.BIOME).find("x", "z", "biome").replace(loc.getBlockX(), loc.getBlockZ(), ItemUtil.bountifyCapitalized(biome)));
	}
}