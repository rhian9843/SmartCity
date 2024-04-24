package Controller;

import Model.JobSeekerModel;
import View.JobSeekerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class JobSeekerController {
    private JobSeekerModel model;
    private JobSeekerView view;

    public JobSeekerController(JobSeekerModel model, JobSeekerView view) {
        this.model = model;
        this.view = view;

        view.setSearchButtonListener(new LoggingDecorator(new SearchButtonListener()));
        view.addApplyButtonListener(new LoggingDecorator(new ApplyButtonListener()));
    }

    private class JobSeekerControllerDecorator implements ActionListener {
        protected ActionListener listener;

        public JobSeekerControllerDecorator(ActionListener listener) {
            this.listener = listener;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            listener.actionPerformed(e);
        }
    }

    private class LoggingDecorator extends JobSeekerControllerDecorator {
        public LoggingDecorator(ActionListener listener) {
            super(listener);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Logging functionality
            System.out.println("Action performed: " + e.getActionCommand());
            // Delegate the action to the original listener
            listener.actionPerformed(e);
        }
    }

    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Search button logic
            String location = view.getLocationText();
            String fieldOfInterest = view.getFieldOfInterestText();
            List<String> jobOpportunities = model.searchJobs(location, fieldOfInterest);
            view.setJobOpportunities(jobOpportunities);
        }
    }

    private class ApplyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(view, "Application successful!");
        }
    }
}
