package br.com.dbc.vemser.jedimasters.repository;

import br.com.dbc.vemser.jedimasters.controller.dto.MonstroDTO;
import br.com.dbc.vemser.jedimasters.repository.dao.MonstroDAO;
import br.com.dbc.vemser.jedimasters.service.Inicializador;
import br.com.dbc.vemser.jedimasters.model.entity.TipoPrint;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.*;
import br.com.dbc.vemser.jedimasters.controller.EntradaValidadaController;
import br.com.dbc.vemser.jedimasters.view.PrintsJogoView;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class MonstroRepository {
    private ArrayList<Monstro> monstrosInimigo;
    private ArrayList<Monstro> cloneMonstros;
    private ArrayList<Monstro> cloneMonstrosInimigo;
    private Inicializador inicializador = new Inicializador();
    @Getter
    private ArrayList<Monstro> monstros = Inicializador.getMonstros();
    private final ObjectMapper objectmapper = new ObjectMapper();

    PrintsJogoView printsJogoView = new PrintsJogoView();
    Scanner input = new Scanner(System.in);
    EntradaValidadaController entradaValidadaController;
    MonstroDAO bancoMonstro = new MonstroDAO();
    public MonstroRepository(){
        this.entradaValidadaController = new EntradaValidadaController(input);
        this.cloneMonstros = criarCopiaProfunda(this.monstros);
        this.cloneMonstrosInimigo = criarCopiaProfunda(this.monstrosInimigo);
    }

    public ArrayList<Monstro> criarCopiaProfunda(ArrayList<Monstro> listaOriginal) {
        ArrayList<Monstro> copia = new ArrayList<>();
        if (listaOriginal != null) {
            for (Monstro m : listaOriginal) {
                copia.add(m.clonar());
            }
        }
        return copia;
    }

    public MonstroDTO criarMonstro(MonstroDTO monstro){

        Monstro monstroCriado = bancoMonstro.salvarMonstro(monstro.getElemento(), monstro.getNome(), monstro.getVida(), monstro.getDanoBase());
        monstros.add(monstroCriado);

        this.cloneMonstros = criarCopiaProfunda(this.monstros);
        listarMonstros();

        return objectmapper.convertValue(monstroCriado, MonstroDTO.class);
    }

    public void criarMonstroCrud(){
        printsJogoView.printMonstroController(0, null, TipoPrint.CRIARMONSTRO);

        String nomeMonstro = input.nextLine();

        int vida = entradaValidadaController.validaVida();
        int danoBase = entradaValidadaController.validaDano();
        Monstro monstroNovo = entradaValidadaController.validaElemento(monstros, nomeMonstro, vida, danoBase); // não mais utilizado
        monstros.add(monstroNovo);
        bancoMonstro.salvarMonstro(monstroNovo.getElemento(), monstroNovo.getNome(), monstroNovo.getVida(), monstroNovo.getDanoBase());

        this.cloneMonstros = criarCopiaProfunda(this.monstros);
        listarMonstros();
    }

    public List<Monstro> listarMonstros() {
        Inicializador.limparMonstros();
        bancoMonstro.chamarMonstros();

        this.monstros = inicializador.getMonstros();
        ArrayList<Integer> monstros_ids = bancoMonstro.retornarIndex();

        if (!monstros.isEmpty()) {
            for (int i = 0; i < monstros_ids.size(); i++) {
                printsJogoView.printMonstroController(
                        monstros_ids.get(i),
                        monstros.get(i),
                        TipoPrint.LISTARMONSTROS
                );
            }
        } else {
            printsJogoView.printMonstroController(0, null, TipoPrint.NENHUMMONSTRO);
        }
        return monstros;
    }


    public MonstroDTO atualizarMonstro(Integer id, MonstroDTO monstroAtualizar){
        listarMonstros();

        if(id == 0){
            monstros =  entradaValidadaController.naoVazio(monstros, "atualizar");
            this.cloneMonstros = criarCopiaProfunda(this.monstros);
        } else {
            bancoMonstro.atualizarMonstro(id, monstroAtualizar.getNome(), monstroAtualizar.getVida(), monstroAtualizar.getDanoBase());
        }
        listarMonstros();

        return monstroAtualizar;
    }

    public void deletarMonstro(Integer id){
        listarMonstros();
        if(id == 0) {
            monstros =  entradaValidadaController.naoVazio(monstros, "deletar");
            this.cloneMonstros = criarCopiaProfunda(this.monstros);
        } else {
            bancoMonstro.deletarMonstro(id);
        }
    }

    public void resetarMonstros () {
        this.monstros = criarCopiaProfunda(this.cloneMonstros);
        this.monstrosInimigo = criarCopiaProfunda(this.cloneMonstrosInimigo);
    }

}