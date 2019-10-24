
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import dist2_interface.Curriculo;

public class ListaDeCurriculos implements Serializable {

    private ArrayList<Curriculo> listaCurriculos;

    public ListaDeCurriculos() {
        this.listaCurriculos = new ArrayList();
    }

    // Adiciona novo currículo a Lista
    public boolean adicionar(Curriculo curriculo) {
        if (listaCurriculos.contains(curriculo)) {
            System.out.println("Currículo já cadastrado no sistema");
            return false;
        } else {
            listaCurriculos.add(curriculo);
            System.out.println("Currículo Cadastrado com sucesso \n");
            return true;
        }
    }

    //Consulta a partir dos filtros
    public List<Curriculo> consultar(String area) {
        List<Curriculo> curriculosFiltered;

        curriculosFiltered = new ArrayList();
        for (Curriculo curriculo : listaCurriculos) {
            if (curriculo.getArea() == area) {
                curriculosFiltered.add(curriculo);
            }
        }
        return curriculosFiltered;
    }
}
