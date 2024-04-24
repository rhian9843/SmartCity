// StudentController.java

package Controller;

import Model.StudentModel;
import View.StudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentController {
    private StudentModel model;
    private StudentView view;

    public StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;

        view.setSearchButtonListener(new SearchButtonListener());
    }

    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String location = view.getLocationText();
            String fieldOfInterest = view.getFieldOfInterestText();

            List<String> colleges = model.searchColleges(location, fieldOfInterest);
            List<String> libraries = model.searchLibraries(location, fieldOfInterest);

            view.setColleges(colleges);
            view.setLibraries(libraries);
        }
    }
}
