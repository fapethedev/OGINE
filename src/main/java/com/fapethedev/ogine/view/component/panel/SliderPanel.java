package com.fapethedev.ogine.view.component.panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SliderPanel extends JPanel
{
    private final java.util.List<Component> list;
    private Timer timer;
    private Component comExit;
    private Component comShow;
    private int currentShowing;
    private boolean animateRight;
    private int animate = 1;

    public static enum AnimationBehavior{
        UP,
        DOWN,
        LEFT,
        RIGHT
    };

    public SliderPanel(AnimationBehavior animationBehavior)
    {
        initComponents();
        list = new ArrayList<>();
        setAnimationBehavior(animationBehavior);
    }

    public int getAnimate()
    {
        return animate;
    }

    public void setAnimationSpeed(int animate)
    {
        this.animate = animate;
    }

    public void setAnimationBehavior(AnimationBehavior animationBehavior)
    {
        switch (animationBehavior)
        {
            case UP, DOWN -> timer = new Timer(0, e -> animateUp());
            case LEFT, RIGHT -> timer = new Timer(0, e -> animateRight());
        }
    }

    public void init(Component... com)
    {
        if (com.length > 0)
        {
            for (Component c : com)
            {
                list.add(c);
                c.setSize(getSize());
                c.setVisible(false);
                this.add(c);
            }

            //  get first component to show on panel when init
            Component show = list.get(0);
            show.setVisible(true);
            show.setLocation(0, 0);
        }
    }

    public void show(int index)
    {
        if (!timer.isRunning())
        {
            if (list.size() >= 2 && index < list.size() && index != currentShowing)
            {
                comShow = list.get(index);
                comExit = list.get(currentShowing);
                animateRight = index < currentShowing;
                currentShowing = index;
                comShow.setVisible(true);
                if (animateRight)
                {
                    comShow.setLocation(-comShow.getWidth(), 0);
                }
                else
                {
                    comShow.setLocation(getWidth(), 0);
                }
                timer.start();
            }
        }
    }

    private void animateRight()
    {
        if (animateRight)
        {
            if (comShow.getLocation().x < 0)
            {
                comShow.setLocation(comShow.getLocation().x + animate, 0);
                comExit.setLocation(comExit.getLocation().x + animate, 0);
            }
            else
            {
                comShow.setLocation(0, 0);
                timer.stop();
                comExit.setVisible(false);
            }

        }
        else
        {
            if (comShow.getLocation().x > 0)
            {
                comShow.setLocation(comShow.getLocation().x - animate, 0);
                comExit.setLocation(comExit.getLocation().x - animate, 0);
            }
            else
            {
                comShow.setLocation(0, 0);
                timer.stop();
                comExit.setVisible(false);
            }
        }
    }

    private void animateUp()
    {
        if (animateRight)
        {
            if (comShow.getLocation().y < 0)
            {
                comShow.setLocation(0, comShow.getLocation().y + animate);
                comExit.setLocation(0, comExit.getLocation().y + animate);
            }
            else
            {
                comShow.setLocation(0, 0);
                timer.stop();
                comExit.setVisible(false);
            }

        }
        else
        {
            if (comShow.getLocation().y > 0)
            {
                comShow.setLocation(0, comShow.getLocation().y - animate);
                comExit.setLocation(0, comExit.getLocation().y - animate);
            }
            else
            {
                comShow.setLocation(0, 0);
                timer.stop();
                comExit.setVisible(false);
            }
        }
    }

    private void initComponents()
    {
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
    }
}
