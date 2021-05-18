package org.hay.overlay;

import org.hay.overlay.message.Message;

public interface Net {
    void broadcast(Message message);

    void deliver(Message message);
}
