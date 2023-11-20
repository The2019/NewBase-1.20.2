package net.The2019.NewBase.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.client.MinecraftClient;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModuleConfig {
    private static final File configFile = new File(MinecraftClient.getInstance().runDirectory, "config/newbase/modules.json");
    private static final Gson gson = new Gson();
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static boolean loadModuleState(String moduleName) {
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                JsonObject json = gson.fromJson(reader, JsonObject.class);
                if (json != null && json.has(moduleName)) {
                    return json.get(moduleName).getAsBoolean();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true; // Default to true if not found or error occurs
    }

    public static void saveModuleState(String moduleName, boolean state) {
        JsonObject json = new JsonObject();

        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                json = gson.fromJson(reader, JsonObject.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        json.addProperty(moduleName, state);

        try (FileWriter writer = new FileWriter(configFile)) {
            gson.toJson(json, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
