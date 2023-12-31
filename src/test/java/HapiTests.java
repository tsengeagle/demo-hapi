import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.r4.model.Meta;
import org.hl7.fhir.r4.model.Narrative;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.api.Test;

public class HapiTests {
    @Test
    void test_create_resource() {
        Observation observation = new Observation();
        observation.setMeta(new Meta().addProfile("https://twcore.mohw.gov.tw/fhir/StructureDefinition/Observation-laboratoryResult-twcore"));

        Patient patient = new Patient();
        patient.setMeta(new Meta().addProfile("TEST"));
        observation.getSubject().setResource(patient); // 新增reference

        FhirContext fhirContext = new FhirContext(FhirVersionEnum.R4);
        IParser jsonParser = fhirContext.newJsonParser().setPrettyPrint(true);
        System.out.println(jsonParser.encodeResourceToString(observation));

    }
}
