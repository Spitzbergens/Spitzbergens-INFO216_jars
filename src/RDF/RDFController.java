package RDF;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.util.Objects;

public class RDFController {

    private Model model;

    private String prefix = "PREFIX schema: <http://schema.org/Date#> " +
            "PREFIX owl:   <http://www.w3.org/2002/07/owl#> " +
            "PREFIX rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX we:    <https://www.auto.tuwien.ac.at/downloads/thinkhome/ontology/WeatherOntology.owl#> " +
            "PREFIX rdfs:  <http://www.w3.org/2000/01/rdf-schema#> " +
            "PREFIX dbr: <http://dbpedia.org/resource/> " +
            "PREFIX dbp: <http://dbpedia.org/property/> " +
            "PREFIX xml: <http://www.w3.org/XML/1998/namespace> " +
            "PREFIX sc: <http://www.semanticweb.org/ontologies/2015/02/semcloth.owl#> " +
            "BASE <http://www.semanticweb.org/ontologies/2015/02/semcloth.owl> ";

    /**
     * Creating a model
     */
    public RDFController() {
        this.model = ModelFactory.createDefaultModel();
    }


    /**
     * Adds a model to the model in the field.
     *
     * @param model the model to be added.
     */
    public void addModel(Model model) {
        this.model.add(model);
    }

    public ResultSet runQuery(String queryString) {

        queryString = prefix + queryString;
        Query query = null;
        try {
            query = QueryFactory.create(queryString);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        QueryExecution qe = QueryExecutionFactory.create(Objects.requireNonNull(query), model);


        //ResultSetFormatter.out(results);
        return qe.execSelect();
    }

}
