package com.github.thelonedevil.DynamicMobs.utlitiy;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

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
