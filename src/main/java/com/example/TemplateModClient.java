package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

public class TemplateModClient implements ClientModInitializer {

    public static final KeyMapping TEST_MAPPING = new KeyMapping("test_mapping", GLFW.GLFW_KEY_LEFT_SHIFT, "category.test");

    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(TEST_MAPPING);

        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            LocalPlayer player = minecraft.player;
            if (TEST_MAPPING.consumeClick() && player != null) {
                player.displayClientMessage(Component.literal("Collides?"), false);
            }
        });
    }
}
