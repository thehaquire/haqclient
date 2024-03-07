package com.haq.haqclient.feature

import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraft.init.Blocks
import net.minecraft.world.World
import net.minecraftforge.client.event.RenderWorldLastEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import org.lwjgl.input.Keyboard


class GhostBlock {
    companion object {
        val GHOST_KEY = KeyBinding("Ghost Block", Keyboard.KEY_G, "HaqClient")
        var lastGhostBlock: Long = 0
    }
    @SubscribeEvent
    fun onRenderWorld(event: RenderWorldLastEvent?) {
        if (!GHOST_KEY.isKeyDown) return
        if (Minecraft.getMinecraft().ingameGUI.chatGUI.chatOpen) return
        if (System.currentTimeMillis() - lastGhostBlock < 50) return
        val pos = Minecraft.getMinecraft().thePlayer.rayTrace(5.0, 1f).blockPos
        val w: World = Minecraft.getMinecraft().theWorld
        if (w.getBlockState(pos).block == Blocks.chest || w.getBlockState(pos).block == Blocks.trapped_chest || w.getBlockState(pos).block == Blocks.ender_chest || w.getBlockState(pos).block == Blocks.lever || w.getBlockState(pos).block == Blocks.stone_button || w.getBlockState(pos).block == Blocks.wooden_button) return
        w.setBlockState(pos, Blocks.air.defaultState)
        w.markBlockForUpdate(pos)
        lastGhostBlock = System.currentTimeMillis()
    }
}
