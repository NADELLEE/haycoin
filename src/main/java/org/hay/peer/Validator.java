package org.hay.peer;

import org.hay.protos.core.hayBlock.Block;

public class Validator {
    public static ValidationRule validationRule = ValidationRuleFactory
            .create("Validation");

    public static byte[] start(Block block) {
        return validationRule.start(block);
    }

    public static void stop() {
        validationRule.stop();
    }

    public static boolean validate(Block block) {
        return validationRule.validate(block);
    }
}