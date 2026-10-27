package dwes.batallaspokemons;


import org.springframework.core.io.ClassPathResource;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PokemonLector {

    public List<Pokemon> cargarPokemon(){
        ClassPathResource recurso = new ClassPathResource("data/pokemon.json");
        ObjectMapper mapper = new ObjectMapper();

        try(InputStream entrada = recurso.getInputStream()){

            return mapper.readValue(entrada, new TypeReference<List<Pokemon>>() {
            });

        } catch (Exception e) {

            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}