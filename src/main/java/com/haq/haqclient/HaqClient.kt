package com.example.examplemod

import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(modid = HaqClient.MODID, version = HaqClient.VERSION)
class HaqClient {
    @EventHandler
    fun init(event: FMLInitializationEvent?) {
        // some example code
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.unlocalizedName)
    }

    companion object {
        const val MODID = "examplemod"
        const val VERSION = "1.0"
    }
}