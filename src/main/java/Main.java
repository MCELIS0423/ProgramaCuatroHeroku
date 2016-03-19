

import edu.uniandes.ecos.ase.calculo.CalculoEstadistica;
import edu.uniandes.ecos.ase.dto.ResultadoDTO;
import edu.uniandes.ecos.ase.utilidad.LeerDatosFuenteExterna;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;
import static spark.Spark.get;
/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        
        get("/rangoDesviacionEstandar", (req, res) -> {
            
            List<String> datosLocMethod = new ArrayList<String>();
            List<String> pgsChapter = new ArrayList<String>();
            String retorno;

            Double promedioLogaritmoNatural;
            Double varianza;
            Double desviacionEstandar;
            Double vs;
            Double s;
            Double m;
            Double l;
            Double vl;

            datosLocMethod = LeerDatosFuenteExterna.leerArchivoPlanoSeparacionComa("src/main/resources/archivo/LOC_METHOD.txt");
            pgsChapter = LeerDatosFuenteExterna.leerArchivoPlano("src/main/resources/archivo/PGS_CHAPTER.txt");

            CalculoEstadistica calculoEstadistica = new CalculoEstadistica();

            //Caso de prueba 1
            promedioLogaritmoNatural = calculoEstadistica.promedioLogaritmoNatural(datosLocMethod);
            varianza = calculoEstadistica.varianza(datosLocMethod, promedioLogaritmoNatural);

            desviacionEstandar = calculoEstadistica.desviacionEstandar(varianza);

            vs = calculoEstadistica.verySmall(promedioLogaritmoNatural, desviacionEstandar);
            s = calculoEstadistica.small(promedioLogaritmoNatural, desviacionEstandar);
            m = calculoEstadistica.medium(promedioLogaritmoNatural);
            l = calculoEstadistica.large(promedioLogaritmoNatural, desviacionEstandar);
            vl = calculoEstadistica.veryLarge(promedioLogaritmoNatural, desviacionEstandar);

            ResultadoDTO resultadoDTO = new ResultadoDTO();
            List<ResultadoDTO> listaResultado = new ArrayList<ResultadoDTO>();

            resultadoDTO.setNombre("LOC/Method");
            resultadoDTO.setVs(vs);
            resultadoDTO.setS(s);
            resultadoDTO.setM(m);
            resultadoDTO.setL(l);
            resultadoDTO.setVl(vl);

            listaResultado.add(resultadoDTO);

            //Caso de prueba 2
            promedioLogaritmoNatural = calculoEstadistica.promedioLogaritmoNatural(pgsChapter);
            varianza = calculoEstadistica.varianza(pgsChapter, promedioLogaritmoNatural);
            desviacionEstandar = calculoEstadistica.desviacionEstandar(varianza);

            vs = calculoEstadistica.verySmall(promedioLogaritmoNatural, desviacionEstandar);
            s = calculoEstadistica.small(promedioLogaritmoNatural, desviacionEstandar);
            m = calculoEstadistica.medium(promedioLogaritmoNatural);
            l = calculoEstadistica.large(promedioLogaritmoNatural, desviacionEstandar);
            vl = calculoEstadistica.veryLarge(promedioLogaritmoNatural, desviacionEstandar);

            ResultadoDTO resultadoDTO_ = new ResultadoDTO();

            resultadoDTO_.setNombre("Pgs/Chapter");
            resultadoDTO_.setVs(vs);
            resultadoDTO_.setS(s);
            resultadoDTO_.setM(m);
            resultadoDTO_.setL(l);
            resultadoDTO_.setVl(vl);

            listaResultado.add(resultadoDTO_);

            retorno = "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<style>"
                    + "table, th, td {"
                    + "border: 1px solid black;"
                    + "border-collapse: collapse;"
                    + "}"
                    + "th, td {"
                    + "padding: 5px;"
                    + "text-align: left;"
                    + "}"
                    + "table#t01 {"
                    + "width: 100%;    "
                    + "background-color: #A9BCF5;"
                    + "}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<table id=\"t01\">"
                    + "<tbody>"
                    + "<tr>"
                    + "<th>Nombre</th>"
                    + "<th>Vs</th>"
                    + "<th>S</th>"
                    + "<th>M</th>"
                    + "<th>L</th>"
                    + "<th>Vl</th>"
                    + "</tr>";
            int i = 1;
            for (ResultadoDTO dto : listaResultado) {
                retorno += "<tr>"
                        + "<td>" + dto.getNombre() + i + "</td>"
                        + "<td>" + dto.getVs() + "</td>"
                        + "<td>" + dto.getS() + "</td>"
                        + "<td>" + dto.getM() + "</td>"
                        + "<td>" + dto.getL() + "</td>"
                        + "<td>" + dto.getVl() + "</td>"
                        + "</tr>";
                i++;
            }
            retorno += "</tbody>"
                    + "</table>"
                    + "</body>"
                    + "</html>";

            return retorno;
        });

    }
}
