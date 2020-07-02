package TestsProyecto;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelo.Proyecto;
import modelo.ProyectoDeDesarrollo;
import persistencia.ProyectosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefCrearProyecto extends SpringTest {

    @Given("un listado de proyectos vacio")
    public void unListadoDeProyectosVacio() {
        listadoDeProyectos.deleteAll();
    }

    @When("creo algunos proyectos con nombre e id")
    public void creoAlgunosProyectosConNombreEId(DataTable dt) {
        List<List<String>> lista = dt.asLists();
        Proyecto proyecto;
        for (List<String> proyectos : lista) {
            proyecto = new ProyectoDeDesarrollo(Integer.parseInt(proyectos.get(0)), proyectos.get(1));
            listadoDeProyectos.save(proyecto);
        }
    }

    @Then("el listado de proyectos pasa a tener {int} elementos.")
    public void elProyectoSeCreaYSeAgregaAlListadoDeProyectos(int cantElementos) {
        assertEquals(cantElementos, listadoDeProyectos.findAll().size());
    }

}
