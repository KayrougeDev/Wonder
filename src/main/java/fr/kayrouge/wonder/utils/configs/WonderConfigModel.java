package fr.kayrouge.wonder.utils.configs;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;

@Modmenu(modId = "wonder")
@Config(name = "wonder-config", wrapperName = "WonderConfig")
public class WonderConfigModel {

    public int anIntOption = 16;
    public boolean aBooleanToggle = false;

    public Choices anEnumOption = Choices.ANOTHER_CHOICE;

    public enum Choices {
        A_CHOICE, ANOTHER_CHOICE;
    }

}
