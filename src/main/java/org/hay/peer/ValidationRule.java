package org.hay.peer;

import org.hay.protos.core.hayBlock.Block;

public interface ValidationRule {
    public byte[] start(Block block);

    public void stop();

    public boolean validate(Block block);
}
