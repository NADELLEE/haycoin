package org.hay.overlay.listener;

import org.hay.overlay.message.Message;

public interface ReceiveListener {
    void handleReceive(Message message);
}
