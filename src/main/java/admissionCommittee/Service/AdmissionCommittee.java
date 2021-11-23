package admissionCommittee.Service;

import admissionCommittee.DefaultEnrollee;
import admissionCommittee.Faculty;

import java.util.List;
import java.util.Map;

public interface AdmissionCommittee {

    List<Faculty> getFaculties();

    Map<String, List<DefaultEnrollee>> getEnrollees();

    void distributeEnrollees(List<DefaultEnrollee> newDefaultEnrollees);

    void sortEnrolleesByScore();

    void createMapOfApplicants();
}
