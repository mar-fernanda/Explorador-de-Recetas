package core.recetas.explorador_de_recetas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ControladorRecetas {

    private static final String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
    private static final Map<String, String[]> recetasConIngredientes = new HashMap<>();

    public ControladorRecetas() {
        recetasConIngredientes.put("Pizza", new String[]{"Pan", "Salsa de tomate", "Queso", "Pepperoni"});
        recetasConIngredientes.put("Espagueti", new String[]{"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"});
        recetasConIngredientes.put("Lasaña", new String[]{"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"});
    }

    @RequestMapping("/recetas")
    public String obtenerTodasLasRecetas(Model modelo) {
        modelo.addAttribute("listaRecetas", listaRecetas);
        return "recetas";
    }

    @RequestMapping("/recetas/{nombre}")
    public String obtenerRecetaPorNombre(@PathVariable("nombre") String nombre, Model modelo) {
        String nombreNormalizado = nombre.trim();

        if (!recetasConIngredientes.containsKey(nombreNormalizado)) {
            modelo.addAttribute("nombreReceta", null);
            modelo.addAttribute("ingredientes", null);
        } else {
            modelo.addAttribute("nombreReceta", nombreNormalizado);
            modelo.addAttribute("ingredientes", recetasConIngredientes.get(nombreNormalizado));
        }

        return "detalleReceta";
    }
}