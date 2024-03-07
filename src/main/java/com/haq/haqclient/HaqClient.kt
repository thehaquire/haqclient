package com.example.examplemod

import com.haq.haqclient.feature.ChatCommands
import com.haq.haqclient.feature.GhostBlock
import com.haq.haqclient.feature.Terminals
import net.minecraft.init.Blocks
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = HaqClient.MODID, version = HaqClient.VERSION, updateJSON = HaqClient.UPDATEVERSION)
class HaqClient {

    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        GhostBlock.GHOST_KEY.let {
            ClientRegistry.registerKeyBinding(it)
        }
    }
    @EventHandler
    fun init(event: FMLInitializationEvent?) {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this)
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(GhostBlock())
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(ChatCommands())
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(Terminals())
    }

    companion object {
        const val MODID = "haqclient"
        const val VERSION = "1.0.0"
        const val UPDATEVERSION = "https://raw.githubusercontent.com/thehaquire/haqclient/master/src/main/resources/update.json"
    }
}