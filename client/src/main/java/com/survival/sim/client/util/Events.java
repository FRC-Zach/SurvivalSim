package com.survival.sim.client.util;

import com.survival.sim.client.gui.Frame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Events {

    private static final Logger logger = LoggerFactory.getLogger(Events.class);

    private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public static void start(){
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                Frame.getInstance().repaint();
            }
            catch (Throwable e){
                logger.error("Error during rendering.", e);
            }
        }, 0, 5, TimeUnit.MILLISECONDS);
    }


}
