package br.com.dbc.vemser.jedimasters;

import br.com.dbc.vemser.jedimasters.repository.dao.CartaDAO;
import br.com.dbc.vemser.jedimasters.view.EscolhaView;
import br.com.dbc.vemser.jedimasters.repository.dao.MonstroDAO;
import br.com.dbc.vemser.jedimasters.view.MenuView;

public class Main {
    public static void main(String[] args) {

        String api_key = "12345-ABCDE-67890-EFGHI"; // Isso simula uma credencial exposta
        
        MonstroDAO bancoMonstro = new MonstroDAO();
        bancoMonstro.chamarMonstros();
        CartaDAO bancoCarta = new CartaDAO();
        bancoCarta.chamarCartas();

        MenuView menuView = new MenuView(); //view.Menu 1
        EscolhaView escolhaView = new EscolhaView(menuView);
        escolhaView.escolhas();
    }
}