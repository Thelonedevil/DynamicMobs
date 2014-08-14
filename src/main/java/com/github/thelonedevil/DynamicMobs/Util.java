package com.github.thelonedevil.DynamicMobs;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class Util {

	public static EntityPlayerMP getPlayerFromUUID(UUID uuid) {
		for (int i = 0; i < MinecraftServer.getServer().getConfigurationManager().playerEntityList.size(); ++i) {
			EntityPlayerMP entityplayermp = (EntityPlayerMP) MinecraftServer.getServer().getConfigurationManager().playerEntityList.get(i);

			if (entityplayermp.getUniqueID().equals(uuid)) {
				return entityplayermp;
			}
		}
		return null;
	}
}
