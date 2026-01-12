package br.com.dbc.vemser.jedimasters.controller;

import br.com.dbc.vemser.jedimasters.view.PrintsJogoView;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class PlayMusicController {
    PrintsJogoView printsJogoView;
    private Clip clip = clip = null;;
    private final String PATH_MUSICA_PARTIDA = "Elements/src/Audios/musicaFundoLuta.wav";
    public PlayMusicController() {
        this.printsJogoView = new PrintsJogoView();
    }
    private Clip musicaFundo;

    private void carregarMusicaFundo() {

        if (musicaFundo != null) return;
        try {
            File musicPath = new File(PATH_MUSICA_PARTIDA);
            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);

                musicaFundo = AudioSystem.getClip();
                musicaFundo.open(audioInput);
                musicaFundo.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                printsJogoView.arquivoNaoEncontrado();
            }
        } catch (Exception e) {
            printsJogoView.printPlayMusic(e);
        }
    }

    public void tocarSom(String location){
        try {
            File musicPath = new File(location);
            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clipEfeito = AudioSystem.getClip();
                clipEfeito.open(audioInput);
                clipEfeito.start();
            } else {
                printsJogoView.arquivoNaoEncontrado();
            }
        } catch (Exception e) {
            printsJogoView.printPlayMusic(e);
        }
    }


    public void somInicioPartida(){
        carregarMusicaFundo();
        if (musicaFundo != null && !musicaFundo.isRunning()) {
            musicaFundo.setFramePosition(0);
            musicaFundo.start();
        }
    }

    public void pararSom(){
        if (musicaFundo != null && musicaFundo.isRunning()) {
            musicaFundo.stop();
            musicaFundo.close();
            musicaFundo = null;
        }
    }

    public void somFimPartida(){
        tocarSom("Elements/src/Audios/corrida-cartoon-run.wav");
    }

    public void somAtaque(){
        tocarSom("Elements/src/Audios/golpe-corto.wav");
    }
    public void somRegenerar(){
        tocarSom("Elements/src/Audios/mario-mushroom.wav");
    }

    public void somUsarPocao(){
        tocarSom("Elements/src/Audios/glass3-random.wav");
    }

    public void somSono(){
        tocarSom("Elements/src/Audios/sleep.wav");
    }

}
