package com.fapethedev.ogine.view.component.panel;

import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.background.LauncherBackground;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import javax.swing.*;
import java.awt.*;

public class LauncherVideoPanel extends JPanel {

    private MediaPlayerFactory factory;
    private EmbeddedMediaPlayer player;

    public LauncherVideoPanel() {
        init();
    }

    private void init()
    {
        factory = new MediaPlayerFactory();
        player = factory.mediaPlayers().newEmbeddedMediaPlayer();
        Canvas canvas = new Canvas();
        player.videoSurface().set(factory.videoSurfaces().newVideoSurface(canvas));

        setLayout(new BorderLayout());
        add(canvas);
    }


    public void play(String path){
        if (player.status().isPlaying()){
            player.controls().stop();
        }

        player.media().prepare(path);
        player.controls().play();
        player.controls().setRepeat(true);
    }

    public void stop(){
        player.controls().stop();
        player.release();
        factory.release();
    }

    public EmbeddedMediaPlayer getPlayer() {
        return player;
    }
}
