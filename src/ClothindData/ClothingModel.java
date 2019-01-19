package ClothindData;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.File;


public class ClothingModel {

    private String file = "src/ClothindData/semcloth.ttl";

    /**
     * Constructor reading the clothing model.
     */
    public ClothingModel() {
        readModel();
    }


    /**
     * Reads the model
     * @return the model
     */
    public Model readModel() {
        Model model = ModelFactory.createDefaultModel();
        model.read(new File(file).toURI().toString(), "http://www.semanticweb.org/ontologies/2015/02/semcloth.owl", "Turtle");
        return model;
    }
}
