package com.survival.sim.common.entities.interfaces;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

public interface Renderable {

    void render(Graphics2D graphics) throws IOException;
}
