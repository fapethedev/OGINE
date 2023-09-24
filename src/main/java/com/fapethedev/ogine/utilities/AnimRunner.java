package com.fapethedev.ogine.utilities;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class AnimRunner {

	public static void animateZoom(JPanel panel, int targetSize) {
        int initialSize = panel.getWidth();
        int stepCount = 50;
        int stepDelay = 20;

        int stepSize = (targetSize - initialSize) / stepCount;

        Timer timer = new Timer(stepDelay, new ActionListener() {
            int currentSize = initialSize;
            int step = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                currentSize += stepSize;
                panel.setPreferredSize(new Dimension(currentSize, currentSize));
                panel.revalidate();
                panel.repaint();

                step++;

                if (step >= stepCount) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
    }
}
