package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class TemplateModClient implements ClientModInitializer {

    public static final KeyMapping TEST_MAPPING = new KeyMapping("test_mapping", GLFW.GLFW_KEY_LEFT_SHIFT, "category.test");

    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(TEST_MAPPING);
    }
}
